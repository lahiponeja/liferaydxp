package co.com.porvenir.dao;

import java.util.List;

import co.com.porvenir.entidad.Cesantia;

public interface CesantiaDao
{

	public List<Cesantia> cesantiasFiltroEmpleadorAfiliados(String idEmpleador, List<String> idsAfiliados);

}
