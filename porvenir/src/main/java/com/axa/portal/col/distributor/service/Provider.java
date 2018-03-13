package com.axa.portal.col.distributor.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import distribuidor.entidad.axacolpatria.cartera.v1_0.BizTalkServiceInstance;
import distribuidor.entidad.axacolpatria.cartera.v1_0.Cartera;

import java.net.MalformedURLException;
import java.net.URL;

public enum Provider {
	
	INSTANCE;
	
	private Log logger = LogFactoryUtil.getLog(Provider.class);
	
	private Cartera portCartera;
	
	private Enviroment enviroment;
	
	private Provider(){
		try {
			enviroment = new Enviroment();
			setPortPolicy();
		} catch (Exception e) {
			logger.error("ERROR");
		}
	}
	
	public Cartera getPortCartera() throws MalformedURLException {
		if (portCartera == null){
			setPortPolicy();
		}
		return this.portCartera;
	}
	

	private void setPortPolicy() throws MalformedURLException {
		logger.info("url cartera " + enviroment.getServiceURLCartera());
		URL wsdlURL = new URL(enviroment.getServiceURLCartera()); 
		BizTalkServiceInstance serviceInstance = new BizTalkServiceInstance(wsdlURL, BizTalkServiceInstance.SERVICE);
		this.portCartera = serviceInstance.getBasicHttpBindingITwoWayAsync();
	}
	
}
