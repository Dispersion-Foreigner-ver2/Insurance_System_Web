package com.example.InsuranceSystem_Web.src.service.staff;

import com.example.InsuranceSystem_Web.src.dao.staff.StaffDao;
import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffJoinDto;
import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffLoginDto;
import com.example.InsuranceSystem_Web.src.entity.staff.Department;
import com.example.InsuranceSystem_Web.src.entity.staff.Position;
import com.example.InsuranceSystem_Web.src.entity.staff.Staff;
import com.example.InsuranceSystem_Web.src.exception.staffException.StaffException;
import com.example.InsuranceSystem_Web.src.exception.staffException.StaffExceptionType;
import com.example.InsuranceSystem_Web.src.vo.staff.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Service
//@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffDao staffDAO;

    @Override
    public PostStaffVo login(PostStaffLoginDto postStaffLoginDto) {
        if (!postStaffLoginDto.getStaffId().matches("^[0-9]+$")) {
            return PostStaffVo.builder()
                    .message(StaffExceptionType.WRONG_TYPE_INPUT.getErrorMessage())
                    .build();
        }
        Long staffId = Long.parseLong(postStaffLoginDto.getStaffId());
        Staff loginStaff = staffDAO.findById(staffId).get();
        if (loginStaff.getPassword().equals(postStaffLoginDto.getPassword())) {
            return PostStaffVo.builder()
                    .staffId(staffId)
                    .staffName(loginStaff.getName())
                    .department(loginStaff.getDepartment().getLabel())
                    .build();
        } else {
            return PostStaffVo.builder()
                    .message(StaffExceptionType.NOT_FOUND_STAFF.getErrorMessage())
                    .build();
        }
    }

    @Override
    public PostStaffVo join(PostStaffJoinDto postStaffJoinDto) {
        if (!postStaffJoinDto.getId().matches("^[0-9]+$")) {
            throw new StaffException(StaffExceptionType.WRONG_TYPE_INPUT);
        }

        Long staffId = Long.parseLong(postStaffJoinDto.getId());

        Staff createStaff = Staff.builder()
                .id(staffId)
                .password(postStaffJoinDto.getPw())
                .SSN(postStaffJoinDto.getSSN())
                .email(postStaffJoinDto.getEMail())
                .name(postStaffJoinDto.getName())
                .department(Department.values()[postStaffJoinDto.getDepartment()])
                .position(Position.values()[postStaffJoinDto.getPosition()])
                .joinDate(LocalDate.now())
                .gender(postStaffJoinDto.isGender())
                .phoneNum(postStaffJoinDto.getPhoneNum())
                .basicSalary(Position.values()[postStaffJoinDto.getPosition()].getSalary())
                .totalSalary(Position.values()[postStaffJoinDto.getPosition()].getSalary())
                .result(0)
                .build();

        Staff joinStaff = staffDAO.save(createStaff);
        System.out.println(joinStaff.getBasicSalary());
        System.out.println(joinStaff.getTotalSalary());

        return PostStaffVo.builder()
                .staffId(joinStaff.getId())
                .staffName(joinStaff.getName())
                .department(joinStaff.getDepartment().getLabel())
                .build();

    }

    @Override
    public List<GetStaffVo> getStaffList() {
        List<Staff> getStaffList = staffDAO.findAll();
        List<GetStaffVo> getStaffVoList = new ArrayList<>();
        if(getStaffList.size() != 0){
            for(int i=0; i<getStaffList.size(); i++){
                GetStaffVo getStaffVo = GetStaffVo.builder()
                        .id(getStaffList.get(i).getId())
                        .Department(getStaffList.get(i).getDepartment().getLabel())
                        .name(getStaffList.get(i).getName())
                        .joinDate(getStaffList.get(i).getJoinDate())
                        .build();
                getStaffVoList.add(getStaffVo);
            }
        }
        return getStaffVoList;
    }

    @Override
    public Object getStaff(long id) {
        Staff staff = staffDAO.findById(id).orElse(null);
        if(staff == null){
            return BasicMessageVo.builder()
                    .message(StaffExceptionType.NOT_FOUND_STAFF.getErrorMessage())
                    .build();
        }
        return GetStaffDetailVo.builder()
                .id(staff.getId())
                .Department(staff.getDepartment().getLabel())
                .name(staff.getName())
                .SSN(staff.getSSN())
                .email(staff.getEmail())
                .phoneNum(staff.getPhoneNum())
                .joinDate(staff.getJoinDate())
                .build();
    }

    @Override
    public Object deleteStaff(long id) {
        Staff staff = staffDAO.findById(id).orElse(null);
        if(staff == null){
            return BasicMessageVo.builder()
                    .message(StaffExceptionType.NOT_FOUND_STAFF.getErrorMessage())
                    .build();
        }
        staffDAO.delete(staff);
        return BasicMessageVo.builder()
                .message("사원이 해고되었습니다.")
                .build();
    }

    @Override
    public Object getSalary(long id) {
        Staff staff = staffDAO.findById(id).orElse(null);
        if(staff == null){
            return BasicMessageVo.builder()
                    .message(StaffExceptionType.NOT_FOUND_STAFF.getErrorMessage())
                    .build();
        }
        calculateSalary(staff);
        return GetSalaryVo.builder()
                .position(staff.getPosition().getLabel())
                .workDay(calculateWorkDate(staff))
                .result(staff.getResult())
                .totalSalary(staff.getTotalSalary())
                .build();
    }

    @Override
    public Object changePosition(long id, int position) {
        Staff staff = staffDAO.findById(id).orElse(null);
        if(staff == null){
            return BasicMessageVo.builder()
                    .message(StaffExceptionType.NOT_FOUND_STAFF.getErrorMessage())
                    .build();
        }
        staff.setPosition(Position.values()[position-1]);
        staff.setBasicSalary(Position.values()[position-1].getSalary());
        staffDAO.save(staff);
        return BasicMessageVo.builder()
                .message("직책이 변경되었습니다. 직책에 따라 기본 월급이 변경됩니다.")
                .build();
    }

    @Override
    public Object changeDepartment(long id, int department) {
        Staff staff = staffDAO.findById(id).orElse(null);
        if(staff == null){
            return BasicMessageVo.builder()
                    .message(StaffExceptionType.NOT_FOUND_STAFF.getErrorMessage())
                    .build();
        }
        staff.setDepartment(Department.values()[department-1]);
        staffDAO.save(staff);
        return BasicMessageVo.builder()
                .message("성공적으로 부서가 이동되었습니다.")
                .build();
    }

    // 실적 추가
    public void addResult(Staff staff) {
        staff.setResult(staff.getResult() + 1);
        staffDAO.save(staff);
    }

    // 근무 일수
    public int calculateWorkDate(Staff staff){
        LocalDate joinDate = staff.getJoinDate();
        LocalDate today = LocalDate.now();
        Period period = Period.between(joinDate, today);
        return period.getDays();
    }

    // 월급 계산
    public void calculateSalary(Staff staff){
        int workDate = calculateWorkDate(staff);
        int totalSalary = staff.getBasicSalary() + ((workDate/ 365) * 100000) + (staff.getResult() * 50000);

        staff.setTotalSalary(totalSalary);
        staff.setResult(staff.getResult()+1);

        this.staffDAO.save(staff);

//        최종 월급 = 기본 월급(basicSalary) + 근무일수(count) / 365 * x + 판매 실적(result) * y
    }


