package com.axa.portal.col.distributor.service;

import co.axacolpatria.entidad.dominiocomun.comun._2.FrecuenciaPagoTYPE;
import co.axacolpatria.entidad.dominiocomun.comun._2.IdentificacionNivelAtencionTYPE;
import co.axacolpatria.entidad.dominiocomun.documento._2.ArchivoTYPE;
import co.axacolpatria.entidad.dominiocomun.encabezados._2.EncabezadoEntradaTYPE;
import co.axacolpatria.entidad.dominiodistribuidor.distribuidorcartera._1.TipoCarteraTYPE;
import co.axacolpatria.entidad.dominiopersona.persona._2.IdentificacionPersonaTYPE;
import co.axacolpatria.entidad.dominiopersona.persona._2.TipoIdentificacionTYPE;
import co.axacolpatria.entidad.dominiopersona.persona._2.TipoPersonaTYPE;
import co.axacolpatria.entidad.dominioproducto.producto._2.IdentificacionCompaniaTYPE;
import co.axacolpatria.entidad.dominioproducto.producto._2.IdentificacionProductoTYPE;
import co.axacolpatria.mensajenegocio.dominiocartera.consultardetallecarteracontratoreq._1.ConsultarDetalleCarteraReqBodyTYPE;
import co.axacolpatria.mensajenegocio.dominiocartera.consultardetallecarteracontratoreq._1.ConsultarDetalleCarteraReqTYPE;
import co.axacolpatria.mensajenegocio.dominiocartera.consultardetallecarteracontratoresp._1.ConsultarDetalleCarteraContratoRespTYPE;
import co.axacolpatria.mensajenegocio.dominiocartera.consultarnivelatencioncarterareq._1.ConsultarNivelAtencionCarteraReqBodyTYPE;
import co.axacolpatria.mensajenegocio.dominiocartera.consultarnivelatencioncarterareq._1.ConsultarNivelAtencionCarteraReqTYPE;
import co.axacolpatria.mensajenegocio.dominiocartera.consultarnivelatencioncarteraresp._1.ConsultarNivelAtencionCarteraRespTYPE;
import co.axacolpatria.mensajenegocio.dominiocartera.consultartotalcarteradistribuidorreq._1.ConsultarTotalCarteraDistribuidorReqBodyTYPE;
import co.axacolpatria.mensajenegocio.dominiocartera.consultartotalcarteradistribuidorreq._1.ConsultarTotalCarteraDistribuidorReqTYPE;
import co.axacolpatria.mensajenegocio.dominiocartera.consultartotalcarteradistribuidorresp._1.ConsultarTotalCarteraDistribuidorRespTYPE;
import co.axacolpatria.mensajenegocio.dominioproducto.consultarproductocompaniareq._1.ConsultarProductoCompaniaReqBodyTYPE;
import co.axacolpatria.mensajenegocio.dominioproducto.consultarproductocompaniareq._1.ConsultarProductoCompaniaReqTYPE;
import co.axacolpatria.mensajenegocio.dominioproducto.consultarproductocompaniaresp._1.ConsultarProductoCompaniaRespTYPE;
import co.axacolpatria.mensajeutilidad.dominiocartera.exportarcarteradistribuidorreq._1.ExportarCarteraDistribuidorReq;
import co.axacolpatria.mensajeutilidad.dominiocartera.exportarcarteradistribuidorresp._1.ExportarCarteraDistribuidorResp;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.portal.commons.util.DPWUtil;

import java.util.Date;

public enum ServiceConsumer {

	INSTANCE;

	private static final Log LOGGER = LogFactoryUtil.getLog(ServiceConsumer.class);

	public ConsultarProductoCompaniaRespTYPE consumeConsultarProductoCompania(String idCompania, String idProducto) throws Exception  {
		LOGGER.debug("invoque method consumeConsultarProductoCompania()");
		try {
			ConsultarProductoCompaniaReqTYPE request = new ConsultarProductoCompaniaReqTYPE();
			ConsultarProductoCompaniaReqBodyTYPE body = new ConsultarProductoCompaniaReqBodyTYPE();
			IdentificacionCompaniaTYPE compania = new IdentificacionCompaniaTYPE();
			compania.setIdCompania(idCompania); 
			body.setCompania(compania);
			
			IdentificacionProductoTYPE producto = new IdentificacionProductoTYPE();
			producto.setIdProducto(idProducto);
			body.setProducto(producto);
			
			request.setBODY(body);
			
			
			EncabezadoEntradaTYPE header = new EncabezadoEntradaTYPE();
			header.setCanal("DPW");
			header.setIdCorrelacionConsumidor(PortalUUIDUtil.generate());
			header.setPeticionFecha(DPWUtil.getDateGregorianCalendar());
			request.setHEADER(header);
			ConsultarProductoCompaniaRespTYPE consultarProductoCompaniaRespTYPE = Provider.INSTANCE.getPortCartera()
					.consultarProductoPorCompania(request);
			
			return consultarProductoCompaniaRespTYPE;
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		} 
	}

	
	
}
