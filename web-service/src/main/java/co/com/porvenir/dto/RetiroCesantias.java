/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 21/03/2018
 * @since 0.0.1 21/03/2018
 */
package co.com.porvenir.dto;

/**
 * Clase con los datos necesarios para hace un retiro de cesantias
 * @author Alejandro Vivas
 * @since 0.0.1 21/03/2018
 * @version 0.0.1 21/03/2018
 */
public class RetiroCesantias
{
	/** Id del afiliado */
	private String idAfiliado;
	/** Monto a retirar */
	private long monto;

	/**
	 * Get the idAfiliado
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @return the idAfiliado
	 */
	public String getIdAfiliado()
	{
		return idAfiliado;
	}

	/**
	 * Set the idAfiliado
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param idAfiliado the idAfiliado to set
	 */
	public void setIdAfiliado(String idAfiliado)
	{
		this.idAfiliado = idAfiliado;
	}

	/**
	 * Get the monto
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @return the monto
	 */
	public long getMonto()
	{
		return monto;
	}

	/**
	 * Set the monto
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param monto the monto to set
	 */
	public void setMonto(long monto)
	{
		this.monto = monto;
	}
}
