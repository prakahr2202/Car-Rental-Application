package com.vistara.lomi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.beans.factory.annotation.Autowired;
@Service
public class CarService {

    @Autowired
    CarsRepo repo;

    public List<Cars> getAllCars() {
        return repo.findAll();
    }

    public Cars saveCar(Cars cars) {
        return repo.save(cars);
    }
}