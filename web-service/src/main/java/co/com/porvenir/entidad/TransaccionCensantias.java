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

@Entity
@Table(name = "TRANSACCION_CENSANTIAS")
public class TransaccionCensantias {
	@Id
	@Column(name = "ID_TRANSACCION_CENSANTIAS", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AFILIADO", nullable = false)
	private Afiliado afiliado;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EMPLEADOR", nullable = false)
	private Empleador empleador;
	@Column(name = "CANTIDAD", nullable = false)
	private long cantidad;
	@Column(name = "SALDO_ANTIGUO", nullable = false)
	private long saldoAntiguo;
	@Column(name = "SALDO_NUEVO", nullable = false)
	private long saldoNuevo;
	@Column(name = "MENSAJE", nullable = false)
	private String mensaje;
	@Column(name = "TIPO_TRANSACCION", nullable = false)
	private int tipoTransaccion;
	@Column(name = "TIPO_RETIRO",nullable = false)
	private int tipoRetiro;

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
	 * Get the cantidad
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the cantidad
	 */
	public long getCantidad()
	{
		return cantidad;
	}

	/**
	 * Set the cantidad
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(long cantidad)
	{
		this.cantidad = cantidad;
	}

	/**
	 * Get the saldoAntiguo
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the saldoAntiguo
	 */
	public long getSaldoAntiguo()
	{
		return saldoAntiguo;
	}

	/**
	 * Set the saldoAntiguo
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param saldoAntiguo the saldoAntiguo to set
	 */
	public void setSaldoAntiguo(long saldoAntiguo)
	{
		this.saldoAntiguo = saldoAntiguo;
	}

	/**
	 * Get the saldoNuevo
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the saldoNuevo
	 */
	public long getSaldoNuevo()
	{
		return saldoNuevo;
	}

	/**
	 * Set the saldoNuevo
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param saldoNuevo the saldoNuevo to set
	 */
	public void setSaldoNuevo(long saldoNuevo)
	{
		this.saldoNuevo = saldoNuevo;
	}

	/**
	 * Get the mensaje
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the mensaje
	 */
	public String getMensaje()
	{
		return mensaje;
	}

	/**
	 * Set the mensaje
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}

	/**
	 * Get the tipoTransaccion
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @return the tipoTransaccion
	 */
	public int getTipoTransaccion()
	{
		return tipoTransaccion;
	}

	/**
	 * Set the tipoTransaccion
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param tipoTransaccion the tipoTransaccion to set
	 */
	public void setTipoTransaccion(int tipoTransaccion)
	{
		this.tipoTransaccion = tipoTransaccion;
	}

	/**
	 * Set the tipoRetiro
	 * @author Alejandro Vivas
	 * @since 0.0.1 15/03/2018
	 * @version 0.0.1 15/03/2018
	 * @param tipoRetiro the tipoRetiro to set
	 */
	public void setTipoRetiro(int tipoRetiro)
	{
		this.tipoRetiro = tipoRetiro;
	}
	
	/**
	 * Get the tipoRetiro
	 * @author Alejandro Vivas
	 * @since 0.0.1 15/03/2018
	 * @version 0.0.1 15/03/2018
	 * @return the tipoRetiro
	 */
	public int getTipoRetiro()
	{
		return tipoRetiro;
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
		if (!(obj instanceof TransaccionCensantias))
		{
			return false;
		}
		TransaccionCensantias afiliado = (TransaccionCensantias) obj;

		return Objects.equals(this.getId(), afiliado.getId()) 
			&& Objects.equals(this.getAfiliado(), afiliado.getAfiliado())
			&& Objects.equals(this.getEmpleador(), afiliado.getEmpleador())		
			&& Objects.equals(this.getCantidad(), afiliado.getCantidad())
			&& Objects.equals(this.getSaldoAntiguo(), afiliado.getSaldoAntiguo())
			&& Objects.equals(this.getSaldoNuevo(), afiliado.getSaldoNuevo())
			&& Objects.equals(this.getMensaje(), afiliado.getMensaje())
			&& Objects.equals(this.getTipoTransaccion(), afiliado.getTipoTransaccion())
			&& Objects.equals(this.getTipoRetiro(), afiliado.getTipoRetiro());
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
		return Objects.hash(this.getId(), this.getAfiliado(), this.getEmpleador(),this.getCantidad(),this.getSaldoAntiguo(),this.getSaldoNuevo(),this.getMensaje(),this.getTipoTransaccion(),this.getTipoRetiro());
	}
}
