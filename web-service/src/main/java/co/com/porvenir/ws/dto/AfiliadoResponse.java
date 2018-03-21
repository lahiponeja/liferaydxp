/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 21/03/2018
 * @since 0.0.1 21/03/2018
 */
package co.com.porvenir.ws.dto;

/**
 * Clase con los datos de respuesta de un afiliado
 * @author Alejandro Vivas
 * @since 0.0.1 21/03/2018
 * @version 0.0.1 21/03/2018
 */
public class AfiliadoResponse
{
	/** Id del afiliado */
	private String id;
	/** Nombre del afiliado */
	private String nombreAfiliado;
	/** Cantida a retirar */
	private long cantidadRetiro;
	/** Saldo de las cesantias */
	private long saldoCesantias;

	/**
	 * Get the id
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Set the id
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
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
	 * Get the cantidadRetiro
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the cantidadRetiro
	 */
	public long getCantidadRetiro()
	{
		return cantidadRetiro;
	}

	/**
	 * Set the cantidadRetiro
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param cantidadRetiro the cantidadRetiro to set
	 */
	public void setCantidadRetiro(long cantidadRetiro)
	{
		this.cantidadRetiro = cantidadRetiro;
	}

	/**
	 * Get the saldoCesantias
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the saldoCesantias
	 */
	public long getSaldoCesantias()
	{
		return saldoCesantias;
	}

	/**
	 * Set the saldoCesantias
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param saldoCesantias the saldoCesantias to set
	 */
	public void setSaldoCesantias(long saldoCesantias)
	{
		this.saldoCesantias = saldoCesantias;
	}
}
