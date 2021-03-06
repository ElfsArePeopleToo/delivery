package com.app.service;

import com.app.DTO.DriverDTO;
import com.app.model.Driver;

import java.util.List;

public interface DriverServiceInterface {


    List<DriverDTO> getAllDriversJson();

    /**
     * @param driver
     */
    Driver addDriver(Driver driver);

    /**
     * remove Driver by id
     *
     * @param id
     */
    Driver removeDriver(int id);

    /**
     * edit Driver
     *
     * @param driverDTO
     */
    DriverDTO updateDriver(DriverDTO driverDTO);

    /**
     * @param id
     * @return DriverDTO Object
     */
    DriverDTO getDriverDTO(int id);

    Driver getDriver(int id);


    List<Driver> getAllDrivers();
}
