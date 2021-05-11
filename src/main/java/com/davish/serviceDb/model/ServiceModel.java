package com.davish.serviceDb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="device_details")
public class ServiceModel implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="device_id")
	private Long deviceId;
	@Column(name="device_name")
	private String deviceName;
	@Column(name="device_location")
	private String deviceLocation;
	@Column(name="device_spectrum")
	private String deviceSpectrum;
	@Column(name="device_bandwidth")
	private String deviceBandwidth;
	
	@Override
	public String toString() {
		return "ServiceModel [deviceId=" + deviceId + ", deviceName=" + deviceName + ", deviceLocation="
				+ deviceLocation + ", deviceSpectrum=" + deviceSpectrum + ", deviceBandwidth=" + deviceBandwidth + "]";
	}
	public ServiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServiceModel(Long deviceId, String deviceName, String deviceLocation, String deviceSpectrum,
			String deviceBandwidth) {
		super();
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.deviceLocation = deviceLocation;
		this.deviceSpectrum = deviceSpectrum;
		this.deviceBandwidth = deviceBandwidth;
	}
	public Long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceLocation() {
		return deviceLocation;
	}
	public void setDeviceLocation(String deviceLocation) {
		this.deviceLocation = deviceLocation;
	}
	public String getDeviceSpectrum() {
		return deviceSpectrum;
	}
	public void setDeviceSpectrum(String deviceSpectrum) {
		this.deviceSpectrum = deviceSpectrum;
	}
	public String getDeviceBandwidth() {
		return deviceBandwidth;
	}
	public void setDeviceBandwidth(String deviceBandwidth) {
		this.deviceBandwidth = deviceBandwidth;
	}
	
	
	

}
