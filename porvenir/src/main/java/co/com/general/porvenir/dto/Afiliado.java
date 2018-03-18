package co.com.general.porvenir.dto;

public class Afiliado {
	
	//excel - input servicio

	private String idEmpleador;
	
	private String idAfiliado;
	
	private Integer montoRetiro;
	
	private String nombreAfiliado;
	
	//output servicio
	private Integer saldoCesantias;

	public String getIdEmpleador() {
		return idEmpleador;
	}

	public void setIdEmpleador(String idEmpleador) {
		this.idEmpleador = idEmpleador;
	}

	public String getIdAfiliado() {
		return idAfiliado;
	}

	public void setIdAfiliado(String idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	public Integer getMontoRetiro() {
		return montoRetiro;
	}

	public void setMontoRetiro(Integer montoRetiro) {
		this.montoRetiro = montoRetiro;
	}

	public String getNombreAfiliado() {
		return nombreAfiliado;
	}

	public void setNombreAfiliado(String nombreAfiliado) {
		this.nombreAfiliado = nombreAfiliado;
	}

	public Integer getSaldoCesantias() {
		return saldoCesantias;
	}

	public void setSaldoCesantias(Integer saldoCesantias) {
		this.saldoCesantias = saldoCesantias;
	}
	
}
