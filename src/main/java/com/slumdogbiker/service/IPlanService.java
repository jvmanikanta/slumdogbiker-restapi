package com.slumdogbiker.service;

import com.slumdogbiker.model.Plan;

public interface IPlanService {

	public Plan addPlan(Plan plan);
	public void deletePlan(int planId);
	public Plan updatePlan(Plan plan);
	
	public Plan getPlanById(int planId);
}
