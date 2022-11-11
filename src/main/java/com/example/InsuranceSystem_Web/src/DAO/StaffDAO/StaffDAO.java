package com.example.InsuranceSystem_Web.src.DAO.StaffDAO;

import com.example.InsuranceSystem_Web.src.Domain.Staff.Staff;

import java.util.ArrayList;

public interface StaffDAO {

    public boolean add(Staff staff);

    public boolean delete(int staffId);

    public Staff get(int staffId);

    public boolean update(Staff staff);

    public int getSize();

    public ArrayList<Staff> getStaffList();

}
