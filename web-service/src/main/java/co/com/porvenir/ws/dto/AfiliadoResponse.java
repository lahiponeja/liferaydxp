package co.com.porvenir.ws.dto;

public class AfiliadoResponse {
	private String id;
	private long cantidadRetiro;
	private long saldoCesantias;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getCantidadRetiro() {
		return cantidadRetiro;
	}
	public void setCantidadRetiro(long cantidadRetiro) {
		this.cantidadRetiro = cantidadRetiro;
	}	
	public void setSaldoCesantias(long saldoCesantias) {
		this.saldoCesantias = saldoCesantias;
	}
	public long getSaldoCesantias() {
		return saldoCesantias;
	}
}
