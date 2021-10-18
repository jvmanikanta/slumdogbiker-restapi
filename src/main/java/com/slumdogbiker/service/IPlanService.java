package com.slumdogbiker.service;

import com.slumdogbiker.model.Plan;

/**
 * 
 * @author ManikantaJV
 *
 */
public interface IPlanService {

	public Plan addPlan(Plan plan);
	public void deletePlan(int planId);
	public Plan updatePlan(Plan plan);
	
	public Plan getPlanById(int planId);
}
