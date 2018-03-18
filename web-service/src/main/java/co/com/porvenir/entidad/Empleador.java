package co.com.porvenir.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}
