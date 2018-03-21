/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 21/03/2018
 * @since 0.0.1 21/03/2018
 */
package co.com.porvenir.service;

import java.util.List;

import co.com.porvenir.dto.ResultadoRetiroCesantias;
import co.com.porvenir.dto.RetiroCesantias;

/**
 * Clase con las operaciones necesarias sobre las cesantias 
 * @author Alejandro Vivas
 * @since 0.0.1 21/03/2018
 * @version 0.0.1 21/03/2018
 */
public interface ServicioCesantias
{
	/**
	 * Realiza una validacion de la informacion para realizar un retiro de cesantias
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param idEmpleador Id del empleador
	 * @param retiroCesantias Lista con la informacion de retiro de cesantias para cada afiliado 
	 * @return Objeto indocando el resultado de la validacion
	 * @throws ServicioException Si falla la operacion
	 */
	public ResultadoRetiroCesantias validacionRetiroCesantias(String idEmpleador, List<RetiroCesantias> retiroCesantias) throws ServicioException;

	/**
	 * Realiza el retiro de cesantias para afiliados por parte de un empleador
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param idEmpleador Id del empleador
	 * @param retiroCesantias Retiro de cesantias 
	 * @return Objeto con los datos del retiro de la censantias
	 * @throws ServicioException Sucede si:
	 * - Algun monto a retirar es igual o inferior a cero
	 * - El monto a retirar supera el saldo
	 * - Algun otro fallo
	 */
	public ResultadoRetiroCesantias retirarCesantias(String idEmpleador, List<RetiroCesantias> retiroCesantias) throws ServicioException;
}
