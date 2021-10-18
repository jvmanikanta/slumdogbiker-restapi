package com.slumdogbiker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
/**
 * 
 * @author ManikantaJV
 *
 */
public class Insurance {
	@Id
	@GeneratedValue(generator="insurance_gen",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="insurance_gen",sequenceName="insurance_seq",initialValue=1,allocationSize=1)
	private Integer insuranceId;
	private double premium;
	private int validity;
	@Column(length = 20)
	private String provider;
	
	@JsonIgnore
	@OneToOne(mappedBy = "insurance")
	Bike bike;

	public Insurance(double premium, int validity, String provider) {
		super();
		this.premium = premium;
		this.validity = validity;
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "Insurance [premium=" + premium + ", validity=" + validity + ", provider=" + provider + "]";
	}

	
	
	
}
