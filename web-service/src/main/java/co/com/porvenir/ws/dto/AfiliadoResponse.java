package co.com.porvenir.ws.dto;

public class AfiliadoResponse
{
	private String id;
	private String nombreAfiliado;
	private long cantidadRetiro;
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
