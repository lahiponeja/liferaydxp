package co.com.porvenir.dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAInit
{
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "CRM" );
	
	public static final EntityManager createEntityManager()
	{
		return entityManagerFactory.createEntityManager();
	}
}
