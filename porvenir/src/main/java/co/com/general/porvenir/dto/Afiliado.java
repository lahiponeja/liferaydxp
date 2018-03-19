package co.com.general.porvenir.dto;

public class Afiliado {
	
	//excel - input servicio

	private String idEmpleador;
	
	private String idAfiliado;
	
	private double montoRetiro;
	
	private String nombreAfiliado;
	
	//output servicio
	private double saldoCesantias;

	

	public double getMontoRetiro() {
		return montoRetiro;
	}

	public void setMontoRetiro(double montoRetiro) {
		this.montoRetiro = montoRetiro;
	}

	public double getSaldoCesantias() {
		return saldoCesantias;
	}

	public void setSaldoCesantias(double saldoCesantias) {
		this.saldoCesantias = saldoCesantias;
	}

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

	

	public String getNombreAfiliado() {
		return nombreAfiliado;
	}

	public void setNombreAfiliado(String nombreAfiliado) {
		this.nombreAfiliado = nombreAfiliado;
	}

	
	
}
