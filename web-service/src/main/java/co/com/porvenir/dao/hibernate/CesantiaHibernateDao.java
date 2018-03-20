/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 20/03/2018
 * @since 0.0.1 20/03/2018
 */
package co.com.porvenir.dao.hibernate;

import java.util.List;

import javax.persistence.Query;

import co.com.porvenir.dao.CesantiaDao;
import co.com.porvenir.entidad.Cesantia;

/**
 * Dao para la entidad Cesantia
 * @author Alejandro Vivas
 * @since 0.0.1 20/03/2018
 * @version 0.0.1 20/03/2018
 */
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
