package co.com.porvenir.ws.dto;

public class AfiliadoRequest {
	private String id;
	private long cantidadRetiro;
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
}
