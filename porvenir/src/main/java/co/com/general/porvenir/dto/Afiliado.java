package co.com.general.porvenir.dto;

public class Afiliado {
	
	//excel - input servicio

	private String idEmpleador;
	
	private String idAfiliado;
	
	private double montoRetiro;
	
	private String nombreAfiliado;
	
	private String motivo;
	
	/*Beneficiario*/
	private String tipoDocumentoBeneficiario;
	private String numeroDocumentoBeneficiario;
	private String razonSocialBeneficiario;
	
	public String getTipoDocumentoBeneficiario() {
		return tipoDocumentoBeneficiario;
	}

	public void setTipoDocumentoBeneficiario(String tipoDocumentoBeneficiario) {
		this.tipoDocumentoBeneficiario = tipoDocumentoBeneficiario;
	}

	public String getNumeroDocumentoBeneficiario() {
		return numeroDocumentoBeneficiario;
	}

	public void setNumeroDocumentoBeneficiario(String numeroDocumentoBeneficiario) {
		this.numeroDocumentoBeneficiario = numeroDocumentoBeneficiario;
	}

	public String getRazonSocialBeneficiario() {
		return razonSocialBeneficiario;
	}

	public void setRazonSocialBeneficiario(String razonSocialBeneficiario) {
		this.razonSocialBeneficiario = razonSocialBeneficiario;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

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
