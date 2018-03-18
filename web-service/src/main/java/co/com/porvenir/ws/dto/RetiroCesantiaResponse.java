package co.com.porvenir.ws.dto;

public class RetiroCesantiaResponse {
	private long noRetiro;
	private String noIdentificacionAfiliado;
	private long montoRetiro;
	private long saldoCensantias;
	private String estado;
	public long getNoRetiro() {
		return noRetiro;
	}
	public void setNoRetiro(long noRetiro) {
		this.noRetiro = noRetiro;
	}
	public String getNoIdentificacionAfiliado() {
		return noIdentificacionAfiliado;
	}
	public void setNoIdentificacionAfiliado(String noIdentificacionAfiliado) {
		this.noIdentificacionAfiliado = noIdentificacionAfiliado;
	}
	public long getMontoRetiro() {
		return montoRetiro;
	}
	public void setMontoRetiro(long montoRetiro) {
		this.montoRetiro = montoRetiro;
	}
	public long getSaldoCensantias() {
		return saldoCensantias;
	}
	public void setSaldoCensantias(long saldoCensantias) {
		this.saldoCensantias = saldoCensantias;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
