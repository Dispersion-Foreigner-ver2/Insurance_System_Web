package com.example.InsuranceSystem_Web.src.dao.customer;

import com.example.InsuranceSystem_Web.src.dao.DBConnector.DBConnectorDAO;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.customer.MedicalHistory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
@Repository
public class JPAMedicalHistoryDAO  implements MedicalHistoryDAO {

    @PersistenceContext
    EntityManager em;


    public ArrayList<MedicalHistory> getMedicalHistoryList() {
        return (ArrayList<MedicalHistory>) em.createQuery("select s from MedicalHistory s", MedicalHistory.class).getResultList();

    }


    @Override
    public boolean add(MedicalHistory medicalHistory) {
        em.persist(medicalHistory);
        return true;
    }

    @Override
    public MedicalHistory get(int customer_Id) {
        return em.find(MedicalHistory.class, customer_Id);
    }

    @Override
    public boolean update(MedicalHistory medicalHistory) {
        em.merge(medicalHistory);
        return true;
    }

    @Override
    public int getSize() {
        return getMedicalHistoryList().size();
    }


    @Override
    public boolean delete(int customer_id) {

        Customer deleteCustomer = em.find(Customer.class, customer_id);
        em.remove(deleteCustomer);

        if (em.find(Customer.class, customer_id) == null) {
            return true;
        }
        return false;
    }
}