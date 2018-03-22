package co.com.general.provenir.service;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;

/**
 * Clase para configurar los endpoints de los WS
 * @author USER
 */
public class Enviroment {
	
	private final static String SERVICE_URL = "service-url";
	private String serviceURLCesantias;
	
	public Enviroment (){
		Configuration configuration=ConfigurationFactoryUtil.getConfiguration(Enviroment.class.getClassLoader(), "portlet");
		String mailSubject = configuration.get(SERVICE_URL);
		serviceURLCesantias = mailSubject;
	}

	public String getServiceURLCesantias() {
		if (serviceURLCesantias == null || serviceURLCesantias.isEmpty()){
			Configuration configuration=ConfigurationFactoryUtil.getConfiguration(Enviroment.class.getClassLoader(), "portlet");
			String mailSubject = configuration.get(SERVICE_URL);
			serviceURLCesantias = mailSubject;
		}
		return serviceURLCesantias;
	}

	public void setServiceURLCesantias(String serviceURLGeneralLifePolicyDetail) {
		this.serviceURLCesantias = serviceURLGeneralLifePolicyDetail;
	}

	
	
}
