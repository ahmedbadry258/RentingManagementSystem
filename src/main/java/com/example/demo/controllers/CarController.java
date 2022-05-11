package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("api/v.1")
@RestController
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping("/cars")
    public List<Car> home(){
        System.out.println("Home Page");
        return carService.findAll();
    }
    @PostMapping("/cars")
    public Car saveCar(@RequestBody Car car){
    return carService.saveCar(car);
    }
    @GetMapping("/cars/{id}")
    public Car findCar(@PathVariable ("id")Long id){
        return carService.findCarById(id);
    }
}
