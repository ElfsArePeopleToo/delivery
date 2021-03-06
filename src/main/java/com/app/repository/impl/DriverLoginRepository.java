package com.app.repository.impl;

import com.app.model.Driver;
import com.app.model.Order;
import com.app.model.Waggon;
import com.app.model.WayPoint;
import com.app.repository.DriverLoginRepositoryInterface;
import com.app.repository.DriversRepositoryInterface;
import com.app.repository.OrderRepositoryInterface;
import com.app.repository.WaggonRepositoryInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Slf4j
@Repository
@AllArgsConstructor
public class DriverLoginRepository implements DriverLoginRepositoryInterface {
    private final SessionFactory factory;
    @Autowired
    private DriversRepositoryInterface driversRepository;
    @Autowired
    private WaggonRepositoryInterface waggonRepository;
    @Autowired
    private OrderRepositoryInterface orderRepository;

    @Override
    public int findDriverPersonalNumber(int idDriver) {
        Driver driver = driversRepository.getDriver(idDriver);
        log.info("Driver is founded from driver login repository.");
        return driver.getPersonalNumber();
    }

    @Override
    public List<Driver> findAllCompanions(int idDriver) {
        Driver driver = driversRepository.getDriver(idDriver);
        Order order = orderRepository.getOrderById(driver.getOrder().getIdOrder());
        Query query = factory.getCurrentSession().createQuery("select D from Driver D where D.order = :order");
        query.setParameter("order", order);
        List<Driver> companions = ((org.hibernate.query.Query) query).list();
        log.info("All companions are loaded.");
        return companions;
    }

    @Override
    public String findCurrentWaggon(int idDriver) {
        Driver driver = driversRepository.getDriver(idDriver);
        Waggon waggon = waggonRepository.getWaggon(driver.getWaggon().getIdWaggon());
        log.info("Current waggon is founded.");
        return waggon.getRegNumber();

    }


    @Override
    public List<WayPoint> findAllOrderPoints(int idDriver) {
        Driver driver = driversRepository.getDriver(idDriver);
        Order order = orderRepository.getOrderById(driver.getOrder().getIdOrder());
        Query query = factory.getCurrentSession().createQuery("select W from WayPoint W where W.order = :order");
        query.setParameter("order",order );
        List<WayPoint> points = ((org.hibernate.query.Query) query).list();
        log.info("All waypoints are founded.");
        return points;
    }

    @Override
    public int settingDriverTime(int idDriver) {
        return 0;
    }
}
