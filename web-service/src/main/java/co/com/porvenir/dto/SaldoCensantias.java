/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 21/03/2018
 * @since 0.0.1 21/03/2018
 */
package co.com.porvenir.dto;

import java.util.Objects;

import co.com.porvenir.entidad.Afiliado;

/**
 * Objeto con los datos SaldoCensantias
 * @author Alejandro Vivas
 * @since 0.0.1 21/03/2018
 * @version 0.0.1 21/03/2018
 */
public class SaldoCensantias
{
	/** Afiliado al que se le revisa el saldo */
	private Afiliado afiliado;
	/** Monto retirado */
	private long monto;
	/** Nuevo saldo de cesantias */
	private long nuevoSaldo;
	/** Id de la transaccion */
	private long idTransaccionCesantias;
	/** Estado de la transaccion */
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
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof SaldoCensantias))
		{
			return false;
		}
		SaldoCensantias afiliado = (SaldoCensantias) obj;

		return Objects.equals(this.getAfiliado(), afiliado.getAfiliado())
			&& Objects.equals(this.getEstado(), afiliado.getEstado())
			&& Objects.equals(this.getMonto(), afiliado.getMonto())
		    && Objects.equals(this.getNuevoSaldo(), afiliado.getNuevoSaldo()) 
			&& Objects.equals(this.getIdTransaccionCesantias(), afiliado.getIdTransaccionCesantias());
	}

	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(this.getAfiliado(), this.getEstado(), this.getMonto(), this.getNuevoSaldo(), this.getIdTransaccionCesantias());
	}
}
