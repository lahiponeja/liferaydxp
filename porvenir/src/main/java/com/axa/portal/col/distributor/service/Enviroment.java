package com.axa.portal.col.distributor.service;



/**
 * Clase para configurar los endpoints de los WS
 * @author USER
 */
public class Enviroment {
	
	private String serviceURLCartera;
	
	public Enviroment (){
		serviceURLCartera = "http://localhost:8068/mockBasicHttpBinding_ITwoWayAsync?WSDL";
	}

	public String getServiceURLCartera() {
		if (serviceURLCartera == null || serviceURLCartera.isEmpty()){
			serviceURLCartera = "http://localhost:8068/mockBasicHttpBinding_ITwoWayAsync?WSDL";
		}
		return serviceURLCartera;
	}

	public void setServiceURLCartera(String serviceURLGeneralLifePolicyDetail) {
		this.serviceURLCartera = serviceURLGeneralLifePolicyDetail;
	}

	
	
}