//    public Staff login(PostStaffLoginDto postStaffLoginDto) throws Exception {
//        if (!postStaffLoginDto.getStaffId().matches("^[0-9]+$")) {
//            throw new StaffException(StaffExceptionType.WRONG_TYPE_INPUT);
//        }
//        Long staffId = Long.parseLong(postStaffLoginDto.getStaffId());
//        Staff loginStaff = staffDAO.get(staffId);
//        if (loginStaff != null) {
//            if (postStaffLoginDto.getPassword().equals(loginStaff.getPassword())) {
//                return loginStaff;
//            } else {
//                throw new StaffException(StaffExceptionType.NOT_FOUND_STAFF);
//            }
//        }else {
//            throw new StaffException(StaffExceptionType.NOT_FOUND_STAFF);
//        }
//
//    }



//    public boolean createStaff(PostStaffJoinDto postStaffJoinDto) throws Exception {
//
//        Staff createdStaff = new Staff();
//
//        if (!postStaffJoinDto.getId().matches("^[0-9]+$")) {
//            throw new StaffException(StaffExceptionType.WRONG_TYPE_INPUT);
//        }
//
//        Long staffId = Long.parseLong(postStaffJoinDto.getId());
//
//        createdStaff.setId(staffId);
//        createdStaff.setPassword(postStaffJoinDto.getPw());
//
//        createdStaff.setDepartment(postStaffJoinDto.getDepartment());
//        createdStaff.setPosition(postStaffJoinDto.getPosition());
//
//        createdStaff.setName(postStaffJoinDto.getName());
//        createdStaff.setSSN(postStaffJoinDto.getSSN());
//
//        createdStaff.setGender(postStaffJoinDto.isGender());
//        createdStaff.setEmail(postStaffJoinDto.getEMail());
//        createdStaff.setPhoneNum(postStaffJoinDto.getPhoneNum());
//        createdStaff.setJoinDate(LocalDate.now());
//
//
//
////        createdStaff.setBasicSalary(createdStaff.getPosition().getSalary());
////        createdStaff.setResult(0);
////        createdStaff.setTotalSalary(createdStaff.getPosition().getSalary());
//
//        if (staffDAO.add(createdStaff)) {
//            return true;
//        } else {
//            throw new StaffException(StaffExceptionType.WRONG_JOIN_STAFF);
//        }
//
//
//
//    }

//
//    public boolean updateDepartment(long staffId, Department department) {
//        Staff staff = staffDAO.get(staffId);
//        if (staff == null) {
//            return false;
//        }
//        staff.setDepartment(department);
//        staffDAO.update(staff);
//        return true;
//    }
//

//
//

//
//    public boolean changePosition(Staff staff, Position position, Staff loginStaff) {
//        staff.setPosition(position);
//        if (this.staffDAO.update(staff)) {
//            this.calculateSalary(staff.getId(), loginStaff);
//            return true;
//        }
//        return false;
//    }



}
