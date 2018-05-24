package com.app.repository;

import com.app.model.Waggon;

import java.util.List;

public interface WaggonRepositoryInterface {

    List<Waggon> getAllWaggons();

    void addWaggon(Waggon waggon);

    void removeWaggon(int id);

    void updateWaggon(Waggon waggon);

    Waggon getWaggon(int id);

    Waggon getWaggonByRegNumber(String id);
}
