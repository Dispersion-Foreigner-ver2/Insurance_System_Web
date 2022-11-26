package com.example.InsuranceSystem_Web.src.dao.customer;

import com.example.InsuranceSystem_Web.src.dao.DBConnector.DBConnectorDAO;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.customer.Ship;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class JPAShipDAO extends DBConnectorDAO implements ShipDAO {

    @PersistenceContext
    EntityManager em;

    public ArrayList<Ship> getShipList() {
        return (ArrayList<Ship>) em.createQuery("select s from Ship s", Ship.class).getResultList();

    }


    @Override
    public boolean add(Ship ship) {
        em.persist(ship);
        return true;
    }

    @Override
    public Ship get(int id) {
        return em.find(Ship.class, id);
    }

    @Override
    public boolean update(Ship ship) {
        em.merge(ship);
        return true;
    }

    @Override
    public int getSize() {
        return getShipList().size();
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