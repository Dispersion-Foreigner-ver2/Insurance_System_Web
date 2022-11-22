package com.example.InsuranceSystem_Web.src.dao.staff;

import com.example.InsuranceSystem_Web.src.entity.staff.Staff;

import java.util.ArrayList;


public interface StaffDAO {

    public boolean add(Staff staff);

    public boolean delete(long staffId);

    public Staff get(long staffId);

    public boolean update(Staff staff);

    public int getSize();

    public ArrayList<Staff> getStaffList();

}
