package com.axa.portal.col.distributor.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import co.com.porvenir.ws.ServicioWebCesantiasAfiliados;
import co.com.porvenir.ws.ServicioWebCesantiasAfiliadosService;

public enum Provider {
	
	INSTANCE;
	
	private static final QName SERVICE_NAME = new QName("http://ws.porvenir.com.co/", "ServicioWebCesantiasAfiliadosService");
	
	private Log logger = LogFactoryUtil.getLog(Provider.class);
	
	private ServicioWebCesantiasAfiliados portCartera;
	
	private Enviroment enviroment;
	
	private Provider(){
		try {
			enviroment = new Enviroment();
			setPortPolicy();
		} catch (Exception e) {
			logger.error("ERROR");
		}
	}
	
	public ServicioWebCesantiasAfiliados getPortCartera() throws MalformedURLException {
		if (portCartera == null){
			setPortPolicy();
		}
		return this.portCartera;
	}
	

	private void setPortPolicy() throws MalformedURLException {
		logger.info("url cartera " + enviroment.getServiceURLCartera());
		URL wsdlURL = new URL(enviroment.getServiceURLCartera()); 
		ServicioWebCesantiasAfiliadosService serviceInstance = new ServicioWebCesantiasAfiliadosService(wsdlURL, SERVICE_NAME);
		this.portCartera = serviceInstance.getServicioWebCesantiasAfiliadosPort();
	}
	
}
