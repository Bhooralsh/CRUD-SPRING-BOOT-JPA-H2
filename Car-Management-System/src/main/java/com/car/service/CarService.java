package com.car.service;

import java.util.List;

import com.car.model.Car;

public interface CarService {

		Car createCar(Car car);
		
		Car updateCar(Car car);
		
		List<Car>getAllCar();
		
		Car getCarById(int carId);
		
		void deleteCar(int carId);
}
