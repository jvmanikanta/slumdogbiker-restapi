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
/**
 * 
 * @author ManikantaJV
 *
 */
public class UserController {
	
	@Autowired
	IBikeService bikeService;

	
	@GetMapping("/bikes")
	public ResponseEntity<List<Bike>> viewAllBikes() {
		return ResponseEntity.ok(bikeService.getAll());
	}
	
	@GetMapping("/bikes/bikeId/{bikeId}")
	public ResponseEntity<Bike> getBikeById(@PathVariable("bikeId")int bikeId) {
		return ResponseEntity.ok(bikeService.getById(bikeId));
	}
	
	@GetMapping("/bikes/brand/{brand}")
	public ResponseEntity<List<Bike>> getBikeByBrand(@PathVariable("brand")String brand){
		return ResponseEntity.ok(bikeService.getBikesByBrand(brand));
	}
	
	@GetMapping("/bikes/price/{price}")
	public ResponseEntity<List<Bike>> getBikeByPrice(@PathVariable("price")double price) {
		return ResponseEntity.ok(bikeService.getBikeByLessPrice(price));
	}
	
	@GetMapping("/bikes/price/{price}/brand/{brand}")
	public ResponseEntity<List<Bike>> getBikeByPriceAndBrand(@PathVariable("price")double price,@PathVariable("brand")String brand) {
		return ResponseEntity.ok(bikeService.getBikesByLessPriceAndBrand(price, brand));
	}
	
	@GetMapping("/bikes/model/{model}/plan/{plan}")
	public ResponseEntity<List<Bike>> getBikeByModelAndPlan(@PathVariable("model")String model,@PathVariable("plan")String plan){
		return ResponseEntity.ok(bikeService.getBikesBymodelAndPlan(model, plan));
	}
	
	@GetMapping("bikes/book/bikeId/{bikeId}/planId/{planId}")
	public ResponseEntity<String> bookBike(@PathVariable("bikeId")int bikeId, @PathVariable("planId")int planId){
		return ResponseEntity.ok(bikeService.bookBike(bikeId, planId));
	}
	
}
