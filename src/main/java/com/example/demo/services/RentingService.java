package com.example.demo.services;

import com.example.demo.models.Car;
import com.example.demo.models.Renting;
import com.example.demo.repositories.CarRepository;
import com.example.demo.repositories.RentingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class RentingService {


    private CarService carService;
    private RentingRepository rentingRepository;

    public RentingService(CarService carService, RentingRepository rentingRepository) {
        this.carService = carService;
        this.rentingRepository = rentingRepository;
    }



    public List<Renting> findAll(){
        return rentingRepository.findAll();
    }
    public Renting saveRenting(Renting renting) throws Exception {
        //get All renting by Car
        List<Renting>rentingsListForCar=findByCar(renting.getCar());
        List<LocalDate>dates= new ArrayList<>();
        //Function<Renting, LocalDate> getDate=(Renting r)-> r.getDay();
        for(Renting i:rentingsListForCar){
            dates.add(i.getDay());
        }
        dates.forEach(date -> System.out.println(date));
        //check if date found
        if(dates.contains(renting.getDay())){
            throw new Exception("This Day is Not Available");
        }
        else
        return rentingRepository.save(renting);
    }
    public Renting findRentingById(Long id){
        return rentingRepository.findById(id).get();
    }
    public List<Renting> findByCar(Car car){
        return rentingRepository.findByCar(car);
    }
    public List<Renting> findAllRentingByCar(Car car){
        List<Renting> rentings=rentingRepository.findByCar(carService.findCarById(2l));
        rentings.forEach(r ->System.out.println(r.toString()));
        return rentings;
    }
}
