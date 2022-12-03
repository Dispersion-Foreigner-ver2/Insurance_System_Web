package com.example.InsuranceSystem_Web.service.StaffService;
;
import com.example.InsuranceSystem_Web.src.dao.staff.StaffDAO;
import com.example.InsuranceSystem_Web.src.service.staff.StaffServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StaffServiceImplTest {

    @Autowired
    StaffDAO staffDAO;
    @Autowired
    StaffServiceImpl staffServiceImpl;

    @Test
    void login() {
//        Staff createStaff = staffService.createStaff("1234", "차유상", "981021-111111",
//                true, "yoo7969@naver.com", "010-4389-7969", Department.CompensationManagement, Position.Staff);

//        Staff loginStaff = staffService.login(createStaff.getId(), createStaff.getPassword());

//        Assertions.assertThat(createStaff.getId()).isEqualTo(loginStaff.getId());
    }

    @Test
    void findById() {
//        Staff createStaff = staffService.createStaff("1234", "차유상", "981021-111111",
//                true, "yoo7969@naver.com", "010-4389-7969", Department.CompensationManagement, Position.Staff);

//        Staff findStaff = staffService.getStaff(createStaff.getId());
//
//        Assertions.assertThat(createStaff.getName()).isEqualTo(findStaff.getName());
    }

    @Test
    void updateStaff() {
//        Staff createStaff = staffService.createStaff("1234", "차유상", "981021-111111",
//                true, "yoo7969@naver.com", "010-4389-7969", Department.CompensationManagement, Position.Staff);

//        staffService.updateDepartment(createStaff.getId(), Department.Human);
//
//        Staff updateStaff = staffService.getStaff(createStaff.getId());

//        Assertions.assertThat(Department.Human).isEqualTo(updateStaff.getDepartment());

    }



}
