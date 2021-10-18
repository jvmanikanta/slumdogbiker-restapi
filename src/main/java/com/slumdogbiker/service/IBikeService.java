package com.slumdogbiker.service;

import java.util.List;

import com.slumdogbiker.exceptions.BikeNotFoundException;
import com.slumdogbiker.model.Bike;
/**
 * 
 * @author ManikantaJV
 *
 */
public interface IBikeService {
	public Bike addBike(Bike bike);
	public void deleteBike(int bikeId);
	public Bike updateBike(Bike bike);
	
	public Bike getById(int bikeId) throws BikeNotFoundException;
	
	public String bookBike(int bikeId, int planId) throws BikeNotFoundException;
	
	public List<Bike> getAll();
	public List<Bike> getBikesByBrand(String brand) throws BikeNotFoundException;
	public List<Bike> getBikeByLessPrice(double price) throws BikeNotFoundException;
	public List<Bike> getBikesByLessPriceAndBrand(double price, String brand) throws BikeNotFoundException;
	public List<Bike> getBikesBymodelAndPlan(String model, String planType) throws BikeNotFoundException;
}
