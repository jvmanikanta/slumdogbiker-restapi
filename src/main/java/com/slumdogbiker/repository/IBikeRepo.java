package com.slumdogbiker.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slumdogbiker.model.Bike;

@Repository
public interface IBikeRepo extends JpaRepository<Bike, Integer> {
	
	List<Bike> findByBrandName(String brandName);
	List<Bike> findByPricePerDayLessThan(double price);
	List<Bike> findByPricePerDayLessThanAndBrandName(double price, String brandName); 

	
	@Query("from Bike b inner join b.planList p where b.model=?1 and p.planType=?2")
	List<Bike> findByModelAndPlanPlanType(String model, String planType);
}
