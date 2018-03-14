package com.axa.portal.col.distributor.service;



/**
 * Clase para configurar los endpoints de los WS
 * @author USER
 */
public class Enviroment {
	
	private String serviceURLCartera;
	
	public Enviroment (){
		serviceURLCartera = "http://localhost:9090/mockServicioWebCesantiasAfiliadosServiceSoapBinding?WSDL";
	}

	public String getServiceURLCartera() {
		if (serviceURLCartera == null || serviceURLCartera.isEmpty()){
			serviceURLCartera = "http://localhost:9090/mockServicioWebCesantiasAfiliadosServiceSoapBinding?WSDL";
		}
		return serviceURLCartera;
	}

	public void setServiceURLCartera(String serviceURLGeneralLifePolicyDetail) {
		this.serviceURLCartera = serviceURLGeneralLifePolicyDetail;
	}

	
	
}
