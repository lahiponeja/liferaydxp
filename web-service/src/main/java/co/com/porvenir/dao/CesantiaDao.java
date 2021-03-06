/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 21/03/2018
 * @since 0.0.1 21/03/2018
 */
package co.com.porvenir.dao;

import java.util.List;

import co.com.porvenir.entidad.Cesantia;

public interface CesantiaDao
{

	public List<Cesantia> cesantiasFiltroEmpleadorAfiliados(String idEmpleador, List<String> idsAfiliados);

}
