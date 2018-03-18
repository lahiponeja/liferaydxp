package co.com.porvenir.ws.dto;

public class EmpleadorRequest {
	private String id;
	private AfiliadoRequest [] afiliados;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AfiliadoRequest [] getAfiliados() {
		return afiliados;
	}
	public void setAfiliados(AfiliadoRequest [] afiliados) {
		this.afiliados = afiliados;
	}	
}
