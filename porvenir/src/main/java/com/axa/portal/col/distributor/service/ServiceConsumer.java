package com.axa.portal.col.distributor.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import co.com.porvenir.ws.ConsultaAfiliadosResponse;
import co.com.porvenir.ws.EmpleadorRequest;

public enum ServiceConsumer {

	INSTANCE;

	private static final Log LOGGER = LogFactoryUtil.getLog(ServiceConsumer.class);

	public ConsultaAfiliadosResponse consultarAfiliados(String idCompania, String idProducto) throws Exception  {
		LOGGER.debug("invoque method consumeConsultarProductoCompania()");
		try {
	
			
			
			EmpleadorRequest _consultarAfiliados_arg0 = new EmpleadorRequest();
			_consultarAfiliados_arg0.setId(idCompania);
			ConsultaAfiliadosResponse consultarProductoCompaniaRespTYPE = Provider.INSTANCE.getPortCartera()
					.consultarAfiliados(_consultarAfiliados_arg0);
			
			return consultarProductoCompaniaRespTYPE;
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		} 
	}

	
	
}
