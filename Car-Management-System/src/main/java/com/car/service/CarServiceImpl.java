package com.car.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.exception.CarNotFoundException;
import com.car.model.Car;
import com.car.repository.CarRepository;

@Service
@Transactional
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository carRepository;

	
	public Car createCar(Car car) {
		
		  return carRepository.save(car);
	}

	public Car updateCar(Car car) {
		
		Optional<Car> carDb = this.carRepository.findById(car.getCarId());
		
		if(carDb.isPresent()) {
		
			Car carUpdate = carDb.get();
			carUpdate.setCarId(car.getCarId());
			carUpdate.setCarName(car.getCarName());
			carUpdate.setCarColor(car.getCarColor());
			carUpdate.setCarModel(car.getCarModel());
			carRepository.save(carUpdate);
		
			return carUpdate;
		
	  }
	 else
	 	{
		 	throw new CarNotFoundException("Car not found with id:"+car.getCarId(), null);
		
	 	}

	}
	
	public List<Car> getAllCar() {
		
		return this.carRepository.findAll();
	}


	public Car getCarById(int carId) {
		
		Optional<Car> carDb = this.carRepository.findById(carId);
		
		if(carDb.isPresent()) {
			
			return carDb.get();
		}
		
		else {
			
			
			throw new CarNotFoundException("Car not found with ID"+carId, null);
		}
		
	}

	
	public void deleteCar(int carId) {
		
		Optional<Car> carDb = this.carRepository.findById(carId);
		
		if(carDb.isPresent()) {
			
			this.carRepository.delete(carDb.get());
			
		}
		else {
			
				throw new CarNotFoundException("Car not found at:"+carId, null);
			
		}
	}
	
	

}
