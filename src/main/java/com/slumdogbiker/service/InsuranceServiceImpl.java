package com.slumdogbiker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slumdogbiker.model.Insurance;
import com.slumdogbiker.repository.IInsuranceRepo;

@Service
public class InsuranceServiceImpl implements IInsuranceService {
	@Autowired
	IInsuranceRepo insuranceRepo;

	@Override
	public Insurance addInsurance(Insurance insurance) {
		return insuranceRepo.save(insurance);
	}

	@Override
	public void deleteInsurance(int insuranceId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Insurance updateInsurance(Insurance insurance) {
		return insuranceRepo.save(insurance);
	}

}
