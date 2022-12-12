package com.example.InsuranceSystem_Web.src.service.contract;

import com.example.InsuranceSystem_Web.src.dao.contract.ContractDao;
import com.example.InsuranceSystem_Web.src.dao.customer.*;
import com.example.InsuranceSystem_Web.src.dao.insurance.InsuranceDao;
import com.example.InsuranceSystem_Web.src.dto.contract.*;
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
import com.example.InsuranceSystem_Web.src.vo.contract.*;
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
    public List<PostContractManageVo> contractManage( ) {
        List<Insurance> insuranceList = insuranceDao.findAll();
        List<PostContractManageVo> postContractManageVoList = new ArrayList<>();

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
            PostContractManageVo postContractManageVo = PostContractManageVo.builder()
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
    public List<GetContractSearchVo> contractSearchAll(Long customerId) {

        List<GetContractSearchVo> getContractSearchVos = new ArrayList<>();

        Optional<Customer> customer = customerDAO.findById(customerId);
        if(customer.isEmpty()){
            throw new NotFoundCustomerException();
        }

        List<Contract> contractList = contractDao.findByCustomer(customer.get());
        if(contractList.size() !=0){
            for(int i=0; i<contractList.size(); i++){
                GetContractSearchVo getContractSearchVo = GetContractSearchVo.of(contractList.get(i));
                getContractSearchVos.add(getContractSearchVo);
            }
        }

        return getContractSearchVos;
    }

    @Override
    public GetContractSearchVo contractSearch(Long contractId) {
        Optional<Contract> contract = contractDao.findById(contractId);
        if(contract.isEmpty()){
            throw new NotFoundContractException();
        }
        return GetContractSearchVo.of(contract.get());
    }

    @Override
    public DeleteContractTerminateVo contractTerminate(Long contractId) {
        Optional<Contract> contract = contractDao.findById(contractId);
        if(contract.isEmpty()){
            throw new NotFoundContractException();
        }

        String name = contract.get().getInsurance().getName();
        contractDao.delete(contract.get());

        return DeleteContractTerminateVo.builder()
                .message(name+"보험 계약 해지가 완료되었습니다.")
                .localDate(LocalDate.now())
                .build();
    }

    @Override
    @Transactional
    public PostContractConclusionVo contractConclusion(PostContractDto postContractDto) {
        Optional<Insurance> insurance = insuranceDao.findById(postContractDto.getInsuranceId());
        if(insurance.isEmpty()){
            throw new EmptyInsuranceException();
        }

        int money = getMoney(insurance.get());
        Customer customer = saveCustomer(postContractDto);
        saveMedicalHistory(customer,postContractDto);

        if(postContractDto instanceof PostCarContractDto){
            saveCar(customer, (PostCarContractDto) postContractDto);
        }else if(postContractDto instanceof PostSeaContractDto){
            saveShip(customer, (PostSeaContractDto) postContractDto);
        }else if(postContractDto instanceof PostFireContractDto){
            saveHouse(customer, (PostFireContractDto) postContractDto);
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

            return PostContractConclusionVo.builder()
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

    private Customer saveCustomer(PostContractDto postContractDto) {
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

    private void saveMedicalHistory(Customer customer, PostContractDto postContractDto) {
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

    private void saveHouse(Customer customer, PostFireContractDto postContractDto) {
        House house = House.builder()
                .houseType(HouseType.values()[postContractDto.getHouseType()-1])
                .price(postContractDto.getHousePrice())
                .customer(customer)
                .build();
        houseDao.save(house);
    }

    private void saveShip(Customer customer, PostSeaContractDto postSeaContractDto){
        Ship ship = Ship.builder()
                .shipNum(postSeaContractDto.getShipNum())
                .year(postSeaContractDto.getYear())
                .price(postSeaContractDto.getPrice())
                .shipType(ShipType.values()[postSeaContractDto.getShipType()-1])
                .customer(customer)
                .build();
        shipDao.save(ship);
    }

    private void saveCar(Customer customer, PostCarContractDto postCarContractDto){
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
    public List<GetUnderWriteVo> getUnderWriteAll() {
        List<Contract> contract = contractDao.findAll();

        List<GetUnderWriteVo> arr = new ArrayList<>();
        if(contract.size()!=0){
            for(int i=0; i<contract.size(); i++){
                GetUnderWriteVo getUnderWriteDto = GetUnderWriteVo.of(contract.get(i));
                arr.add(getUnderWriteDto);
            }
        }
        return arr;
    }

    @Override
    public List<GetUnderWriteVo> getUnderWrites(Long customerId) {
        List<GetUnderWriteVo> arr = new ArrayList<>();

        Optional<Customer> customer = customerDAO.findById(customerId);
        if(customer.isEmpty()){
            throw new NotFoundCustomerException();
        }
        List<Contract> contract = contractDao.findByCustomer(customer.get());
        if(contract.size() == 0){
            GetUnderWriteVo getUnderWriteDto = GetUnderWriteVo.builder()
                    .message("해당 고객이 계약을 한 보험이 없습니다.")
                    .build();
            arr.add(getUnderWriteDto);
            return arr;
        }

        if(contract.size()!=0){
            for(int i=0; i<contract.size(); i++){
                GetUnderWriteVo getUnderWriteDto = GetUnderWriteVo.of(contract.get(i));
                arr.add(getUnderWriteDto);
            }
        }
        return arr;
    }

    @Override
    public GetUnderWriteVo getUnderWrite(Long contractId) {
        Optional<Contract> contract = contractDao.findById(contractId);
        if(contract.isEmpty()){
            throw new NotFoundContractException();
        }
        GetUnderWriteVo getUnderWriteDto = GetUnderWriteVo.of(contract.get());
        return getUnderWriteDto;
    }

    @Override
    public UpdateUnderWriteVo updateUnderWrite(Long contractId) {
        Optional<Contract> contract = contractDao.findById(contractId);
        if(contract.isEmpty()){
            throw new NotFoundContractException();
        }

        // 예외 처리 하기


        contract.get().setUnderWrite(true);
        contractDao.save(contract.get());

        MedicalHistory medicalHistory = medicalHistoryDao.findByCustomer(contract.get().getCustomer());
        return UpdateUnderWriteVo.of(contract.get(),medicalHistory);
    }

}




