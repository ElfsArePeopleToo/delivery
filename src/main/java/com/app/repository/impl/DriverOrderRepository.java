package com.app.repository.impl;

import com.app.model.Driver;
import com.app.model.Order;
import com.app.model.WayPoint;
import com.app.repository.DriverOrderRepositoryInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Slf4j
@Repository
@AllArgsConstructor
public class DriverOrderRepository implements DriverOrderRepositoryInterface {
    private final SessionFactory factory;

    @Override
    public List<Driver> getAllDriversOfOrder(Order order) {
        Query query = factory.getCurrentSession().createQuery("Select D from Driver D where D.order = :order");
        query.setParameter("order", order);
        List<Driver> drivers = ((org.hibernate.query.Query) query).list();
        log.info("All drivers are founded");
        return drivers;
    }

}
