package com.example.demo.services;

import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarService {


    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }
    public Car saveCar(Car car){
        return carRepository.save(car);
    }
    public Car findCarById(Long id){
        return carRepository.findById(id).get();
    }
}
