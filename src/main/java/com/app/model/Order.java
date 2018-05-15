package com.app.model;

import com.app.model.Enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ORDER",unique = true)
    private int idOrder;

    @Column(name ="ORDER_STATUS")
    private OrderStatus status;

    @Column(name = "WAY_POINTS_LIST")
    @ElementCollection(targetClass=WayPoint.class)
    private List<WayPoint> PointList;

    @OneToOne(mappedBy = "order", fetch = FetchType.EAGER)
    private Waggon currentWaggon;

    @Column(name = "DRIVERS_LIST")
    @ElementCollection(targetClass=Driver.class)
    private List<Driver> DriverList;
}
