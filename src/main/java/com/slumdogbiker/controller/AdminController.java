package com.slumdogbiker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slumdogbiker.model.Bike;
import com.slumdogbiker.service.IBikeService;

@RestController
@RequestMapping("/admin-service")
/**
 * 
 * @author ManikantaJV
 *
 */
public class AdminController {
	
	@Autowired
	IBikeService bikeServiceImpl; 
	
	@PostMapping("/bikes/add-bike")
	public ResponseEntity<Bike> addBike(@RequestBody Bike bike) {
		return ResponseEntity.ok(bikeServiceImpl.addBike(bike));
	}
	
	@PutMapping("/bikes/update-bike")
	public ResponseEntity<Bike> updateBike(@RequestBody Bike bike) {
		return ResponseEntity.ok(bikeServiceImpl.updateBike(bike));
	}
	
	@DeleteMapping("/bikes/delete/{bikeId}")
	public ResponseEntity<String> deleteBike(@PathVariable("bikeId")int bikeId) {
		bikeServiceImpl.deleteBike(bikeId);
		return ResponseEntity.ok("Bike deleted Successfully");
	}
}
