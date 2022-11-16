package com.example.InsuranceSystem_Web.dao.StaffDAO;

import com.example.InsuranceSystem_Web.domain.Staff.Staff;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class JPAStaffDAO implements StaffDAO{


    @PersistenceContext
    EntityManager em;

    @Override
    public boolean add(Staff staff) {
        em.persist(staff);
        return true;
    }

    @Override
    public boolean delete(long staffId) {
        Staff deleteStaff = em.find(Staff.class, staffId);
        em.remove(deleteStaff);

        if (em.find(Staff.class, staffId) == null) {
            return true;
        }
        return false;
    }

    @Override
    public Staff get(long staffId) {
        return em.find(Staff.class, staffId);
    }

    @Override
    public boolean update(Staff staff) {
        em.merge(staff);
        return true;
    }

    @Override
    public int getSize() {
        Query query = em.createQuery("select count (s) from Staff s", Staff.class);
        int size = (Integer) query.getSingleResult();
        return size;
    }

    @Override
    public ArrayList<Staff> getStaffList() {
        return (ArrayList<Staff>) em.createQuery("select s from Staff s", Staff.class).getResultList();
    }
}
