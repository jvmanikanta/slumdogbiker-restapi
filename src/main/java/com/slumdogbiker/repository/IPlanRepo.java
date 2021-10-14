package com.slumdogbiker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slumdogbiker.model.Plan;

@Repository
public interface IPlanRepo extends JpaRepository<Plan, Integer> {

}
