package co.com.porvenir.ws;

import javax.jws.WebService;

import co.com.porvenir.ws.dto.EmpleadorRequest;
import co.com.porvenir.ws.dto.ConsultaAfiliadosResponse;
import co.com.porvenir.ws.dto.RetiroResponse;

@WebService
public interface ServicioWebCesantiasAfiliados 
{
	ConsultaAfiliadosResponse consultarAfiliados(EmpleadorRequest empleador);
	
	RetiroResponse grabarRetiroCesantiasAfiliados(EmpleadorRequest afiliadoRequest);
}
