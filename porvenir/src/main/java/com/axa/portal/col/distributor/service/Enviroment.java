package com.axa.portal.col.distributor.service;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;

/**
 * Clase para configurar los endpoints de los WS
 * @author USER
 */
public class Enviroment {
	
	private final static String SERVICE_URL = "service-url";
	private String serviceURLCartera;
	
	public Enviroment (){
		//serviceURLCartera = "http://200.119.44.98:9000/ServicioCesantiasAfiliados?wsdl";
		Configuration configuration=ConfigurationFactoryUtil.getConfiguration(Enviroment.class.getClassLoader(), "portlet");
		String mailSubject = configuration.get(SERVICE_URL);
		serviceURLCartera = mailSubject;
		System.out.println("serviceURLCartera " + serviceURLCartera);
	}

	public String getServiceURLCartera() {
		if (serviceURLCartera == null || serviceURLCartera.isEmpty()){
			Configuration configuration=ConfigurationFactoryUtil.getConfiguration(Enviroment.class.getClassLoader(), "portlet");
			String mailSubject = configuration.get(SERVICE_URL);
			serviceURLCartera = mailSubject;
			System.out.println("serviceURLCartera " + serviceURLCartera);
		}
		return serviceURLCartera;
	}

	public void setServiceURLCartera(String serviceURLGeneralLifePolicyDetail) {
		this.serviceURLCartera = serviceURLGeneralLifePolicyDetail;
	}

	
	
}
