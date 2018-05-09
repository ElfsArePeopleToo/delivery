package com.app.repository.api;

import com.app.model.Driver;

import java.util.List;

public interface DriversRepositoryInterface {

    public List<?> getAllDrivers();
    void addDriver(Driver driver);
    void removeDriver(int id);
    void updateDriver(Driver driver);



}