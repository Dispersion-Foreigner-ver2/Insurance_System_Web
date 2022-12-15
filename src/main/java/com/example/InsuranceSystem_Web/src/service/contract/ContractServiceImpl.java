package com.example.InsuranceSystem_Web.src.service.contract;

import com.example.InsuranceSystem_Web.src.dao.contract.ContractDao;
import com.example.InsuranceSystem_Web.src.dao.customer.*;
import com.example.InsuranceSystem_Web.src.dao.insurance.InsuranceDao;
import com.example.InsuranceSystem_Web.src.dto.req.contract.PostCarContractReq;
import com.example.InsuranceSystem_Web.src.dto.req.contract.PostContractReq;
import com.example.InsuranceSystem_Web.src.dto.req.contract.PostFireContractReq;
import com.example.InsuranceSystem_Web.src.dto.req.contract.PostSeaContractReq;
import com.example.InsuranceSystem_Web.src.dto.res.contract.*;
import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import com.example.InsuranceSystem_Web.src.entity.customer.*;
import com.example.InsuranceSystem_Web.src.entity.customer.enums.Disease;
import com.example.InsuranceSystem_Web.src.entity.customer.enums.HouseType;
import com.example.InsuranceSystem_Web.src.entity.customer.enums.Job;
import com.example.InsuranceSystem_Web.src.entity.customer.enums.ShipType;
import com.example.InsuranceSystem_Web.src.entity.insurance.CarInsurance;
import com.example.InsuranceSystem_Web.src.entity.insurance.FireInsurance;
import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import com.example.InsuranceSystem_Web.src.entity.insurance.SeaInsurance;
import com.example.InsuranceSystem_Web.src.exception.contract.*;
import com.example.InsuranceSystem_Web.src.exception.insurance.EmptyInsuranceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService{

    private final ContractDao contractDao;

    private final InsuranceDao insuranceDao;

    private final CustomerDao customerDAO;
    private final MedicalHistoryDao medicalHistoryDao;
    private final HouseDao houseDao;
    private final CarDao carDao;
    private final ShipDao shipDao;

    @Override
    public List<PostContractManageRes> contractManage( ) {
        List<Insurance> insuranceList = insuranceDao.findAll();
        List<PostContractManageRes> postContractManageVoList = new ArrayList<>();

        for (int i = 0; i < insuranceList.size(); i++) {
            List<Contract> contractList = contractDao.findByInsuranceId(insuranceList.get(i).getId());
            String type;
            if (insuranceList.get(i) instanceof CarInsurance) {
                type = "C";
            } else if (insuranceList.get(i) instanceof FireInsurance) {
                type = "F";
            } else {
                type = "S";
            }
            PostContractManageRes postContractManageVo = PostContractManageRes.builder()
                    .insuranceId(insuranceList.get(i).getId())
                    .InsuranceName(insuranceList.get(i).getName())
                    .insuranceType(type)
                    .insuranceResignCount(contractList.size())
                    .build();

            postContractManageVoList.add(postContractManageVo);
        }

        return postContractManageVoList;
    }

    @Override
    public List<Contract> getContractList() {
        List<Contract> contractList = contractDao.findAll();
        return contractList;
    }

    @Override
    public List<GetContractSearchRes> contractSearchAll(Long customerId) {

        List<GetContractSearchRes> getContractSearchVos = new ArrayList<>();

        Optional<Customer> customer = customerDAO.findById(customerId);
        if(customer.isEmpty()){
            throw new NotFoundCustomerException();
        }

        List<Contract> contractList = contractDao.findByCustomer(customer.get());
        if(contractList.size() !=0){
            for(int i=0; i<contractList.size(); i++){
                GetContractSearchRes getContractSearchVo = GetContractSearchRes.of(contractList.get(i));
                getContractSearchVos.add(getContractSearchVo);
            }
        }

        return getContractSearchVos;
    }

    @Override
    public GetContractSearchRes contractSearch(Long contractId) {
        Optional<Contract> contract = contractDao.findById(contractId);
        if(contract.isEmpty()){
            throw new NotFoundContractException();
        }
        return GetContractSearchRes.of(contract.get());
    }

    @Override
    public DeleteContractTerminateRes contractTerminate(Long contractId) {
        Optional<Contract> contract = contractDao.findById(contractId);
        if(contract.isEmpty()){
            throw new NotFoundContractException();
        }

        String name = contract.get().getInsurance().getName();
        contractDao.delete(contract.get());

        return DeleteContractTerminateRes.builder()
                .message(name+"보험 계약 해지가 완료되었습니다.")
                .localDate(LocalDate.now())
                .build();
    }

    @Override
    @Transactional
    public PostContractConclusionRes contractConclusion(PostContractReq postContractDto) {
        Optional<Insurance> insurance = insuranceDao.findById(postContractDto.getInsuranceId());
        if(insurance.isEmpty()){
            throw new EmptyInsuranceException();
        }

        int money = getMoney(insurance.get());
        Customer customer = saveCustomer(postContractDto);
        saveMedicalHistory(customer,postContractDto);

        if(postContractDto instanceof PostCarContractReq){
            saveCar(customer, (PostCarContractReq) postContractDto);
        }else if(postContractDto instanceof PostSeaContractReq){
            saveShip(customer, (PostSeaContractReq) postContractDto);
        }else if(postContractDto instanceof PostFireContractReq){
            saveHouse(customer, (PostFireContractReq) postContractDto);
        }

        try{
            Contract contract = Contract.builder()
                    .insurancePrice(money)
                    .premiumRate(insurance.get().getPremium())
                    .compensationAmount(0)
                    .contractDate(LocalDate.now())
                    .underWrite(false)
                    .pay(false)
                    .customer(customer)
                    .insurance(insurance.get())
                    .build();
            contractDao.save(contract);

            return PostContractConclusionRes.builder()
                    .message("계약서 작성이 완료되었습니다. 인수 심사 후 최종 가입 여부가 결정됩니다.")
                    .contractId(contract.getContractId())
                    .build();

        }catch(Exception e){
             throw new FailedContractSaveException();
        }

    }

    private int getMoney(Insurance insurance) {
        int money = 0;
        if (insurance instanceof CarInsurance) {
            money = ((CarInsurance) insurance).getCarDamageBasicMoney() + ((CarInsurance) insurance).getHumanDamageBasicMoney();
        } else if (insurance instanceof FireInsurance) {
            money = ((FireInsurance) insurance).getBuildingDamageBasicMoney()
                    +((FireInsurance) insurance).getHumanDamageBasicMoney()
                    +((FireInsurance) insurance).getSurroundingDamageBasicMoney();
        } else if (insurance instanceof SeaInsurance) {
            money = ((SeaInsurance) insurance).getGeneralDamageBasicMoney() + ((SeaInsurance) insurance).getRevenueDamageBasicMoney();
        }
        return money;
    }

    private Customer saveCustomer(PostContractReq postContractDto) {
        boolean sex = false;
        if (postContractDto.getCustomerSex()== 1) {
            sex = true;
        }
        Customer customer =Customer.builder()
                .name(postContractDto.getName())
                .SSN(postContractDto.getSsn())
                .address(postContractDto.getAddress())
                .phoneNumber(postContractDto.getPhoneNum())
                .email(postContractDto.getEmail())
                .job(Job.values()[postContractDto.getJob()-1])
                .account(postContractDto.getAccount())
                .joinDate(LocalDate.now())
                .sex(sex)
                .build();
        customerDAO.save(customer);
        return customer;
    }

    private void saveMedicalHistory(Customer customer, PostContractReq postContractDto) {
        boolean cureComplete = false;  // 치료 유무
        if(postContractDto.getCureComplete() == 1){
            cureComplete = true;
        }

        MedicalHistory medicalHistory = MedicalHistory.builder()
                .cureComplete(cureComplete)
                .historyYear(postContractDto.getCustomerMedicalYear())
                .MyDisease(Disease.values()[postContractDto.getDiseaseNum() - 1])
                .customer(customer)
                .build();
        medicalHistoryDao.save(medicalHistory);
    }

    private void saveHouse(Customer customer, PostFireContractReq postContractDto) {
        House house = House.builder()
                .houseType(HouseType.values()[postContractDto.getHouseType()-1])
                .price(postContractDto.getHousePrice())
                .customer(customer)
                .build();
        houseDao.save(house);
    }

    private void saveShip(Customer customer, PostSeaContractReq postSeaContractDto){
        Ship ship = Ship.builder()
                .shipNum(postSeaContractDto.getShipNum())
                .year(postSeaContractDto.getYear())
                .price(postSeaContractDto.getPrice())
                .shipType(ShipType.values()[postSeaContractDto.getShipType()-1])
                .customer(customer)
                .build();
        shipDao.save(ship);
    }

    private void saveCar(Customer customer, PostCarContractReq postCarContractDto){
        Car car = Car.builder()
                .carNum(postCarContractDto.getCarNum())
                .year(postCarContractDto.getYear())
                .displacement(postCarContractDto.getDisplacement())
                .price(postCarContractDto.getPrice())
                .customer(customer)
                .build();
        carDao.save(car);
    }

    @Override
    public List<GetUnderWriteRes> getUnderWriteAll() {
        List<Contract> contract = contractDao.findAll();

        List<GetUnderWriteRes> arr = new ArrayList<>();
        if(contract.size()!=0){
            for(int i=0; i<contract.size(); i++){
                GetUnderWriteRes getUnderWriteDto = GetUnderWriteRes.of(contract.get(i));
                arr.add(getUnderWriteDto);
            }
        }
        return arr;
    }

    @Override
    public List<GetUnderWriteRes> getUnderWrites(Long customerId) {
        List<GetUnderWriteRes> arr = new ArrayList<>();

        Optional<Customer> customer = customerDAO.findById(customerId);
        if(customer.isEmpty()){
            throw new NotFoundCustomerException();
        }

        List<Contract> contract = contractDao.findByCustomer(customer.get());
        if(contract.size() == 0){
            throw new EmptyCustomerContractException();
        }

        if(contract.size()!=0){
            for(int i=0; i<contract.size(); i++){
                GetUnderWriteRes getUnderWriteDto = GetUnderWriteRes.of(contract.get(i));
                arr.add(getUnderWriteDto);
            }
        }
        return arr;
    }

    @Override
    public GetUnderWriteRes getUnderWrite(Long contractId) {
        Optional<Contract> contract = contractDao.findById(contractId);
        if(contract.isEmpty()){
            throw new NotFoundContractException();
        }
        GetUnderWriteRes getUnderWriteDto = GetUnderWriteRes.of(contract.get());
        return getUnderWriteDto;
    }

    @Override
    public UpdateUnderWriteRes updateUnderWrite(Long contractId) {
        Optional<Contract> contract = contractDao.findById(contractId);
        if(contract.isEmpty()){
            throw new NotFoundContractException();
        }

        // 예외 처리 하기


        contract.get().setUnderWrite(true);
        contractDao.save(contract.get());

        MedicalHistory medicalHistory = medicalHistoryDao.findByCustomer(contract.get().getCustomer());
        return UpdateUnderWriteRes.of(contract.get(),medicalHistory);
    }

}




