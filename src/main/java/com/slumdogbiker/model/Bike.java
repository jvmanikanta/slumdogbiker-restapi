package com.slumdogbiker.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
/**
 * 
 * @author ManikantaJV
 *
 */
public class Bike {
	@Id
	@GeneratedValue(generator="bike_gen",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="bike_gen",sequenceName="bike_seq",initialValue=1,allocationSize=1)
	private Integer bikeId;
	@Column(length = 20)
	private String model;
	private double pricePerDay;
	private LocalDate availableFrom;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="insurance_id")
	Insurance insurance;
	
	@ManyToMany
	@JoinTable(name="bike_plan", joinColumns = {@JoinColumn(name="bike_id")}, inverseJoinColumns = {@JoinColumn(name="plan_id")} )
	Set<Plan> planList;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="brand_id")
	Brand brand;


	public Bike(String model, double pricePerDay, LocalDate availableFrom, Insurance insurance,
			Set<Plan> planList, Brand brand) {
		super();
		this.model = model;
		this.pricePerDay = pricePerDay;
		this.availableFrom = availableFrom;
		this.insurance = insurance;
		this.planList = planList;
		this.brand = brand;
	}


	@Override
	public String toString() {
		return "Bike [model=" + model + ", pricePerDay=" + pricePerDay + ", availableFrom=" + availableFrom + "]";
	}


	


	
	

	
	

}
