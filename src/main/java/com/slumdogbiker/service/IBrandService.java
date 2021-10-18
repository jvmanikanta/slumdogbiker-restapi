package com.slumdogbiker.service;

import java.util.List;

import com.slumdogbiker.model.Brand;
/**
 * 
 * @author ManikantaJV
 *
 */
public interface IBrandService {
	
	public Brand addBrand(Brand brand);
	public void deleteBrand(int brandId);
	public Brand updateBrand(Brand brand);
	
	public List<Brand> getAllBrands();
	public List<Brand> getBrandsByOrigin(String origin);
	
	public Brand getBrandByName(String name);
}
