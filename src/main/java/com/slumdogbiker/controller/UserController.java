package com.slumdogbiker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slumdogbiker.exceptions.BikeNotFoundException;
import com.slumdogbiker.model.Bike;
import com.slumdogbiker.service.IBikeService;

@RestController
@RequestMapping("/bikes-service")
public class UserController {
	
	@Autowired
	IBikeService bikeService;

	
	@GetMapping("/bikes")
	public List<Bike> viewAllBikes() {
		return bikeService.getAll();
	}
	
	@GetMapping("/bikes/bikeId/{bikeId}")
	public Bike getBikeById(@PathVariable("bikeId")int bikeId) {
		return bikeService.getById(bikeId);
	}
	
	@GetMapping("/bikes/brand/{brand}")
	public List<Bike> getBikeByBrand(@PathVariable("brand")String brand){
		return bikeService.getBikesByBrand(brand);
	}
	
	@GetMapping("/bikes/price/{price}")
	public List<Bike> getBikeByPrice(@PathVariable("price")double price) {
		return bikeService.getBikeByLessPrice(price);
	}
	
	@GetMapping("/bikes/price/{price}/brand/{brand}")
	public List<Bike> getBikeByPriceAndBrand(@PathVariable("price")double price,@PathVariable("brand")String brand) {
		return bikeService.getBikesByLessPriceAndBrand(price, brand);
	}
	
	@GetMapping("/bikes/model/{model}/plan/{plan}")
	public List<Bike> getBikeByModelAndPlan(@PathVariable("model")String model,@PathVariable("plan")String plan){
		return bikeService.getBikesBymodelAndPlan(model, plan);
	}
	
	@GetMapping("bikes/book/bikeId/{bikeId}/planId/{planId}")
	public String bookBike(@PathVariable("bikeId")int bikeId, @PathVariable("planId")int planId){
		return bikeService.bookBike(bikeId, planId);
	}
	
}
