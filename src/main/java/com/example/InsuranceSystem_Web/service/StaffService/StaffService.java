package com.example.InsuranceSystem_Web.service.StaffService;

import com.example.InsuranceSystem_Web.dao.StaffDAO.StaffDAO;
import com.example.InsuranceSystem_Web.dto.StaffJoinForm;
import com.example.InsuranceSystem_Web.dto.StaffLoginForm;
import com.example.InsuranceSystem_Web.domain.Staff.Department;
import com.example.InsuranceSystem_Web.domain.Staff.Position;
import com.example.InsuranceSystem_Web.domain.Staff.Staff;
import com.example.InsuranceSystem_Web.exception.staffException.StaffException;
import com.example.InsuranceSystem_Web.exception.staffException.StaffExceptionType;
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


    public Staff login(StaffLoginForm staffLoginForm) throws Exception {
        if (!staffLoginForm.getStaffId().matches("^[0-9]+$")) {
            throw new StaffException(StaffExceptionType.WRONG_TYPE_INPUT);
        }
        Long staffId = Long.parseLong(staffLoginForm.getStaffId());
        Staff loginStaff = staffDAO.get(staffId);
        if (loginStaff != null) {
            if (staffLoginForm.getPassword().equals(loginStaff.getPassword())) {
                return loginStaff;
            } else {
                throw new StaffException(StaffExceptionType.NOT_FOUND_STAFF);
            }
        }else {
            throw new StaffException(StaffExceptionType.NOT_FOUND_STAFF);
        }

    }



    public boolean createStaff(StaffJoinForm staffJoinForm) throws Exception {

        Staff createdStaff = new Staff();

        if (!staffJoinForm.getId().matches("^[0-9]+$")) {
            throw new StaffException(StaffExceptionType.WRONG_TYPE_INPUT);
        }

        Long staffId = Long.parseLong(staffJoinForm.getId());

        createdStaff.setId(staffId);
        createdStaff.setPassword(staffJoinForm.getPw());

        createdStaff.setDepartment(staffJoinForm.getDepartment());
        createdStaff.setPosition(staffJoinForm.getPosition());

        createdStaff.setName(staffJoinForm.getName());
        createdStaff.setSSN(staffJoinForm.getSSN());

        createdStaff.setGender(staffJoinForm.isGender());
        createdStaff.setEmail(staffJoinForm.getEMail());
        createdStaff.setPhoneNum(staffJoinForm.getPhoneNum());
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
