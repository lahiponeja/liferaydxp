/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 14/03/2018
 * @since 0.0.1 14/03/2018
 */
package co.com.porvenir.service;

/**
 * Excepcion en caso de falla alguna operacion
 * @author Alejandro Vivas
 * @since 0.0.1 14/03/2018
 * @version 0.0.1 14/03/2018
 */
public class ServicioException extends Exception
{
	/**
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 */
	public ServicioException(String mensaje)
	{
		super(mensaje);
	}
}
