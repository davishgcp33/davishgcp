package com.davish.serviceDb.model;

import java.io.Serializable;

public class FemtoRequestModel implements Serializable{
	
	
	
	private ServiceModel serviceModel;
	private String corellationId;
	private String typeOfRequest;
	
	
	public FemtoRequestModel(ServiceModel serviceModel, String corellationId,String typeOfRequest) {
		super();
		this.serviceModel = serviceModel;
		this.corellationId = corellationId;
		this.setTypeOfRequest(typeOfRequest);
	}
	public ServiceModel getServiceModel() {
		return serviceModel;
	}
	public void setServiceModel(ServiceModel serviceModel) {
		this.serviceModel = serviceModel;
	}
	public String getCorellationId() {
		return corellationId;
	}
	public void setCorellationId(String corellationId) {
		this.corellationId = corellationId;
	}
	public String getTypeOfRequest() {
		return typeOfRequest;
	}
	public void setTypeOfRequest(String typeOfRequest) {
		this.typeOfRequest = typeOfRequest;
	}
	
	
	
	
	
	
	
	
	
	
	

}
