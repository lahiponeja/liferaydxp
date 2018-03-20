/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 20/03/2018
 * @since 0.0.1 20/03/2018
 */
package co.com.porvenir.entidad;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase con la informacion de un Afiliado.
 * @author Alejandro Vivas
 * @since 0.0.1 20/03/2018
 * @version 0.0.1 20/03/2018
 */
@Entity
@Table(name = "AFILIADO")
public class Afiliado
{
	@Id
	@Column(name = "ID_AFILIADO")
	private String id;
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EMPLEADOR", nullable = false)
	private Empleador empleador;

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
	 * Get the nombre
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the nombre
	 */
	public String getNombre()
	{
		return nombre;
	}

	/**
	 * Set the nombre
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	/**
	 * Get the empleador
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the empleador
	 */
	public Empleador getEmpleador()
	{
		return empleador;
	}

	/**
	 * Set the empleador
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param empleador the empleador to set
	 */
	public void setEmpleador(Empleador empleador)
	{
		this.empleador = empleador;
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
		if (!(obj instanceof Afiliado))
		{
			return false;
		}
		Afiliado afiliado = (Afiliado) obj;

		return Objects.equals(this.getId(), afiliado.getId()) && Objects.equals(this.getNombre(), afiliado.getNombre()) && Objects.equals(this.getEmpleador(), afiliado.getEmpleador());
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
		return Objects.hash(this.getId(), this.getNombre(), this.getEmpleador());
	}
}
