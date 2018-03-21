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
	
	/**
	 * 
	 */
	private static final QName SERVICE_NAME = new QName("http://ws.porvenir.com.co/", "ServicioWebCesantiasAfiliadosService");
	
	/**
	 * 
	 */
	private Log LOGGER = LogFactoryUtil.getLog(Provider.class);
	
	/**
	 * 
	 */
	private ServicioWebCesantiasAfiliados portCesantias;
	
	/**
	 * 
	 */
	private Enviroment enviroment;
	
	/**
	 * 
	 */
	private Provider(){
		try {
			enviroment = new Enviroment();
			setPortCesantias();
		} catch (Exception e) {
			LOGGER.error("ERROR: " + e);
		}
	}
	
	/**
	 * @return
	 * @throws MalformedURLException
	 */
	public ServicioWebCesantiasAfiliados getPortCesantias() throws MalformedURLException {
		if (portCesantias == null){
			setPortCesantias();
		}
		return this.portCesantias;
	}

	/**
	 * @throws MalformedURLException
	 */
	private void setPortCesantias() throws MalformedURLException {
		URL wsdlURL = new URL(enviroment.getServiceURLCartera()); 
		ServicioWebCesantiasAfiliadosService serviceInstance = new ServicioWebCesantiasAfiliadosService(wsdlURL, SERVICE_NAME);
		this.portCesantias = serviceInstance.getServicioWebCesantiasAfiliadosPort();
	}
	
}
