package com.example.InsuranceSystem_Web.DAO.StaffDAO;

import com.example.InsuranceSystem_Web.Domain.Staff.Staff;

import java.util.ArrayList;

public interface StaffDAO {

    public boolean add(Staff staff);

    public boolean delete(int staffId);

    public Staff get(int staffId);

    public boolean update(Staff staff);

    public int getSize();

    public ArrayList<Staff> getStaffList();

}
