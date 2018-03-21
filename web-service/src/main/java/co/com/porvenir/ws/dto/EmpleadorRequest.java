/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 21/03/2018
 * @since 0.0.1 21/03/2018
 */
package co.com.porvenir.ws.dto;

/**
 * Clase con los datos de peticion de un empleador
 * @author Alejandro Vivas
 * @since 0.0.1 21/03/2018
 * @version 0.0.1 21/03/2018
 */
public class EmpleadorRequest
{
	/** Id del empleador */
	private String id;
	/** Objeto con los datos del afiliado */
	private AfiliadoRequest[] afiliados;

	/**
	 * Get the id
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Set the id
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * Get the afiliados
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @return the afiliados
	 */
	public AfiliadoRequest[] getAfiliados()
	{
		return afiliados;
	}

	/**
	 * Set the afiliados
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @param afiliados the afiliados to set
	 */
	public void setAfiliados(AfiliadoRequest[] afiliados)
	{
		this.afiliados = afiliados;
	}
}
