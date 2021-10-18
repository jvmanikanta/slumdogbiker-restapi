package com.slumdogbiker.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Brand {
	@Id
	@GeneratedValue(generator = "brand_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "brand_gen", sequenceName = "brand_seq", initialValue = 1, allocationSize = 1)
	private Integer brandId;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String origin;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "brand")
	Set<Bike> bikesList;

	public Brand(String name, String origin) {
		super();
		this.name = name;
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "Brand [name=" + name + ", origin=" + origin + "]";
	}

	
}
