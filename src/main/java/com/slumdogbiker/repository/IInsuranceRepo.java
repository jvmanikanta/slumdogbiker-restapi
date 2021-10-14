package com.slumdogbiker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slumdogbiker.model.Insurance;

@Repository
public interface IInsuranceRepo extends JpaRepository<Insurance, Integer> {

}
