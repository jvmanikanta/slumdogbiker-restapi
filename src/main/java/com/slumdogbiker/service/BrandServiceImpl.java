package com.slumdogbiker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slumdogbiker.model.Brand;
import com.slumdogbiker.repository.IBrandRepo;
@Service
/**
 * 
 * @author ManikantaJV
 *
 */
public class BrandServiceImpl implements IBrandService {
	
	@Autowired
	IBrandRepo brandRepo;

	@Override
	public Brand addBrand(Brand brand) {
		return brandRepo.save(brand);
	}

	@Override
	public void deleteBrand(int brandId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Brand updateBrand(Brand brand) {
		return brandRepo.save(brand);
	}

	@Override
	public List<Brand> getAllBrands() {
		return brandRepo.findAll();
	}

	@Override
	public List<Brand> getBrandsByOrigin(String origin) {
		return brandRepo.findByOrigin(origin);
	}

	@Override
	public Brand getBrandByName(String name) {
		return brandRepo.findByName(name);
	}

}
