package com.slumdogbiker.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slumdogbiker.exceptions.BikeNotFoundException;
import com.slumdogbiker.model.Bike;
import com.slumdogbiker.model.Plan;
import com.slumdogbiker.repository.IBikeRepo;
import com.slumdogbiker.repository.IPlanRepo;

@Service
public class BikeServiceImpl implements IBikeService {
	
	@Autowired
	IBikeRepo bikeRepo;
	
	@Autowired
	IPlanRepo planRepo;

	@Override
	public Bike addBike(Bike bike) {
		return bikeRepo.save(bike);
	}

	@Override
	public void deleteBike(int bikeId) {
		bikeRepo.deleteById(bikeId);

	}

	@Override
	public Bike updateBike(Bike bike) {
		return bikeRepo.save(bike);
	}

	@Override
	public Bike getById(int bikeId) throws BikeNotFoundException {
		return bikeRepo.findById(bikeId)
				.orElseThrow(() -> new BikeNotFoundException("Id Not Found"));
	}

	@Override
	public List<Bike> getAll() {
		return bikeRepo.findAll();
	}

	@Override
	public List<Bike> getBikesByBrand(String brand) throws BikeNotFoundException {
		List<Bike> bikesList = bikeRepo.findByBrandName(brand);
		if(bikesList.isEmpty()) {
			throw new BikeNotFoundException("Brand Not Found");
		}
		return bikesList;
	}

	@Override
	public List<Bike> getBikeByLessPrice(double price) throws BikeNotFoundException {
		List<Bike> bikesList = bikeRepo.findByPricePerDayLessThan(price);
		if(bikesList.isEmpty()) {
			throw new BikeNotFoundException("Price Not Found");
		}
		return bikesList;
	}

	@Override
	public List<Bike> getBikesByLessPriceAndBrand(double price, String brand) throws BikeNotFoundException {
		List<Bike> bikesList = bikeRepo.findByPricePerDayLessThanAndBrandName(price, brand);
		if(bikesList.isEmpty()) {
			throw new BikeNotFoundException("Brand or Price Not Found");
		}
		return bikesList;
	}

	@Override
	public List<Bike> getBikesBymodelAndPlan(String model, String planType) throws BikeNotFoundException {
		List<Bike> bikesList = bikeRepo.findByModelAndPlanPlanType(model, planType);
		if(bikesList.isEmpty()) {
			throw new BikeNotFoundException("Model or PlanType Not Found");
		}
		return bikesList;
	}

	@Override
	public String bookBike(int bikeId, int planId) {
		Bike abike = bikeRepo.findById(bikeId).get();
		Plan aplan = planRepo.findById(planId).get();
		LocalDate today;
		if(LocalDate.now().isBefore(abike.getAvailableFrom())) {
			return "Bike not available";
		}
		int noOfDays;
		if(planId == 1) {
			noOfDays = 1;
			today = LocalDate.now().plusDays(1);;
		}else if(planId == 2) {
			noOfDays = 7;
			today = LocalDate.now().plusDays(7);
		}else {
			noOfDays = 30;
			today = LocalDate.now().plusDays(30);
		}
		abike.setAvailableFrom(today);
		bikeRepo.save(abike);
		//System.out.println(noOfDays);
		double orderTotal = (abike.getPricePerDay())*noOfDays;
		double discount = orderTotal*aplan.getPlanDiscount()/100;
		double finalAmount = orderTotal - discount;
		return abike.getModel() + " is booked successfully \n" +"order total is " + orderTotal + "\ndiscount is " + discount
				+ "\nfinal amount is " + finalAmount;
	}

}
