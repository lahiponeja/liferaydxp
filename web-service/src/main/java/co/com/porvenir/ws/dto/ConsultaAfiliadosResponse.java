package co.com.porvenir.ws.dto;

public class ConsultaAfiliadosResponse {
	private String noIdentificacionEmpleador;
	private String nombreEmpleador;
	private AfiliadoResponse [] afiliados;
	private String estado;
	private String mensaje;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getNoIdentificacionEmpleador() {
		return noIdentificacionEmpleador;
	}
	public void setNoIdentificacionEmpleador(String noIdentificacionEmpleador) {
		this.noIdentificacionEmpleador = noIdentificacionEmpleador;
	}
	public String getNombreEmpleador() {
		return nombreEmpleador;
	}
	public void setNombreEmpleador(String nombreEmpleador) {
		this.nombreEmpleador = nombreEmpleador;
	}
	public AfiliadoResponse [] getAfiliados() {
		return afiliados;
	}
	public void setAfiliados(AfiliadoResponse [] afiliados) {
		this.afiliados = afiliados;
	}
}
