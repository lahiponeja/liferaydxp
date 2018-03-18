package co.com.porvenir.dto;

import co.com.porvenir.entidad.Afiliado;

public class SaldoCensantias
{
	private Afiliado afiliado;
	private long monto;
	private long nuevoSaldo;
	private long idTransaccionCesantias;
	private String estado;

	/**
	 * Get the afiliado
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 * @return the afiliado
	 */
	public Afiliado getAfiliado()
	{
		return afiliado;
	}

	/**
	 * Set the afiliado
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 * @param afiliado the afiliado to set
	 */
	public void setAfiliado(Afiliado afiliado)
	{
		this.afiliado = afiliado;
	}

	/**
	 * Get the monto
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 * @return the monto
	 */
	public long getMonto()
	{
		return monto;
	}

	/**
	 * Set the monto
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 * @param monto the monto to set
	 */
	public void setMonto(long monto)
	{
		this.monto = monto;
	}

	/**
	 * Get the nuevoSaldo
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 * @return the nuevoSaldo
	 */
	public long getNuevoSaldo()
	{
		return nuevoSaldo;
	}

	/**
	 * Set the nuevoSaldo
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 * @param nuevoSaldo the nuevoSaldo to set
	 */
	public void setNuevoSaldo(long nuevoSaldo)
	{
		this.nuevoSaldo = nuevoSaldo;
	}

	/**
	 * Get the idTransaccionCesantias
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 * @return the idTransaccionCesantias
	 */
	public long getIdTransaccionCesantias()
	{
		return idTransaccionCesantias;
	}

	/**
	 * Set the idTransaccionCesantias
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 * @param idTransaccionCesantias the idTransaccionCesantias to set
	 */
	public void setIdTransaccionCesantias(long idTransaccionCesantias)
	{
		this.idTransaccionCesantias = idTransaccionCesantias;
	}

	/**
	 * Get the estado
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 * @return the estado
	 */
	public String getEstado()
	{
		return estado;
	}

	/**
	 * Set the estado
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 * @param estado the estado to set
	 */
	public void setEstado(String estado)
	{
		this.estado = estado;
	}
}
