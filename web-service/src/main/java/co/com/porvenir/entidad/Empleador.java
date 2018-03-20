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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase con los datos de un empleador
 * @author Alejandro Vivas
 * @since 0.0.1 20/03/2018
 * @version 0.0.1 20/03/2018
 */
@Entity
@Table
(
	name="EMPLEADOR"
)
public class Empleador {
	@Id
	@Column(name="ID_EMPLEADOR")
	private String id;
	@Column(name="NOMBRE",nullable=false)
	private String nombre;
	
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

	/** (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 */
	@Override	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Empleador))
		{
			return false;
		}
		Empleador empleador = (Empleador)obj;
		
		return Objects.equals(this.getId(), empleador.getId()) 
			&& Objects.equals(this.getNombre(), empleador.getNombre());
	}
	
	/** (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 */
	@Override
	public int hashCode()
	{
		return  Objects.hash(this.getId(),this.getNombre());
	}
}
