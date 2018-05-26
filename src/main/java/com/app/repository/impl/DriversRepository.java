package com.app.repository.impl;

import com.app.model.Driver;
import com.app.repository.DriversRepositoryInterface;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public class DriversRepository implements DriversRepositoryInterface {
    //Hibernate+Spring
    @Autowired
    private final SessionFactory factory;


    public DriversRepository(SessionFactory factory) {
        this.factory = factory;
    }

    //show driver list

    public List<Driver> getAllDrivers() {
        List<Driver> drivers = factory.getCurrentSession().createQuery("from Driver").list();
        return drivers;
    }

    //add new driver

    public void addDriver(Driver driver) {
        factory.getCurrentSession().save(driver);
    }

    //updating driver fields

    public void updateDriver(Driver driver) {
        factory.getCurrentSession().update(driver);
    }

    //get driver by id

    public Driver getDriver(int id) {
        Driver driver = (Driver) factory.getCurrentSession().get(Driver.class, id);
        return driver;
    }

    // remove driver

    public void removeDriver(int id) {
        Driver driver = getDriver(id);
        factory.getCurrentSession().delete(driver);
    }
}