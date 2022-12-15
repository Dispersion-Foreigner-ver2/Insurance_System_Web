package com.example.InsuranceSystem_Web.src.service.customer;

import com.example.InsuranceSystem_Web.src.dao.customer.CustomerDao;
import com.example.InsuranceSystem_Web.src.dao.customer.MedicalHistoryDao;
import com.example.InsuranceSystem_Web.src.dao.insurance.InsuranceDao;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import com.example.InsuranceSystem_Web.src.dto.res.customer.GetCustomerCountRes;
import com.example.InsuranceSystem_Web.src.dto.res.customer.GetCustomerRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDAO;
    private final MedicalHistoryDao medicalHistoryDao;
    private final InsuranceDao insuranceDao;


    @Override
    public GetCustomerCountRes readCustomerCount() {
        List<Customer> customerList = customerDAO.findAll();

        int ThisMonthCustomerCount = 0;
        int ThisMonthNotPayCustomerCount = 0;

        if (customerList.size() != 0) {
            for (int i = 0; i < customerList.size(); i++) {
                if (customerList.get(i).getId() != null) ThisMonthCustomerCount++;
                else ThisMonthNotPayCustomerCount++;
            }
        }

        return GetCustomerCountRes.builder()
                .TotalCustomerCount(customerList.size())
                .ThisMonthCustomerCount(ThisMonthCustomerCount)
                .ThisMonthNotPayCustomerCount(ThisMonthNotPayCustomerCount)
                .build();
    }

    @Override
    public List<GetCustomerRes> readDetailCustomer() {
        List<Customer> customerList = customerDAO.findAll();
        List<Insurance> insuranceList = insuranceDao.findAll();
        List<GetCustomerRes> getCustomerVoList = new ArrayList<>();

        for (int i = 0; i < customerList.size(); i++) {
            GetCustomerRes getCustomerVo = GetCustomerRes.builder()
                    .customerId(customerList.get(i).getId())
                    .ssn(customerList.get(i).getSSN())
                    .address(customerList.get(i).getAddress())
                    .phoneNumber(customerList.get(i).getPhoneNumber())
                    .insuranceName(insuranceList.get(i).getName())
                    .build();

            getCustomerVoList.add(getCustomerVo);
        }
        return getCustomerVoList;


    }



//    public ArrayList<Customer> getTotalCustomer() {
//        return this.customerDAO.getCustomerList();
//    }
//
//
//    public int totalCustomerCount() {
//        return this.customerDAO.getSize();
//    }
//
//    //이번 달 가입한 고객 수 구하기
//    public int thisMonthCustomerCount() {
//        int count = 0;
//        Date date = new Date();
//        Calendar calendarToday = Calendar.getInstance();
//        calendarToday.setTime(date);
//
//        Calendar customerJoinDate = Calendar.getInstance();
//        for (Customer customer : customerDAO.getCustomerList()) {
//            customerJoinDate.setTime(customer.getJoinDate());
//            if (calendarToday.get(Calendar.YEAR) == customerJoinDate.get(Calendar.YEAR)
//                    && calendarToday.get(Calendar.MONTH) == customerJoinDate.get(Calendar.MONTH)) {
//                count++;
//            }
//        }
//
//        return count;
//    }
//
//
//    public String getCustomerName(int customerId) {
//        Customer customer = this.customerDAO.get(customerId);
//        if (customer == null) {
//            return null;
//        } else {
//            return customer.getName();
//        }
//    }
//
//    public Customer getCustomer(int customerId) {
//        Customer customer = this.customerDAO.get(customerId);
//        if (customer == null) {
//            return null;
//        } else {
//            return customer;
//        }
//    }
//
//    @Transactional
//    public Customer joinCustomer(CustomerJoinForm customerJoinForm) {
//
//        Customer customer = new Customer();
//
//
////
//        customer.setId(setCustomerId());
//        customer.setName(customerJoinForm.getName());
//        customer.setSSN(customerJoinForm.getSsn());
//        customer.setAddress(customerJoinForm.getAddress());
//        customer.setPhoneNumber(customerJoinForm.getPhoneNum());
//        customer.setEmail(customerJoinForm.getEmail());
//        customer.setAccount(customerJoinForm.getAccount());
//        customer.setJoinDate(Timestamp.valueOf(LocalDateTime.now()));

//        if (customerSex== 1) {
//            customer.setSex(true);
//        } else if (customerSex == 2) {
//            customer.setSex(false);
//        }
//
//        customer.setJob(Customer.Job.values()[customerJob - 1]);
//        customer.setAge(customerAge);
//
//
//        MedicalHistory medicalHistory = new MedicalHistory();
//
//        medicalHistory.setCustomerId(customer.getId());
//        medicalHistory.setMyDisease(MedicalHistory.Disease.values()[customerDisease - 1]);
//        if (customerDisease != 5) {
//            medicalHistory.setHistoryYear(customerHistoryYear);
//            if (customerCureComplete == 1) {
//                medicalHistory.setCureComplete(true);
//            } else {
//                medicalHistory.setCureComplete(false);
//            }
//        }

//        customer.setMedicalHistory(medicalHistory);
//
//        this.customerDAO.add(customer);
//
//        return customer;
//    }
//
//    public int setCustomerId() {
//        int customerId = 1;
//        while (true) {
//            if (customerDAO.get(customerId) == null) {
//                return customerId;
//            } else {
//                customerId++;
//            }
//        }
//    }
//
//    public void setCustomerCar(Customer customer, int carNum, int year, int displacement, int price) {
//        Car car = new Car();
//        car.setCustomerId(customer.getId());
//        car.setCarNum(carNum);
//        car.setYear(year);
//        car.setDisplacement(displacement);
//        car.setPrice(price);
//
//        customer.setCar(car);
//        this.customerDAO.update(customer);
//    }
//
//    public void setCustomerHouse(Customer customer, int houseType, int housePrice) {
//        House house = new House();
//        house.setCustomerId(customer.getId());
//        house.setHouseType(House.HouseType.values()[houseType - 1]);
//        house.setPrice(housePrice);
//
//        customer.setHouse(house);
//
//        this.customerDAO.update(customer);
//    }
//
//    public void setCustomerSea(Customer customer, int shipNum, int year, int price, int shipType) {
//        Ship ship = new Ship();
//        ship.setShipNum(shipNum);
//        ship.setYear(year);
//        ship.setPrice(price);
//        ship.setShipType(Ship.ShipType.values()[shipType - 1]);
//
//        customer.setShip(ship);
//        this.customerDAO.update(customer);
//    }
//
//
//    public boolean deleteCustomer(int customerId) {
//        return this.customerDAO.delete(customerId);
//    }
//
//
//    public boolean updateCustomer(int customerId, String address, String phoneNum, String email) {
//        Customer customer = this.customerDAO.get(customerId);
//        if (customer == null) {
//            return false;
//        }
//        customer.setAddress(address);
//        customer.setPhoneNumber(phoneNum);
//        customer.setEmail(email);
//
//        this.customerDAO.update(customer);
//        return true;
//    }
}
