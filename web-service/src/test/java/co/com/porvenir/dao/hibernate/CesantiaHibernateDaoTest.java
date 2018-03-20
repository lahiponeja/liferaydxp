/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 20/03/2018
 * @since 0.0.1 20/03/2018
 */
package co.com.porvenir.dao.hibernate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.porvenir.dao.hibernate.test.DaoTestUtil;
import co.com.porvenir.entidad.Afiliado;
import co.com.porvenir.entidad.Cesantia;
import co.com.porvenir.entidad.Empleador;

/**
 * Clase con las pruebas para la entidad Cesantia
 * @author Alejandro Vivas
 * @since 0.0.1 20/03/2018
 * @version 0.0.1 20/03/2018
 */
public class CesantiaHibernateDaoTest
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
	 * Dado: Un Id de un Empleador y Ids de Afiliados Validos
	 * Cuando: Se llama a la funcion cesantiasFiltroEmpleadorAfiliados
	 * Entonces: La funcion regresa una cesantia para cada Afiliado
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 */
	@Test
	public void dadoIdEmpleadorIdsAfiliadosValidosCuandoCesantiasFiltroEmpleadorAfiliadosEntoncesRegresaCesantiasParaCadaAfiliado()
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);		
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		Cesantia cesantia1 = DaoTestUtil.crearCesantia(afiliado1, entityManager);
		Afiliado afiliado2 = DaoTestUtil.crearAfiliado(empleador, entityManager);		
		Cesantia cesantia2 = DaoTestUtil.crearCesantia(afiliado2, entityManager);
		Afiliado afiliado3 = DaoTestUtil.crearAfiliado(empleador, entityManager);	
		Cesantia cesantia3 = DaoTestUtil.crearCesantia(afiliado3, entityManager);		
		transaction.commit();
		
		CesantiaHibernateDao cesantiaHibernateDao = new CesantiaHibernateDao();
		cesantiaHibernateDao.setEntityManager(entityManager);
		List<Cesantia> cesantias = cesantiaHibernateDao.cesantiasFiltroEmpleadorAfiliados(empleador.getId(), Arrays.asList(afiliado1.getId(),afiliado2.getId(),afiliado3.getId()));
		Assert.assertTrue("cesantiasFiltroEmpleadorAfiliados debe regresar la cesantias de los afiliados", cesantias.contains(cesantia1) && cesantias.contains(cesantia2) && cesantias.contains(cesantia3));
	}
	
	/**
	 * Prueba que:
	 * Dado: Un Id de Empleador invalido e Ids Afiliados Validos
	 * Cuando: Se llama la funcion cesantiasFiltroEmpleadorAfiliados
	 * Entonces: Regresa una lista vacia
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 */
	@Test
	public void dadoIdEmpleadorInvalidoIdsAfiliadosValidosCuandoCesantiasFiltroEmpleadorAfiliadosEntoncesListaVacia()
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);		
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		DaoTestUtil.crearCesantia(afiliado1, entityManager);
		Afiliado afiliado2 = DaoTestUtil.crearAfiliado(empleador, entityManager);		
		DaoTestUtil.crearCesantia(afiliado2, entityManager);
		Afiliado afiliado3 = DaoTestUtil.crearAfiliado(empleador, entityManager);	
		DaoTestUtil.crearCesantia(afiliado3, entityManager);		
		transaction.commit();
		
		CesantiaHibernateDao cesantiaHibernateDao = new CesantiaHibernateDao();
		cesantiaHibernateDao.setEntityManager(entityManager);
		List<Cesantia> cesantias = cesantiaHibernateDao.cesantiasFiltroEmpleadorAfiliados(empleador.getId() + UUID.randomUUID().toString(), Arrays.asList(afiliado1.getId(),afiliado2.getId(),afiliado3.getId()));
		Assert.assertTrue("cesantiasFiltroEmpleadorAfiliados debe regresar una lista vacia", cesantias.isEmpty() );	
	}
	
	/**
	 * Dado: Un Id Empleador valido y Ids Afiliados invalidos
	 * Cuando: Cuando se llama la funcion cesantiasFiltroEmpleadorAfiliados
	 * Entonces: Regresa una lista vacia
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 */
	@Test
	public void dadoIdEmpleadorValidoIdsAfiliadosInvalidosCuandoCesantiasFiltroEmpleadorAfiliadosEntoncesListaVacia()
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		DaoTestUtil.crearCesantia(afiliado1, entityManager);
		Afiliado afiliado2 = DaoTestUtil.crearAfiliado(empleador, entityManager);		
		DaoTestUtil.crearCesantia(afiliado2, entityManager);
		Afiliado afiliado3 = DaoTestUtil.crearAfiliado(empleador, entityManager);	
		DaoTestUtil.crearCesantia(afiliado3, entityManager);		
		transaction.commit();
		
		CesantiaHibernateDao cesantiaHibernateDao = new CesantiaHibernateDao();
		cesantiaHibernateDao.setEntityManager(entityManager);
		List<Cesantia> cesantias = cesantiaHibernateDao.cesantiasFiltroEmpleadorAfiliados(empleador.getId(), Arrays.asList(afiliado1.getId() + UUID.randomUUID().toString(),afiliado2.getId() + UUID.randomUUID().toString(),afiliado3.getId() + UUID.randomUUID().toString()));
		Assert.assertTrue("cesantiasFiltroEmpleadorAfiliados debe regresar una lista vacia", cesantias.isEmpty() );	
	}
}
