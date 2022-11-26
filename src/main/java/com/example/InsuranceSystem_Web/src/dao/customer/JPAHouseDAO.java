package com.example.InsuranceSystem_Web.src.dao.customer;

import com.example.InsuranceSystem_Web.src.dao.DBConnector.DBConnectorDAO;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.customer.House;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class JPAHouseDAO implements HouseDAO {

    @PersistenceContext
    EntityManager em;
    public ArrayList<House> getHouseList() {
        return (ArrayList<House>) em.createQuery("select s from House s", House.class).getResultList();

    }

    public boolean add(House house) {
        em.persist(house);
        return true;
    }
    @Override
    public House get(int customerId) {
        return em.find(House.class, customerId);
    }

    @Override
    public boolean update(House house) {
        em.merge(house);
        return true;
    }

    @Override
    public int getSize() {
        return getHouseList().size();
    }


    @Override
    public boolean delete(int id) {

        Customer deleteCustomer = em.find(Customer.class, id);
        em.remove(deleteCustomer);

        if (em.find(Customer.class, id) == null) {
            return true;
        }
        return false;
    }
}