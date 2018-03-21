package co.com.porvenir.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import co.com.porvenir.dao.hibernate.util.CargaDatosIniciales;
import co.com.porvenir.dto.ResultadoRetiroCesantias;
import co.com.porvenir.dto.RetiroCesantias;
import co.com.porvenir.dto.SaldoCensantias;
import co.com.porvenir.service.ServicioCesantias;
import co.com.porvenir.service.impl.ServicioImplCesantias;
import co.com.porvenir.ws.dto.AfiliadoRequest;
import co.com.porvenir.ws.dto.AfiliadoResponse;
import co.com.porvenir.ws.dto.ConsultaAfiliadosResponse;
import co.com.porvenir.ws.dto.EmpleadorRequest;
import co.com.porvenir.ws.dto.RetiroCesantiaResponse;
import co.com.porvenir.ws.dto.RetiroResponse;

@WebService(endpointInterface = "co.com.porvenir.ws.ServicioCesantiasAfiliados", serviceName = "ServicioCesantiasAfiliados")
public class ServicioWebImplCesantiasAfiliados implements ServicioWebCesantiasAfiliados
{
	/** Logger de la clase */
	private static Logger logger = Logger.getLogger(ServicioWebImplCesantiasAfiliados.class);
	
	private ServicioCesantias servicioCesantias = new ServicioImplCesantias();

	static
	{
		try
		{
			logger.info("************************ INICIO: CARGA DE DATOS **************************");
			CargaDatosIniciales.cargarDatosIniciales();
			logger.info("************************ FIN   : CARGA DE DATOS **************************");
		}
		catch (Exception e)
		{
			logger.error("Error al cargar datos iniciales",e);
		}
	}

	@Override
	public ConsultaAfiliadosResponse consultarAfiliados(EmpleadorRequest empleadorRequest)
	{
		try
		{
			if (empleadorRequest.getAfiliados() == null || empleadorRequest.getAfiliados().length == 0)
			{
				ConsultaAfiliadosResponse consultaAfiliadosResponse = new ConsultaAfiliadosResponse();
				consultaAfiliadosResponse.setEstado("ERROR");
				consultaAfiliadosResponse.setMensaje("No se enviaron afiliados");
				return consultaAfiliadosResponse;
			}

			List<RetiroCesantias> listaRetiroCesantias = new ArrayList<RetiroCesantias>();
			for (AfiliadoRequest afiliadoRequest : empleadorRequest.getAfiliados())
			{
				RetiroCesantias retiroCesantias = new RetiroCesantias();
				retiroCesantias.setIdAfiliado(afiliadoRequest.getId());
				retiroCesantias.setMonto(afiliadoRequest.getCantidadRetiro());
				listaRetiroCesantias.add(retiroCesantias);
			}

			ResultadoRetiroCesantias resultadoRetiroCesantias = servicioCesantias.validacionRetiroCesantias(empleadorRequest.getId(), listaRetiroCesantias);
			if (resultadoRetiroCesantias.getSaldoCensantias().isEmpty())
			{
				ConsultaAfiliadosResponse consultaAfiliadosResponse = new ConsultaAfiliadosResponse();
				consultaAfiliadosResponse.setEstado("ERROR");
				consultaAfiliadosResponse.setMensaje("No se encontraron afiliados");
				return consultaAfiliadosResponse;
			}

			List<AfiliadoResponse> listaAfiliadoResponse = new ArrayList<AfiliadoResponse>();
			for (SaldoCensantias saldoCensantia : resultadoRetiroCesantias.getSaldoCensantias())
			{
				AfiliadoResponse afiliadoResponse = new AfiliadoResponse();
				afiliadoResponse.setCantidadRetiro(saldoCensantia.getMonto());
				afiliadoResponse.setId(saldoCensantia.getAfiliado().getId());
				afiliadoResponse.setSaldoCesantias(saldoCensantia.getNuevoSaldo());
				afiliadoResponse.setNombreAfiliado(saldoCensantia.getAfiliado().getNombre());
				listaAfiliadoResponse.add(afiliadoResponse);
			}

			ConsultaAfiliadosResponse consultaAfiliadosResponse = new ConsultaAfiliadosResponse();
			AfiliadoResponse[] afiliados = listaAfiliadoResponse.toArray(new AfiliadoResponse[listaAfiliadoResponse.size()]);
			consultaAfiliadosResponse.setAfiliados(afiliados);
			consultaAfiliadosResponse.setEstado("EXITO");
			consultaAfiliadosResponse.setMensaje("Operaciomn exitosa");
			consultaAfiliadosResponse.setNombreEmpleador(resultadoRetiroCesantias.getNombreEmpleador());
			
			return consultaAfiliadosResponse;
		}
		catch (Exception e)
		{
			logger.error("Error al realizar la operacion",e);
			ConsultaAfiliadosResponse consultaAfiliadosResponse = new ConsultaAfiliadosResponse();
			consultaAfiliadosResponse.setEstado("ERROR");
			consultaAfiliadosResponse.setMensaje(e.getMessage());
			return consultaAfiliadosResponse;
		}
	}

