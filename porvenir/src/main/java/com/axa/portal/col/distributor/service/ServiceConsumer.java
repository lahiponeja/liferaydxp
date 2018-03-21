package com.axa.portal.col.distributor.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import co.com.general.porvenir.dto.Afiliado;
import co.com.porvenir.ws.AfiliadoRequest;
import co.com.porvenir.ws.ConsultaAfiliadosResponse;
import co.com.porvenir.ws.EmpleadorRequest;
import co.com.porvenir.ws.RetiroResponse;

/**
 * @author USER
 *
 */
public enum ServiceConsumer {

	INSTANCE;

	/**
	 * 
	 */
	private static final Log LOGGER = LogFactoryUtil.getLog(ServiceConsumer.class);

	/**
	 * @param afiliados
	 * @return
	 * @throws Exception
	 */
	public ConsultaAfiliadosResponse consultarAfiliados(List<Afiliado> afiliados) throws Exception  {
		try {
	
			EmpleadorRequest request = new EmpleadorRequest();
			request.setId("1");
			
			for (Afiliado afiliado : afiliados) {
				AfiliadoRequest afiliadoRequest = new AfiliadoRequest(); 
				afiliadoRequest.setCantidadRetiro((long)afiliado.getMontoRetiro());
				afiliadoRequest.setId(afiliado.getIdAfiliado());
				request.getAfiliados().add(afiliadoRequest);
			}
			
			ConsultaAfiliadosResponse consultarProductoCompaniaRespTYPE = Provider.INSTANCE.getPortCesantias()
					.consultarAfiliados(request);
			
			return consultarProductoCompaniaRespTYPE;
		} catch (Exception e) {
			LOGGER.error(e);
			throw new Exception(e.getMessage(), e);
		} 
	}
	
	/**
	 * @param afiliados
	 * @return
	 * @throws Exception
	 */
	public RetiroResponse grabarRetiroCesantiasAfiliados(List<Afiliado> afiliados) throws Exception {
		try {
	
			EmpleadorRequest request = new EmpleadorRequest();
			request.setId("1");
			
			for (Afiliado afiliado : afiliados) {
				AfiliadoRequest afiliadoRequest = new AfiliadoRequest(); 
				afiliadoRequest.setCantidadRetiro((long)afiliado.getMontoRetiro());
				afiliadoRequest.setId(afiliado.getIdAfiliado());
				request.getAfiliados().add(afiliadoRequest);
			}
			
			RetiroResponse retiroResponse = Provider.INSTANCE.getPortCesantias()
					.grabarRetiroCesantiasAfiliados(request);
			
			return retiroResponse;
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		} 
	}
	
}