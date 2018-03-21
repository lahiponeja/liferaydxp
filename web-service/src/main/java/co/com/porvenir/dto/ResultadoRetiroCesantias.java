/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 20/03/2018
 * @since 0.0.1 20/03/2018
 */
package co.com.porvenir.dto;

import java.util.List;
import java.util.Objects;

/**
 * Objeto conlos datos resultandos de una operacion de retiro de cesantias.
 * @author Alejandro Vivas
 * @since 0.0.1 20/03/2018
 * @version 0.0.1 20/03/2018
 */
public class ResultadoRetiroCesantias
{
	/** Lista con los saldos de la cesantias */
	private List<SaldoCensantias> saldoCensantias;
	/** Id del emepleador */
	private String idEmpleador;
	/** Nombre del empleador */
	private String nombreEmpleador;

	/**
	 * Get the saldoCensantias
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the saldoCensantias
	 */
	public List<SaldoCensantias> getSaldoCensantias()
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
	public void setSaldoCensantias(List<SaldoCensantias> saldoCensantias)
	{
		this.saldoCensantias = saldoCensantias;
	}

	/**
	 * Get the idEmpleador
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the idEmpleador
	 */
	public String getIdEmpleador()
	{
		return idEmpleador;
	}

	/**
	 * Set the idEmpleador
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param idEmpleador the idEmpleador to set
	 */
	public void setIdEmpleador(String idEmpleador)
	{
		this.idEmpleador = idEmpleador;
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
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof ResultadoRetiroCesantias))
		{
			return false;
		}
		ResultadoRetiroCesantias resultadoRetiroCesantias = (ResultadoRetiroCesantias) obj;

		return Objects.equals(this.getIdEmpleador(), resultadoRetiroCesantias.getIdEmpleador())
			&& Objects.equals(this.getNombreEmpleador(), resultadoRetiroCesantias.getNombreEmpleador()) 
			&& Objects.equals(this.getSaldoCensantias(), resultadoRetiroCesantias.getSaldoCensantias());
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
		return Objects.hash(this.getIdEmpleador(), this.getNombreEmpleador(), this.getSaldoCensantias());
	}
}
