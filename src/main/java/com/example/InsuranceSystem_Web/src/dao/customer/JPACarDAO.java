package com.example.InsuranceSystem_Web.src.dao.customer;

import com.example.InsuranceSystem_Web.src.dao.DBConnector.DBConnectorDAO;
import com.example.InsuranceSystem_Web.src.entity.customer.Car;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class JPACarDAO implements CarDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public ArrayList<Car> getCarList() {
        return (ArrayList<Car>) em.createQuery("select s from Car s", Car.class).getResultList();

    }
    @Override
    public boolean add(Car car) {
        em.persist(car);
        return true;
    }

    @Override
    public Car get(int customerId) {
        return em.find(Car.class, customerId);
    }

    @Override
    public boolean update(Car car) {
        em.merge(car);
        return true;
    }

    @Override
    public int getSize() {
        return getCarList().size();
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
