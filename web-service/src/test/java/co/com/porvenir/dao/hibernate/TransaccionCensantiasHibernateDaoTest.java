/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 20/03/2018
 * @since 0.0.1 20/03/2018
 */
package co.com.porvenir.dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.porvenir.dao.hibernate.test.DaoTestUtil;
import co.com.porvenir.entidad.Afiliado;
import co.com.porvenir.entidad.Empleador;
import co.com.porvenir.entidad.TransaccionCensantias;

/**
 * Clase con las pruebas de la clase TransaccionCensantiasHibernateDao
 * @author Alejandro Vivas
 * @since 0.0.1 20/03/2018
 * @version 0.0.1 20/03/2018
 */
public class TransaccionCensantiasHibernateDaoTest
{
	/** Entity manager usado por la prueba */
	private EntityManager entityManager;
	
	/**
	 * Crear el entity manager
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 */
	@Before
	public void init()
	{
		entityManager = JPAInit.createEntityManager();
	}
	
	/**
	 * Cierra el entity manager
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 */
	@After
	public void stop()
	{
		entityManager.close();
	}
	
	/**
	 * Prueba que:
	 * Dado: Una TransaccionCensantias
	 * Cuando: Agregar
	 * Entonces: La funcion regresa un id mayor a Cero
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 */
	@Test
	public void dadoTransaccionCensantiasCuandoAgregarEntoncesRegresaIdMayorACero()
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		TransaccionCensantias transaccionCensantias = new TransaccionCensantias();		
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);
		Afiliado afiliado = DaoTestUtil.crearAfiliado(empleador, entityManager);
		transaccionCensantias.setAfiliado(afiliado);
		transaccionCensantias.setCantidad(1_000_000);
		transaccionCensantias.setEmpleador(empleador);
		transaccionCensantias.setMensaje("Retiro");
		transaccionCensantias.setSaldoAntiguo(2_000_000);
		transaccionCensantias.setSaldoNuevo(3_000_000);
		transaccionCensantias.setTipoRetiro(1);
		transaccionCensantias.setTipoTransaccion(1);

		TransaccionCensantiasHibernateDao transaccionCensantiasHibernateDao = new TransaccionCensantiasHibernateDao();
		transaccionCensantiasHibernateDao.setEntityManager(entityManager);
			
		long id = transaccionCensantiasHibernateDao.agregar(transaccionCensantias);
		
		transaction.commit();		
		
		TransaccionCensantias transaccionCensantiasEncontrada = entityManager.find(TransaccionCensantias.class, id);
		
		Assert.assertTrue("agregar debe regresar un id mayor a cero", id >= 0);
		Assert.assertEquals("El objeto en el sistema y el que se agrega deben ser iguales", transaccionCensantias,transaccionCensantiasEncontrada);		
	}
}
