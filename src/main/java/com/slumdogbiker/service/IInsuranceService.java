package com.slumdogbiker.service;

import com.slumdogbiker.model.Insurance;

public interface IInsuranceService {

	public Insurance addInsurance(Insurance insurance);
	public void deleteInsurance(int insuranceId);
	public Insurance updateInsurance(Insurance insurance);
	
}
