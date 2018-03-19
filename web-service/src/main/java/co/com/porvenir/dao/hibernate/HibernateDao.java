/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 14/03/2018
 * @since 0.0.1 14/03/2018
 */
package co.com.porvenir.dao.hibernate;

import javax.persistence.EntityManager;

/**
 * Dao generico
 * @author Alejandro Vivas
 * @since 0.0.1 14/03/2018
 * @version 0.0.1 14/03/2018
 */
public abstract class HibernateDao
{
	/** entity manager usado */
	private EntityManager entityManager;

	/**
	 * Get the entityManager
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 * @return the entityManager
	 */
	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	/**
	 * Set the entityManager
	 * @author Alejandro Vivas
	 * @since 0.0.1 14/03/2018
	 * @version 0.0.1 14/03/2018
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	 
}
