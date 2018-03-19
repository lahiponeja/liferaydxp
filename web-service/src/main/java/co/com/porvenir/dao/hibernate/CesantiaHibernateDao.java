package co.com.porvenir.dao.hibernate;

import java.util.List;

import javax.persistence.Query;

import co.com.porvenir.dao.CesantiaDao;
import co.com.porvenir.entidad.Cesantia;

public class CesantiaHibernateDao extends HibernateDao implements CesantiaDao
{
	/** Consulta con las cesantias por empleador e id de empleado */
	private static final String CONSULTA_CESANTIAS_POR_EMPLEADOR_Y_IDS_EMPLEADOS = "select cesantia from Cesantia cesantia join fetch cesantia.afiliado afiliado join fetch afiliado.empleador empleador  where cesantia.afiliado.empleador.id = :ID_EMPLEADOR and cesantia.afiliado.id in (:IDS_AFILIADO)";

	@SuppressWarnings("unchecked")
	@Override
	public List<Cesantia> cesantiasFiltroEmpleadorAfiliados(String idEmpleador, List<String> idsAfiliados)
	{
		Query query = getEntityManager().createQuery(CONSULTA_CESANTIAS_POR_EMPLEADOR_Y_IDS_EMPLEADOS);
		query.setParameter("ID_EMPLEADOR", idEmpleador);
		query.setParameter("IDS_AFILIADO", idsAfiliados);
		return query.getResultList();
	}
	
}
