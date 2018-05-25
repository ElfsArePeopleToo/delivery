package com.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "MAPS")
public class Map {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_CITY", nullable = false)
    private int idCity;

    @Column(name = "CITY")
    private String city;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<WayPoint> wayPoints;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<Driver> drivers;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<Waggon> waggons;

}
