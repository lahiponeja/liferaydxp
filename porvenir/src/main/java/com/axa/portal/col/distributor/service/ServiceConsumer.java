package com.axa.portal.col.distributor.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import co.com.general.porvenir.dto.Afiliado;
import co.com.porvenir.ws.AfiliadoRequest;
import co.com.porvenir.ws.ConsultaAfiliadosResponse;
import co.com.porvenir.ws.EmpleadorRequest;

public enum ServiceConsumer {

	INSTANCE;

	private static final Log LOGGER = LogFactoryUtil.getLog(ServiceConsumer.class);

	public ConsultaAfiliadosResponse consultarAfiliados(List<Afiliado> afiliados) throws Exception  {
		LOGGER.debug("invoque method consumeConsultarProductoCompania()");
		try {
	
			EmpleadorRequest request = new EmpleadorRequest();
			request.setId("1");
			
			for (Afiliado afiliado : afiliados) {
				AfiliadoRequest afiliadoRequest = new AfiliadoRequest(); 
				afiliadoRequest.setCantidadRetiro(afiliado.getMontoRetiro());
				afiliadoRequest.setId(afiliado.getIdAfiliado());
				request.getAfiliados().add(afiliadoRequest);
			}
			
			ConsultaAfiliadosResponse consultarProductoCompaniaRespTYPE = Provider.INSTANCE.getPortCartera()
					.consultarAfiliados(request);
			
			return consultarProductoCompaniaRespTYPE;
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		} 
	}

	
	
}
