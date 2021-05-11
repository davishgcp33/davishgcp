package com.davish.serviceDb.repository;

import java.util.Map;

import com.davish.serviceDb.model.FemtoRequestModel;
import com.davish.serviceDb.model.ServiceModel;


public interface MessageRepository {
	
	

	 Map<String,ServiceModel>findAllFemtos();

	    void addFemtos(FemtoRequestModel model);

	    void deleteFemtos(String id);

	    ServiceModel findFemtos(String id);
	    void updateFemtos(FemtoRequestModel model);


}
