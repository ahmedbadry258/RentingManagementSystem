package com.example.demo.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Renting {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private LocalDate day;
private String customerName;
@ManyToOne
@JoinColumn(name = "car_id")
private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Renting(Long id, LocalDate day, String customerName, Car car) {
        this.id = id;
        this.day = day;
        this.customerName = customerName;
        this.car = car;
    }

    public Renting() {
    }

    @Override
    public String toString() {
        return "Renting{" +
                "id=" + id +
                ", day=" + day +
                ", customerName='" + customerName + '\'' +
                ", car=" + car +
                '}';
    }
}
