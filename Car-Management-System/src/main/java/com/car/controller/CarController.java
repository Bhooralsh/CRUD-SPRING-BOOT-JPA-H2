package com.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.model.Car;
import com.car.service.CarService;

@RestController
public class CarController {
	
	@Autowired
	private CarService carService;
	
	
	@GetMapping("/cars")
	public ResponseEntity<List<Car>>getAllCar(){
		
		return ResponseEntity.ok().body(carService.getAllCar());
		
		
	}
	
	@PostMapping("/cars")
	public ResponseEntity<Car>createCar(@RequestBody Car car){
		
		return ResponseEntity.ok().body(this.carService.createCar(car));
		
	}
	
	@PutMapping("/cars/{id}")
	public ResponseEntity<Car>updateCar(@PathVariable int id,@RequestBody Car car){
		
		car.setCarId(id);
		return ResponseEntity.ok().body(this.carService.updateCar(car));
	}
	
	
	@DeleteMapping("/cars/{id}")
	public String deleteCar(@PathVariable int id) {
		
		this.carService.deleteCar(id);
		return "ok";
	}
	
	
}
