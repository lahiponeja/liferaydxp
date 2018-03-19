package co.com.porvenir.entidad;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Afiliado getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}

	public Empleador getEmpleador() {
		return empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(int tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public long getSaldoAntiguo() {
		return saldoAntiguo;
	}

	public void setSaldoAntiguo(long saldoAntiguo) {
		this.saldoAntiguo = saldoAntiguo;
	}

	public long getSaldoNuevo() {
		return saldoNuevo;
	}

	public void setSaldoNuevo(long saldoNuevo) {
		this.saldoNuevo = saldoNuevo;
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
}
