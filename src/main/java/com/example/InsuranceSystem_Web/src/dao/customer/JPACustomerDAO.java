package com.example.InsuranceSystem_Web.src.dao.customer;
import com.example.InsuranceSystem_Web.src.dao.DBConnector.DBConnectorDAO;
import com.example.InsuranceSystem_Web.src.entity.customer.*;
import com.example.InsuranceSystem_Web.src.entity.staff.Staff;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class JPACustomerDAO  implements CustomerDAO {


    @PersistenceContext
    EntityManager em;


    @Override
    public boolean add(Customer customer) {
        em.persist(customer);
        return true;
    }

    @Override
    public Customer get(int customerId) {
        return em.find(Customer.class, customerId);
    }

    @Override
    public boolean update(Customer customer) {
        em.merge(customer);
        return true;
    }

    @Override
    public int getSize() {
        return getCustomerList().size();
    }

    @Override
    public ArrayList<Customer> getCustomerList() {
        return (ArrayList<Customer>) em.createQuery("select s from Customer s", Customer.class).getResultList();
    }


    @Override
    public boolean delete(int customerid) {
        Customer deleteCustomer = em.find(Customer.class, customerid);
        em.remove(deleteCustomer);

        if (em.find(Customer.class, customerid) == null) {
            return true;
        }
        return false;

    }
}