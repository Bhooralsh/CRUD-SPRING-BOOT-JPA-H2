package com.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

}
