package com.example.demo.models;
import com.example.demo.repositories.CarRepository;
import com.example.demo.services.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @InjectMocks
    private CarService carService;
    private CarRepository carRepository=Mockito.mock(CarRepository.class);
@BeforeEach
public void setUp(){
    carService= new CarService(carRepository);
}

    @Test
    public void testFindAll(){

        List<Car> carList=new ArrayList<>();
        carList.add(new Car(1,"abc"));carList.add(new Car(2,"bmw"));
        Mockito.when(carRepository.findAll()).thenReturn(carList);;
        assertEquals(2,carService.findAll().size());
      //  assertEquals("abc",carService.findCarById(1l).getCarName());
    }
    @Test
    public void testFindById(){
       Car abc= new Car(5,"abc");
        Mockito.when(carRepository.findById(5l)).thenReturn(java.util.Optional.of(abc));
        assertEquals("abc",carService.findCarById(5l).getCarName());

    }
    @Test
    @DisplayName("test Save Car")
    public void testSaveCar(){
        Car abc= new Car(1001,"abc");
        Mockito.when(carRepository.save(abc)).thenReturn(abc);
        assertEquals(1001,carService.saveCar(abc).getId());
    }
    @Test
    @DisplayName("test Throw Exception")
    public void testThrowException(){
        Car abc= new Car(1001,"");
        Mockito.when(carRepository.save(abc)).thenThrow(new IllegalArgumentException("Car Name Not is Empty"));
            IllegalArgumentException exception=assertThrows(IllegalArgumentException.class,()->carService.saveCar(abc));
        assertEquals("Car Name Not is Empty",exception.getMessage());
}

}