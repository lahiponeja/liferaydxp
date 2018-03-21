/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 21/03/2018
 * @since 0.0.1 21/03/2018
 */
package co.com.porvenir.ws.dto;

/**
 * Clase con la respuesta de un retiro de cesantias
 * @author Alejandro Vivas
 * @since 0.0.1 21/03/2018
 * @version 0.0.1 21/03/2018
 */
public class RetiroCesantiaResponse
{
	/** Numero de retiro */
	private long noRetiro;
	/** Numero de identificacion del afiliado */
	private String noIdentificacionAfiliado;
	/** Nombre del afiliado */
	private String nombreAfiliado;
	/** Monto del retiro */
	private long montoRetiro;
	/** Saldo de las cesantias */
	private long saldoCensantias;
	/** Estado de la operacion */
	private String estado;

	/**
	 * Get the noRetiro
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the noRetiro
	 */
	public long getNoRetiro()
	{
		return noRetiro;
	}

	/**
	 * Set the noRetiro
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param noRetiro the noRetiro to set
	 */
	public void setNoRetiro(long noRetiro)
	{
		this.noRetiro = noRetiro;
	}

	/**
	 * Get the noIdentificacionAfiliado
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the noIdentificacionAfiliado
	 */
	public String getNoIdentificacionAfiliado()
	{
		return noIdentificacionAfiliado;
	}

	/**
	 * Set the noIdentificacionAfiliado
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param noIdentificacionAfiliado the noIdentificacionAfiliado to set
	 */
	public void setNoIdentificacionAfiliado(String noIdentificacionAfiliado)
	{
		this.noIdentificacionAfiliado = noIdentificacionAfiliado;
	}

	/**
	 * Get the nombreAfiliado
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the nombreAfiliado
	 */
	public String getNombreAfiliado()
	{
		return nombreAfiliado;
	}

	/**
	 * Set the nombreAfiliado
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param nombreAfiliado the nombreAfiliado to set
	 */
	public void setNombreAfiliado(String nombreAfiliado)
	{
		this.nombreAfiliado = nombreAfiliado;
	}

	/**
	 * Get the montoRetiro
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the montoRetiro
	 */
	public long getMontoRetiro()
	{
		return montoRetiro;
	}

	/**
	 * Set the montoRetiro
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param montoRetiro the montoRetiro to set
	 */
	public void setMontoRetiro(long montoRetiro)
	{
		this.montoRetiro = montoRetiro;
	}

	/**
	 * Get the saldoCensantias
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the saldoCensantias
	 */
	public long getSaldoCensantias()
	{
		return saldoCensantias;
	}

	/**
	 * Set the saldoCensantias
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param saldoCensantias the saldoCensantias to set
	 */
	public void setSaldoCensantias(long saldoCensantias)
	{
		this.saldoCensantias = saldoCensantias;
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
}