	@Override
	public RetiroResponse grabarRetiroCesantiasAfiliados(EmpleadorRequest empleadorRequest)
	{
		try
		{
			List<RetiroCesantias> listaRetiroCesantias = new ArrayList<RetiroCesantias>();
			for (AfiliadoRequest afiliadoRequest : empleadorRequest.getAfiliados())
			{
				RetiroCesantias retiroCesantias = new RetiroCesantias();
				retiroCesantias.setIdAfiliado(afiliadoRequest.getId());
				retiroCesantias.setMonto(afiliadoRequest.getCantidadRetiro());
				listaRetiroCesantias.add(retiroCesantias);
			}
			
			ResultadoRetiroCesantias resultadoRetiroCesantias = this.servicioCesantias.retirarCesantias(empleadorRequest.getId(), listaRetiroCesantias);
			if ( resultadoRetiroCesantias.getSaldoCensantias().isEmpty())
			{
				RetiroResponse retiroResponse = new RetiroResponse();
				retiroResponse.setEstado("ERROR");
				retiroResponse.setMensaje("No se encuentran afiliados");
				return retiroResponse;
			}
			
			List<RetiroCesantiaResponse> listaRetiroCesantiaResponses = new ArrayList<RetiroCesantiaResponse>(resultadoRetiroCesantias.getSaldoCensantias().size());
			for(SaldoCensantias saldoCensantias : resultadoRetiroCesantias.getSaldoCensantias())
			{
				RetiroCesantiaResponse retiroCesantiaResponse = new RetiroCesantiaResponse();
				retiroCesantiaResponse.setEstado(saldoCensantias.getEstado());
				retiroCesantiaResponse.setMontoRetiro(saldoCensantias.getMonto());
				retiroCesantiaResponse.setNoIdentificacionAfiliado(saldoCensantias.getAfiliado().getId());
				retiroCesantiaResponse.setNoRetiro(saldoCensantias.getIdTransaccionCesantias());
				retiroCesantiaResponse.setSaldoCensantias(saldoCensantias.getNuevoSaldo());
				retiroCesantiaResponse.setNombreAfiliado(saldoCensantias.getAfiliado().getNombre());
				listaRetiroCesantiaResponses.add(retiroCesantiaResponse);
			}			
			
			RetiroCesantiaResponse[] retiroCesantiaResponse = listaRetiroCesantiaResponses.toArray(new RetiroCesantiaResponse[resultadoRetiroCesantias.getSaldoCensantias().size()]);
			RetiroResponse retiroResponse = new RetiroResponse();
			retiroResponse.setRetiroCesantiaResponse(retiroCesantiaResponse);
			retiroResponse.setEstado("EXITO");
			retiroResponse.setMensaje("Operacion exitosa");
			retiroResponse.setNombreEmpleador(resultadoRetiroCesantias.getNombreEmpleador());
			return retiroResponse;
		}
		catch(Exception e)
		{
			logger.error("Error al realizar la operacion",e);
			RetiroResponse retiroResponse = new RetiroResponse();
			retiroResponse.setEstado("ERROR");
			retiroResponse.setMensaje(e.getMessage());
			return retiroResponse;
		}
	}
}
