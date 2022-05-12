package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.models.Renting;
import com.example.demo.repositories.RentingRepository;
import com.example.demo.services.CarService;
import com.example.demo.services.RentingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("api/v.1")
@RestController
public class RentingController {
    @Autowired
    private RentingService rentingService;
    @Autowired
    private CarService carService;
    @RequestMapping("/renting")
    public List<Renting> findAll(){
        return rentingService.findAll();
    }



    @PostMapping("/renting")
    public Renting saveCar(@RequestBody Renting renting)throws Exception{

        return rentingService.saveRenting(renting);
    }
    @GetMapping("/renting/{id}")
    public Renting findRenting(@PathVariable ("id")Long id){
        return rentingService.findRentingById(id);
    }




}
