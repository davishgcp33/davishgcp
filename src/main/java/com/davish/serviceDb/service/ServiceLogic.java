package com.davish.serviceDb.service;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davish.serviceDb.model.FemtoRequestModel;
import com.davish.serviceDb.model.ServiceModel;
import com.davish.serviceDb.repository.MessageRepository;
import com.davish.serviceDb.repository.MessageRepositoryImpl;
import com.davish.serviceDb.repository.ServiceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

@Service
public class ServiceLogic {
	@Autowired
	ServiceRepository serviceRepository;
	@Autowired
	RabbitTemplate template;
	
	
	@Autowired
	MessageRepositoryImpl messageRepository;
	
	public List<ServiceModel> getAllModels()
	{
		return serviceRepository.findAll();
		
	}
	
	public String createNewCell(ServiceModel requestModel) throws AmqpException, JsonProcessingException
	{
		
		String correlationID=ServiceLogic.generateCorrelationID(requestModel);
		
		template.convertAndSend("TestExchange",requestModel.getDeviceLocation(),new ObjectMapper().writeValueAsString(new FemtoRequestModel(requestModel, correlationID,"CREATE_CELL")));
		return correlationID; 
	}
	public String updateCell(ServiceModel requestModel) throws AmqpException, JsonProcessingException
	{
		
		//serviceRepository.save(requestModel);
		String correlationID=ServiceLogic.generateCorrelationID(requestModel);
		
		//messageRepository.addFemtos(new FemtoRequestModel(requestModel, correlationID));
		template.convertAndSend("TestExchange","test",new ObjectMapper().writeValueAsString(new FemtoRequestModel(requestModel, correlationID,"UPDATE_CELL")));
		return correlationID; 
	}
	
	
	
	
	
	public String deleteCell(ServiceModel requestModel) throws AmqpException, JsonProcessingException
	{
		
		//serviceRepository.save(requestModel);
		String correlationID=ServiceLogic.generateCorrelationID(requestModel);
		
		//messageRepository.addFemtos(new FemtoRequestModel(requestModel, correlationID));
		template.convertAndSend("TestExchange", "test",new ObjectMapper().writeValueAsString(new FemtoRequestModel(requestModel, correlationID,"DELETE_CELL")));
		//template.convertAndSend("TestExchange","test",new FemtoRequestModel(requestModel, correlationID,"DELETE_CELL"));
		return correlationID; 
	}
	public static String generateCorrelationID(ServiceModel model)
	{
		long timeStamp=System.currentTimeMillis();
		String correlationId=model.getDeviceId()+""+timeStamp;
		
		return correlationId;
		
		
	}
	

}
