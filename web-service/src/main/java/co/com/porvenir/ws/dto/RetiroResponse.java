package co.com.porvenir.ws.dto;

public class RetiroResponse
{
	private String noIdentificacionEmpleador;
	private RetiroCesantiaResponse[] retiroCesantiaResponse;
	private String estado;
	private String mensaje;

	public String getEstado()
	{
		return estado;
	}

	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	public String getMensaje()
	{
		return mensaje;
	}

	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}

	public String getNoIdentificacionEmpleador()
	{
		return noIdentificacionEmpleador;
	}

	public void setNoIdentificacionEmpleador(String noIdentificacionEmpleador)
	{
		this.noIdentificacionEmpleador = noIdentificacionEmpleador;
	}

	public RetiroCesantiaResponse[] getRetiroCesantiaResponse()
	{
		return retiroCesantiaResponse;
	}

	public void setRetiroCesantiaResponse(RetiroCesantiaResponse[] retiroCesantiaResponse)
	{
		this.retiroCesantiaResponse = retiroCesantiaResponse;
	}

}
