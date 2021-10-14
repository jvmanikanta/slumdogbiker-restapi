package com.slumdogbiker;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.slumdogbiker.model.Bike;
import com.slumdogbiker.model.Brand;
import com.slumdogbiker.model.Insurance;
import com.slumdogbiker.model.Plan;
import com.slumdogbiker.service.IBikeService;
import com.slumdogbiker.service.IBrandService;
import com.slumdogbiker.service.IInsuranceService;
import com.slumdogbiker.service.IPlanService;

@SpringBootApplication
public class SpringSlumdogbikerMvcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringSlumdogbikerMvcApplication.class, args);
	}

	@Autowired
	IBikeService bikeService;
	
	@Autowired
	IBrandService brandService;
	
	@Autowired
	IInsuranceService insuranceService; 
	
	@Autowired
	IPlanService planService;
	
	@Override
	public void run(String... args) throws Exception {
//		Insurance insurance = new Insurance(7000,3,"Sbi");
//		insuranceService.addInsurance(insurance);
//		
//		String brandName = "BMW";
//		String origin = "Germany";
//		Brand brand = brandService.getBrandByName(brandName);
//		Brand brand1;
//		if(brand == null) {
//			brand1 = new Brand(brandName,origin);
//			brandService.addBrand(brand1);
//		}
//		else {
//			brand1 = brandService.getBrandByName(brandName);
//		}
//		Plan plan1 = planService.getPlanById(1);
//		Plan plan2 = planService.getPlanById(2);
//		Plan plan3 = planService.getPlanById(3);
//		Set<Plan> planList = new HashSet<>(Arrays.asList(plan1,plan2,plan3));
//		LocalDate date = LocalDate.of(2021, 9, 30);
//		Bike bike = new Bike("Gs 310",1199,date,insurance,planList,brand1);
//		bikeService.addBike(bike);
//		
//***************************************BIKE SERVICE*****************************************************************************
//		System.out.println();
//		System.out.println("************************Get All*********************************");
//		bikeService.getAll().forEach(System.out::println);
//		System.out.println();
//		System.out.println("************************Get Bike by Id*********************************");
//		System.out.println(bikeService.getById(1));
//		System.out.println();
//		System.out.println("************************Get By Brand*********************************");
//		bikeService.getBikesByBrand("KTM").forEach(System.out::println);
//		System.out.println();
//		System.out.println("************************Get By Less Price*********************************");
//		bikeService.getBikeByLessPrice(1200).forEach(System.out::println);
//		System.out.println();
//		System.out.println("************************Get By Less Price and Brand*********************************");
//		bikeService.getBikesByLessPriceAndBrand(1000, "KTM").forEach(System.out::println);
//		System.out.println();
//		System.out.println("************************Get By All Brand*********************************");
//		brandService.getAllBrands().forEach(System.out::println);
//		System.out.println();
//		System.out.println("************************Get By Brand origin*********************************");
//		brandService.getBrandsByOrigin("Austria").forEach(System.out::println); 
//		System.out.println();
//		System.out.println("************************Get By Model and Plan*********************************");
//		bikeService.getBikesBymodelAndPlan("Duke 250", "daily").forEach(System.out::println);
//		System.out.println();
//		String result = bikeService.bookBike(6, 2);
//		System.out.println(result);
		
//**************************************************BRAND SERVICE***************************************************************************
	}

}
