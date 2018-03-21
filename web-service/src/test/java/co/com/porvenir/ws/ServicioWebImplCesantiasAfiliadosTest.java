/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 21/03/2018
 * @since 0.0.1 21/03/2018
 */
package co.com.porvenir.ws;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.porvenir.dao.hibernate.JPAInit;
import co.com.porvenir.dao.hibernate.test.DaoTestUtil;
import co.com.porvenir.entidad.Afiliado;
import co.com.porvenir.entidad.Cesantia;
import co.com.porvenir.entidad.Empleador;
import co.com.porvenir.ws.dto.AfiliadoRequest;
import co.com.porvenir.ws.dto.ConsultaAfiliadosResponse;
import co.com.porvenir.ws.dto.EmpleadorRequest;
import co.com.porvenir.ws.dto.RetiroResponse;

/**
 * Clase con las pruebas para la clase ServicioWebImplCesantiasAfiliados
 * @author Alejandro Vivas
 * @since 0.0.1 21/03/2018
 * @version 0.0.1 21/03/2018
 */
public class ServicioWebImplCesantiasAfiliadosTest
{
	/** Objeto a probar */
	private ServicioWebImplCesantiasAfiliados servicioWebCesantiasAfiliados = new ServicioWebImplCesantiasAfiliados();
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
	 * Dado: Un EmpleadorRequest con arreglo de afiliados nulo
	 * Cuando: ConsultarAfiliados
	 * Entonces: Regresa estado ERROR
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 */
	@Test
	public void dadoEmpleadorRequestConArregloAfiliadosNuloCuandoConsultarAfiliadosEntoncesRegresaEstadoError()
	{
		EmpleadorRequest empleadorRequest = new EmpleadorRequest();
		ConsultaAfiliadosResponse consultaAfiliadosResponse = this.servicioWebCesantiasAfiliados.consultarAfiliados(empleadorRequest);
		Assert.assertEquals("El metodo consultarAfiliados debe regresa ERROR en el estado","ERROR", consultaAfiliadosResponse.getEstado());
	}
	
	/**
	 * Prueba que:
	 * Dado: Un EmpleadorRequest con arreglo de afiliados de dimension cero
	 * Cuando: ConsultarAfiliados
	 * Entonces: Regresa estado ERROR
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 */
	@Test
	public void dadoEmpleadorRequestConArregloAfiliadosDimensionCeroCuandoConsultarAfiliadosEntoncesRegresaEstadoError()
	{
		EmpleadorRequest empleadorRequest = new EmpleadorRequest();
		empleadorRequest.setAfiliados(new AfiliadoRequest[0]);
		ConsultaAfiliadosResponse consultaAfiliadosResponse = this.servicioWebCesantiasAfiliados.consultarAfiliados(empleadorRequest);
		Assert.assertEquals("El metodo consultarAfiliados debe regresa ERROR en el estado","ERROR", consultaAfiliadosResponse.getEstado());
	}
	
	/**
	 * Dado: EmpleadorRequest con Id Empleador Invalido
	 * Cuando: ConsultarAfiliados
	 * Entonces: Regresa estado ERROR
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 */
	@Test
	public void dadoEmpleadorRequestConIdEmpleadorInvalidoCuandoConsultarAfiliadosEntoncesRegresaEstadoError()
	{
		EmpleadorRequest empleadorRequest = new EmpleadorRequest();
		empleadorRequest.setId(UUID.randomUUID().toString());
		AfiliadoRequest afiliadoRequest = new AfiliadoRequest();
		afiliadoRequest.setId(UUID.randomUUID().toString());
		empleadorRequest.setAfiliados(new AfiliadoRequest[]{afiliadoRequest});
		
		ConsultaAfiliadosResponse consultaAfiliadosResponse = this.servicioWebCesantiasAfiliados.consultarAfiliados(empleadorRequest);
		Assert.assertEquals("El metodo consultarAfiliados debe regresa ERROR en el estado","ERROR", consultaAfiliadosResponse.getEstado());
	}
	
