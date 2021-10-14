package com.slumdogbiker.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString 
@Entity
public class Plan {
	@Id
	@GeneratedValue(generator="plan_gen",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="plan_gen",sequenceName="plan_seq",initialValue=1,allocationSize=1)
	private Integer planId;
	@Column(length = 20)
	private String planType;
	private int planDiscount;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "planList", fetch=FetchType.EAGER)
	Set<Bike> bikesList;

	public Plan(String planType, int planDiscount) {
		super();
		this.planType = planType;
		this.planDiscount = planDiscount;
	}

	@Override
	public String toString() {
		return "Plan [planType=" + planType + ", planDiscount=" + planDiscount + "]";
	}
	
	
}
