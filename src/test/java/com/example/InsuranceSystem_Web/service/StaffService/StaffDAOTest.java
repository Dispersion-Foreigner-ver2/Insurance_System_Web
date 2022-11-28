//package com.example.InsuranceSystem_Web.service.StaffService;
//
//
//import com.example.InsuranceSystem_Web.src.entity.staff.Department;
//import com.example.InsuranceSystem_Web.src.entity.staff.Position;
//import com.example.InsuranceSystem_Web.src.entity.staff.Staff;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.transaction.Transactional;
//import java.time.LocalDate;
//
//@SpringBootTest
//class StaffDAOTest {
//
//
//    private final StaffDAO staffDAO;
//
//    @Autowired
//    public StaffDAOTest(StaffDAO staffDAO) {
//        this.staffDAO = staffDAO;
//    }
//
//    @Test
//    @Transactional
//    void save() {
//
//        Staff staff = new Staff();
//        staff.setPosition(Position.Staff);
//        staff.setDepartment(Department.CompensationManagement);
//        staff.setPassword("1234");
//        staff.setName("차유상");
//        staff.setSSN("981021-111111");
//        staff.setGender(true);
//        staff.setPhoneNum("010-4389-7969");
//        staff.setResult(10);
//        staff.setJoinDate(LocalDate.of(2022, 11, 17));
//        staff.setTotalSalary(staff.getPosition().getSalary());
//        staff.setBasicSalary(staff.getPosition().getSalary());
//
//        staffDAO.add(staff);
//
//        Staff findStaff = staffDAO.get(staff.getId());
//
//
//        Assertions.assertThat(staff.getName()).isEqualTo(findStaff.getName());
//    }
//
//}
