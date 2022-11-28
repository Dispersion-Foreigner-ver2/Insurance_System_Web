package com.example.InsuranceSystem_Web.src.service.staff;

import com.example.InsuranceSystem_Web.src.dao.staff.StaffDAO;
import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffJoinDto;
import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffLoginDto;
import com.example.InsuranceSystem_Web.src.entity.staff.Department;
import com.example.InsuranceSystem_Web.src.entity.staff.Position;
import com.example.InsuranceSystem_Web.src.entity.staff.Staff;
import com.example.InsuranceSystem_Web.src.exception.staffException.StaffException;
import com.example.InsuranceSystem_Web.src.exception.staffException.StaffExceptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service
@Transactional
public class StaffService {

    private final StaffDAO staffDAO;

    @Autowired
    public StaffService(StaffDAO staffDAO) {
        this.staffDAO = staffDAO;
    }

    public ArrayList<Staff> getTotalStaff() {
        return this.staffDAO.getStaffList();
    }


    public Staff login(PostStaffLoginDto postStaffLoginDto) throws Exception {
        if (!postStaffLoginDto.getStaffId().matches("^[0-9]+$")) {
            throw new StaffException(StaffExceptionType.WRONG_TYPE_INPUT);
        }
        Long staffId = Long.parseLong(postStaffLoginDto.getStaffId());
        Staff loginStaff = staffDAO.get(staffId);
        if (loginStaff != null) {
            if (postStaffLoginDto.getPassword().equals(loginStaff.getPassword())) {
                return loginStaff;
            } else {
                throw new StaffException(StaffExceptionType.NOT_FOUND_STAFF);
            }
        }else {
            throw new StaffException(StaffExceptionType.NOT_FOUND_STAFF);
        }

    }



    public boolean createStaff(PostStaffJoinDto postStaffJoinDto) throws Exception {

        Staff createdStaff = new Staff();

        if (!postStaffJoinDto.getId().matches("^[0-9]+$")) {
            throw new StaffException(StaffExceptionType.WRONG_TYPE_INPUT);
        }

        Long staffId = Long.parseLong(postStaffJoinDto.getId());

        createdStaff.setId(staffId);
        createdStaff.setPassword(postStaffJoinDto.getPw());

        createdStaff.setDepartment(postStaffJoinDto.getDepartment());
        createdStaff.setPosition(postStaffJoinDto.getPosition());

        createdStaff.setName(postStaffJoinDto.getName());
        createdStaff.setSSN(postStaffJoinDto.getSSN());

        createdStaff.setGender(postStaffJoinDto.isGender());
        createdStaff.setEmail(postStaffJoinDto.getEMail());
        createdStaff.setPhoneNum(postStaffJoinDto.getPhoneNum());
        createdStaff.setJoinDate(LocalDate.now());



//        createdStaff.setBasicSalary(createdStaff.getPosition().getSalary());
//        createdStaff.setResult(0);
//        createdStaff.setTotalSalary(createdStaff.getPosition().getSalary());

        if (staffDAO.add(createdStaff)) {
            return true;
        } else {
            throw new StaffException(StaffExceptionType.WRONG_JOIN_STAFF);
        }



    }


    public Staff getStaff(long staffId) {
        return staffDAO.get(staffId);
    }

    public void addResult(Staff staff) {
        staff.setResult(staff.getResult() + 1);

        this.staffDAO.update(staff);
    }

    public boolean updateDepartment(long staffId, Department department) {
        Staff staff = staffDAO.get(staffId);
        if (staff == null) {
            return false;
        }
        staff.setDepartment(department);
        staffDAO.update(staff);
        return true;
    }

    public void fireStaff(long staffId) {
        this.staffDAO.delete(staffId);
    }

    public boolean calculateSalary(long staffId, Staff loginStaff) {
        Staff staff = this.staffDAO.get(staffId);

        int workDate = this.calculateWorkDate(staffId);
        int totalSalary = staff.getBasicSalary() + ((workDate/ 365) * 100000) + (staff.getResult() * 50000);

        staff.setTotalSalary(totalSalary);
        loginStaff.setResult(staff.getResult()+1);
        this.staffDAO.update(loginStaff);

        if (this.staffDAO.update(staff)) {
            return true;
        } else {
            return false;
        }


//        최종 월급 = 기본 월급(basicSalary) + 근무일수(count) / 365 * x + 판매 실적(result) * y

    }


    public int calculateWorkDate(long staffId) {
        Staff staff = this.staffDAO.get(staffId);

        Date today = new Date();
        Calendar calendarToday = Calendar.getInstance();
        calendarToday.setTime(today);

        Calendar serviceDay = Calendar.getInstance();
//        serviceDay.setTime(staff.getJoinDate());

        int count = 0;
        while (!serviceDay.after(calendarToday)) {
            serviceDay.add(Calendar.DATE, 1);
            count++;
        }

        return count;

//        최종 월급 = 기본 월급(basicSalary) + 근무일수(count) / 365 * x + 판매 실적(result) * y

    }

    public boolean changePosition(Staff staff, Position position, Staff loginStaff) {
        staff.setPosition(position);
        if (this.staffDAO.update(staff)) {
            this.calculateSalary(staff.getId(), loginStaff);
            return true;
        }
        return false;
    }


}
