package com.example.demo.services;

import com.example.demo.models.Car;
import com.example.demo.models.Renting;
import com.example.demo.repositories.CarRepository;
import com.example.demo.repositories.RentingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentingService {


    private RentingRepository rentingRepository;

    public RentingService(RentingRepository rentingRepository) {
        this.rentingRepository = rentingRepository;
    }

    public List<Renting> findAll(){
        return rentingRepository.findAll();
    }
    public Renting saveRenting(Renting renting){
        return rentingRepository.save(renting);
    }
    public Renting findRentingById(Long id){
        return rentingRepository.findById(id).get();
    }
}
