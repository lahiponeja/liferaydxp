package co.com.porvenir.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
(
	name="AFILIADO"
)
public class Afiliado {
	@Id
	@Column(name="ID_AFILIADO")	
	private String id;
	@Column(name="NOMBRE",nullable=false)
	private String nombre;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EMPLEADOR",nullable=false)
	private Empleador empleador;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Empleador getEmpleador() {
		return empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
