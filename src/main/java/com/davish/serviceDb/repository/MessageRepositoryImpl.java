package com.davish.serviceDb.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.davish.serviceDb.model.FemtoRequestModel;
import com.davish.serviceDb.model.ServiceModel;

@Repository
public class MessageRepositoryImpl implements MessageRepository {
	
	
	
	
RedisTemplate< String,FemtoRequestModel> redisTemplate;
HashOperations hashOperations;
	
	
 public MessageRepositoryImpl(RedisTemplate<String, FemtoRequestModel> template) {
	// TODO Auto-generated constructor stub
	 this.redisTemplate=template;
	 this.hashOperations=redisTemplate.opsForHash();
	 
}
	
	

	@Override
	public Map<String, ServiceModel> findAllFemtos() {
		// TODO Auto-generated method stub
		return hashOperations.entries("Femtos");
	}

	@Override
	public void addFemtos(FemtoRequestModel model) {
		
		hashOperations.put("Femots",model.getServiceModel().getDeviceId(),model);
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFemtos(String id) {
		hashOperations.delete(id, "Femots");
		// TODO Auto-generated method stub

	}

	@Override
	public ServiceModel findFemtos(String id) {
		// TODO Auto-generated method stub
		 return (ServiceModel) hashOperations.get("Femtos", id);
	}

	@Override
	public void updateFemtos(FemtoRequestModel model) {
		hashOperations.put("Femtos", model.getServiceModel().getDeviceId(), model);
		// TODO Auto-generated method stub

	}

}