	/**
	 * Dado: EmpleadorRequest con Id afiliado invalido
	 * Cuando: ConsultarAfiliados
	 * Entonces: Regresa estado ERROR
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 */
	@Test
	public void dadoEmpleadorRequestConIdAfiliadoInvalidoCuandoConsultarAfiliadosEntoncesRegresaEstadoError()
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);		
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		DaoTestUtil.crearCesantia(afiliado1, entityManager);
		Afiliado afiliado2 = DaoTestUtil.crearAfiliado(empleador, entityManager);		
		DaoTestUtil.crearCesantia(afiliado2, entityManager);
		transaction.commit();
		
		EmpleadorRequest empleadorRequest = new EmpleadorRequest();
		empleadorRequest.setId(empleador.getId());
		AfiliadoRequest afiliadoRequest = new AfiliadoRequest();
		afiliadoRequest.setId(UUID.randomUUID().toString());
		empleadorRequest.setAfiliados(new AfiliadoRequest[]{afiliadoRequest});
		
		ConsultaAfiliadosResponse consultaAfiliadosResponse = this.servicioWebCesantiasAfiliados.consultarAfiliados(empleadorRequest);
		Assert.assertEquals("El metodo consultarAfiliados debe regresa ERROR en el estado","ERROR", consultaAfiliadosResponse.getEstado());
	}
	
	/**
	 * Dado: EmpleadorRequest valido
	 * Cuando: consultarAfiliados
	 * Entonces: Regresa Estado EXITO
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 */
	@Test
	public void dadoEmpleadorRequestValidoCuandoConsultarAfiliadosEntoncesRegresaEstadoExito()
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);		
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		DaoTestUtil.crearCesantia(afiliado1, entityManager);
		Afiliado afiliado2 = DaoTestUtil.crearAfiliado(empleador, entityManager);		
		DaoTestUtil.crearCesantia(afiliado2, entityManager);
		transaction.commit();
		
		EmpleadorRequest empleadorRequest = new EmpleadorRequest();
		empleadorRequest.setId(empleador.getId());
		AfiliadoRequest afiliadoRequest = new AfiliadoRequest();
		afiliadoRequest.setId(afiliado1.getId());
		empleadorRequest.setAfiliados(new AfiliadoRequest[]{afiliadoRequest});
		
		ConsultaAfiliadosResponse consultaAfiliadosResponse = this.servicioWebCesantiasAfiliados.consultarAfiliados(empleadorRequest);
		Assert.assertEquals("El metodo consultarAfiliados debe regresa EXITO en el estado","EXITO", consultaAfiliadosResponse.getEstado());
	}
	
	/**
	 * Prueba que:
	 * Dado: Un EmpleadorRequest con arreglo de afiliados nulo
	 * Cuando: grabarRetiroCesantiasAfiliados
	 * Entonces: Regresa estado ERROR
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 */
	@Test
	public void dadoEmpleadorRequestConArregloAfiliadosNuloCuandoGrabarRetiroCesantiasAfiliadosEntoncesRegresaEstadoError()
	{
		EmpleadorRequest empleadorRequest = new EmpleadorRequest();
		RetiroResponse consultaAfiliadosResponse = this.servicioWebCesantiasAfiliados.grabarRetiroCesantiasAfiliados(empleadorRequest);
		Assert.assertEquals("El metodo grabarRetiroCesantiasAfiliados debe regresa ERROR en el estado","ERROR", consultaAfiliadosResponse.getEstado());
	}
	
	/**
	 * Prueba que:
	 * Dado: Un EmpleadorRequest con arreglo de afiliados de dimension cero
	 * Cuando: grabarRetiroCesantiasAfiliados
	 * Entonces: Regresa estado ERROR
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 */
	@Test
	public void dadoEmpleadorRequestConArregloAfiliadosDimensionCeroCuandoGrabarRetiroCesantiasAfiliadosEntoncesRegresaEstadoError()
	{
		EmpleadorRequest empleadorRequest = new EmpleadorRequest();
		empleadorRequest.setAfiliados(new AfiliadoRequest[0]);
		RetiroResponse consultaAfiliadosResponse = this.servicioWebCesantiasAfiliados.grabarRetiroCesantiasAfiliados(empleadorRequest);
		Assert.assertEquals("El metodo grabarRetiroCesantiasAfiliados debe regresa ERROR en el estado","ERROR", consultaAfiliadosResponse.getEstado());
	}
	
	/**
	 * Dado: EmpleadorRequest con Id Empleador Invalido
	 * Cuando: grabarRetiroCesantiasAfiliados
	 * Entonces: Regresa estado ERROR
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 */
	@Test
	public void dadoEmpleadorRequestConIdEmpleadorInvalidoCuandoGrabarRetiroCesantiasAfiliadosEntoncesRegresaEstadoError()
	{
		EmpleadorRequest empleadorRequest = new EmpleadorRequest();
		empleadorRequest.setId(UUID.randomUUID().toString());
		AfiliadoRequest afiliadoRequest = new AfiliadoRequest();
		afiliadoRequest.setId(UUID.randomUUID().toString());
		afiliadoRequest.setCantidadRetiro(1);
		empleadorRequest.setAfiliados(new AfiliadoRequest[]{afiliadoRequest});
		
		RetiroResponse consultaAfiliadosResponse = this.servicioWebCesantiasAfiliados.grabarRetiroCesantiasAfiliados(empleadorRequest);
		Assert.assertEquals("El metodo grabarRetiroCesantiasAfiliados debe regresa ERROR en el estado","ERROR", consultaAfiliadosResponse.getEstado());
	}
	
	/**
	 * Dado: EmpleadorRequest con Id afiliado invalido
	 * Cuando: grabarRetiroCesantiasAfiliados
	 * Entonces: Regresa estado ERROR
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 */
	@Test
	public void dadoEmpleadorRequestConIdAfiliadoInvalidoCuandoGrabarRetiroCesantiasAfiliadosEntoncesRegresaEstadoError()
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);		
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		DaoTestUtil.crearCesantia(afiliado1, entityManager);
		Afiliado afiliado2 = DaoTestUtil.crearAfiliado(empleador, entityManager);		
		DaoTestUtil.crearCesantia(afiliado2, entityManager);
		transaction.commit();
		
		EmpleadorRequest empleadorRequest = new EmpleadorRequest();
		empleadorRequest.setId(empleador.getId());
		AfiliadoRequest afiliadoRequest = new AfiliadoRequest();
		afiliadoRequest.setId(UUID.randomUUID().toString());
		afiliadoRequest.setCantidadRetiro(1);
		empleadorRequest.setAfiliados(new AfiliadoRequest[]{afiliadoRequest});
		
		RetiroResponse consultaAfiliadosResponse = this.servicioWebCesantiasAfiliados.grabarRetiroCesantiasAfiliados(empleadorRequest);
		Assert.assertEquals("El metodo grabarRetiroCesantiasAfiliados debe regresa ERROR en el estado","ERROR", consultaAfiliadosResponse.getEstado());
	}
	
	/**
	 * Dado: EmpleadorRequest valido
	 * Cuando: grabarRetiroCesantiasAfiliados
	 * Entonces: Regresa Estado EXITO
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 */
	@Test
	public void dadoEmpleadorRequestValidoCuandoGrabarRetiroCesantiasAfiliadosEntoncesRegresaEstadoExito()
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);		
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		Cesantia cesantia1 = DaoTestUtil.crearCesantia(afiliado1, entityManager);
		Afiliado afiliado2 = DaoTestUtil.crearAfiliado(empleador, entityManager);		
		DaoTestUtil.crearCesantia(afiliado2, entityManager);
		transaction.commit();
		
		EmpleadorRequest empleadorRequest = new EmpleadorRequest();
		empleadorRequest.setId(empleador.getId());
		AfiliadoRequest afiliadoRequest = new AfiliadoRequest();
		afiliadoRequest.setId(afiliado1.getId());
		afiliadoRequest.setCantidadRetiro(cesantia1.getSaldo());
		empleadorRequest.setAfiliados(new AfiliadoRequest[]{afiliadoRequest});
		
		RetiroResponse consultaAfiliadosResponse = this.servicioWebCesantiasAfiliados.grabarRetiroCesantiasAfiliados(empleadorRequest);
		Assert.assertEquals("El metodo grabarRetiroCesantiasAfiliados debe regresa EXITO en el estado","EXITO", consultaAfiliadosResponse.getEstado());
	}	
}
