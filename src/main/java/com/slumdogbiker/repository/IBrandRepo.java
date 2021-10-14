package com.slumdogbiker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slumdogbiker.model.Brand;

@Repository
public interface IBrandRepo extends JpaRepository<Brand, Integer> {
	
	Brand findByName(String name);

	List<Brand> findByOrigin(String origin);
}
