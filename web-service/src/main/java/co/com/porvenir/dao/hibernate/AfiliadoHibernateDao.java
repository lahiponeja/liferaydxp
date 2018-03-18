package co.com.porvenir.dao.hibernate;

import java.util.List;

import javax.persistence.Query;

import co.com.porvenir.dao.AfiliadoDao;
import co.com.porvenir.entidad.Afiliado;

public class AfiliadoHibernateDao extends HibernateDao implements AfiliadoDao
{
	private static final String CONSULTA_AFILIADOS_POR_EMPLEADOR_Y_IDS_EMPLEADOS = "select afiliado from Afiliado afiliado where afiliado.empleador.id = :ID_EMPLEADOR and afiliado.id in (:IDS_EMPLEADOS)";

	@SuppressWarnings("unchecked")
	@Override
	public List<Afiliado> afiliadosPorEmpleador(String idEmpleador, List<String> idsEmpleados)
	{
		Query query = getEntityManager().createQuery(CONSULTA_AFILIADOS_POR_EMPLEADOR_Y_IDS_EMPLEADOS);
		query.setParameter("ID_EMPLEADOR", idEmpleador);
		query.setParameter("IDS_EMPLEADOS", idsEmpleados);
		return query.getResultList();
	}
}
