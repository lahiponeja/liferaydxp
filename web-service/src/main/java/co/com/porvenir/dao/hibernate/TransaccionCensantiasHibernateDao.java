/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 14/03/2018
 * @since 0.0.1 14/03/2018
 */
package co.com.porvenir.dao.hibernate;

import co.com.porvenir.dao.TransaccionCensantiasDao;
import co.com.porvenir.entidad.TransaccionCensantias;

/**
 * Dao para la entidad TransaccionCensantias
 * @author Alejandro Vivas
 * @since 0.0.1 14/03/2018
 * @version 0.0.1 14/03/2018
 */
public class TransaccionCensantiasHibernateDao extends HibernateDao implements TransaccionCensantiasDao
{
	/** (non-Javadoc)
	 * @see co.com.porvenir.dao.TransaccionCensantiasDao#agregar(co.com.porvenir.entidad.TransaccionCensantias)
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 */
	@Override
	public long agregar(TransaccionCensantias transaccionCensantias)
	{
		getEntityManager().persist(transaccionCensantias);
		return transaccionCensantias.getId();
	}
}
