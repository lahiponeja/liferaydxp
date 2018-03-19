package co.com.porvenir.dao;

import java.util.List;

import co.com.porvenir.entidad.Afiliado;

public interface AfiliadoDao {
	public List<Afiliado> afiliadosPorEmpleador(String idEmpleador,List<String> idsEmpleados);
}
