package com.example.demo.repositories;

import com.example.demo.models.Car;
import com.example.demo.models.Renting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentingRepository extends JpaRepository<Renting,Long> {

    List<Renting> findByCar(Car car);
}
