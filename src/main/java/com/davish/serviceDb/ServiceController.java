package com.davish.serviceDb;

import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.davish.serviceDb.model.ServiceModel;
import com.davish.serviceDb.service.ServiceLogic;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.*;

@RestController
public class ServiceController {
	@Autowired
	ServiceLogic serviceLogic;
	
	@RequestMapping(value="model",method=RequestMethod.GET)
	public List<ServiceModel> getAllModels()
	{
		return serviceLogic.getAllModels();
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public String createNewFemtoCell(@RequestBody ServiceModel requestModel) throws AmqpException, JsonProcessingException
	{
		System.out.println(requestModel.toString());
		return serviceLogic.createNewCell(requestModel);	
	}

}
