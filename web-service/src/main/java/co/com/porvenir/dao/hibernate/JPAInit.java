/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 21/03/2018
 * @since 0.0.1 21/03/2018
 */
package co.com.porvenir.dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utilidad de JPA
 * @author Alejandro Vivas
 * @since 0.0.1 21/03/2018
 * @version 0.0.1 21/03/2018
 */
public class JPAInit
{
	/** Entity manager factory de la aplicacion */
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "CRM" );
	
	/**
	 * Regresa un nuevo entity manager
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @return Entity manager creado
	 */
	public static final EntityManager createEntityManager()
	{
		return entityManagerFactory.createEntityManager();
	}
}
