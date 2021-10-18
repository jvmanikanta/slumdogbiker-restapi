package com.slumdogbiker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slumdogbiker.model.Plan;
import com.slumdogbiker.repository.IPlanRepo;

@Service
/**
 * 
 * @author ManikantaJV
 *
 */
public class PlanServiceImpl implements IPlanService {
	@Autowired
	IPlanRepo planRepo;

	@Override
	public Plan addPlan(Plan plan) {
		return planRepo.save(plan);
	}

	@Override
	public void deletePlan(int planId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Plan updatePlan(Plan plan) {
		return planRepo.save(plan);
	}

	@Override
	public Plan getPlanById(int planId) {
		return planRepo.findById(planId).get();
	}

}
