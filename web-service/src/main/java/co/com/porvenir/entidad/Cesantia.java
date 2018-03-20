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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Clase con la informacion de cesantias para un afiliado
 * @author Alejandro Vivas
 * @since 0.0.1 20/03/2018
 * @version 0.0.1 20/03/2018
 */
@Entity
@Table(name = "CESANTIA", uniqueConstraints = { @UniqueConstraint(name = "UK_USUARIO_CESANTIA", columnNames = { "ID_AFILIADO" }) })
public class Cesantia
{
	@Id
	@Column(name = "ID_CESANTIA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AFILIADO", nullable = false)
	private Afiliado afiliado;
	@Column(name = "SALDO", nullable = false)
	private long saldo;

	/**
	 * Get the id
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the id
	 */
	public long getId()
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
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * Get the afiliado
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the afiliado
	 */
	public Afiliado getAfiliado()
	{
		return afiliado;
	}

	/**
	 * Set the afiliado
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param afiliado the afiliado to set
	 */
	public void setAfiliado(Afiliado afiliado)
	{
		this.afiliado = afiliado;
	}

	/**
	 * Get the saldo
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the saldo
	 */
	public long getSaldo()
	{
		return saldo;
	}

	/**
	 * Set the saldo
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param saldo the saldo to set
	 */
	public void setSaldo(long saldo)
	{
		this.saldo = saldo;
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
		if(!(obj instanceof Cesantia))
		{
			return false;
		}
		Cesantia cesantia = (Cesantia)obj;
		
		return Objects.equals(this.getId(), cesantia.getId()) 
			&& Objects.equals(this.getSaldo(), cesantia.getSaldo()) 
			&& Objects.equals(this.getAfiliado(), cesantia.getAfiliado());
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
		return  Objects.hash(this.getId(),this.getSaldo(),this.getAfiliado());
	}
}
