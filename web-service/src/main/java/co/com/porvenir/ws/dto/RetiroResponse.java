package co.com.porvenir.ws.dto;

public class RetiroResponse
{
	private String noIdentificacionEmpleador;
	private String nombreEmpleador;
	private RetiroCesantiaResponse[] retiroCesantiaResponse;
	private String estado;
	private String mensaje;

	/**
	 * Get the noIdentificacionEmpleador
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the noIdentificacionEmpleador
	 */
	public String getNoIdentificacionEmpleador()
	{
		return noIdentificacionEmpleador;
	}

	/**
	 * Set the noIdentificacionEmpleador
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param noIdentificacionEmpleador the noIdentificacionEmpleador to set
	 */
	public void setNoIdentificacionEmpleador(String noIdentificacionEmpleador)
	{
		this.noIdentificacionEmpleador = noIdentificacionEmpleador;
	}

	/**
	 * Get the nombreEmpleador
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the nombreEmpleador
	 */
	public String getNombreEmpleador()
	{
		return nombreEmpleador;
	}

	/**
	 * Set the nombreEmpleador
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param nombreEmpleador the nombreEmpleador to set
	 */
	public void setNombreEmpleador(String nombreEmpleador)
	{
		this.nombreEmpleador = nombreEmpleador;
	}

	/**
	 * Get the retiroCesantiaResponse
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the retiroCesantiaResponse
	 */
	public RetiroCesantiaResponse[] getRetiroCesantiaResponse()
	{
		return retiroCesantiaResponse;
	}

	/**
	 * Set the retiroCesantiaResponse
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param retiroCesantiaResponse the retiroCesantiaResponse to set
	 */
	public void setRetiroCesantiaResponse(RetiroCesantiaResponse[] retiroCesantiaResponse)
	{
		this.retiroCesantiaResponse = retiroCesantiaResponse;
	}

	/**
	 * Get the estado
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the estado
	 */
	public String getEstado()
	{
		return estado;
	}

	/**
	 * Set the estado
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param estado the estado to set
	 */
	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	/**
	 * Get the mensaje
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the mensaje
	 */
	public String getMensaje()
	{
		return mensaje;
	}

	/**
	 * Set the mensaje
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}
}
