package com.davish.serviceDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davish.serviceDb.model.ServiceModel;

public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {
	
	
	

}
