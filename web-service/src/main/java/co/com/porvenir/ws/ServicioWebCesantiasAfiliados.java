/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 21/03/2018
 * @since 0.0.1 21/03/2018
 */
package co.com.porvenir.ws;

import javax.jws.WebService;

import co.com.porvenir.ws.dto.EmpleadorRequest;
import co.com.porvenir.ws.dto.ConsultaAfiliadosResponse;
import co.com.porvenir.ws.dto.RetiroResponse;

/**
 * Interfaz que debe implementar el servicio web de afiliados
 * @author Alejandro Vivas
 * @since 0.0.1 21/03/2018
 * @version 0.0.1 21/03/2018
 */
@WebService
public interface ServicioWebCesantiasAfiliados 
{
	/**
	 * Consulta la informacion para hacer un retiro
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param empleador Objeto con los datos del empleador y los afiliados para validar retiro
	 * @return Objeto con la respuesta
	 */
	ConsultaAfiliadosResponse consultarAfiliados(EmpleadorRequest empleador);
	
	/**
	 * Almacena los retiros de cesantias para los afiliados
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param afiliadoRequest Objeto con los datos para hacer un retiro
	 * @return OBjeto con la respuesta del servicio web
	 */
	RetiroResponse grabarRetiroCesantiasAfiliados(EmpleadorRequest afiliadoRequest);
}
