/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 21/03/2018
 * @since 0.0.1 21/03/2018
 */
package co.com.porvenir.ws.dto;

/**
 * Clase con los datos de respuesta al consultar un afiliado
 * @author Alejandro Vivas
 * @since 0.0.1 21/03/2018
 * @version 0.0.1 21/03/2018
 */
public class ConsultaAfiliadosResponse
{
	/** Numero de idenficacion de un afiliado */
	private String noIdentificacionEmpleador;
	/** Nombre del empleador */
	private String nombreEmpleador;
	/** Informacion de los afiliados */
	private AfiliadoResponse[] afiliados;
	/** Indfica el estado de la respuesta (EXITO,ERROR) */
	private String estado;
	/** Mensaje acerca de la respuesta */
	private String mensaje;

	/**
	 * Get the noIdentificacionEmpleador
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @return the noIdentificacionEmpleador
	 */
	public String getNoIdentificacionEmpleador()
	{
		return noIdentificacionEmpleador;
	}

	/**
	 * Set the noIdentificacionEmpleador
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param noIdentificacionEmpleador the noIdentificacionEmpleador to set
	 */
	public void setNoIdentificacionEmpleador(String noIdentificacionEmpleador)
	{
		this.noIdentificacionEmpleador = noIdentificacionEmpleador;
	}

	/**
	 * Get the nombreEmpleador
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @return the nombreEmpleador
	 */
	public String getNombreEmpleador()
	{
		return nombreEmpleador;
	}

	/**
	 * Set the nombreEmpleador
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param nombreEmpleador the nombreEmpleador to set
	 */
	public void setNombreEmpleador(String nombreEmpleador)
	{
		this.nombreEmpleador = nombreEmpleador;
	}

	/**
	 * Get the afiliados
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @return the afiliados
	 */
	public AfiliadoResponse[] getAfiliados()
	{
		return afiliados;
	}

	/**
	 * Set the afiliados
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param afiliados the afiliados to set
	 */
	public void setAfiliados(AfiliadoResponse[] afiliados)
	{
		this.afiliados = afiliados;
	}

	/**
	 * Get the estado
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @return the estado
	 */
	public String getEstado()
	{
		return estado;
	}

	/**
	 * Set the estado
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param estado the estado to set
	 */
	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	/**
	 * Get the mensaje
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @return the mensaje
	 */
	public String getMensaje()
	{
		return mensaje;
	}

	/**
	 * Set the mensaje
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}
}
