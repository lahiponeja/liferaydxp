/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 20/03/2018
 * @since 0.0.1 20/03/2018
 */
package co.com.porvenir.service.impl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.porvenir.dao.hibernate.JPAInit;
import co.com.porvenir.dao.hibernate.test.DaoTestUtil;
import co.com.porvenir.dto.ResultadoRetiroCesantias;
import co.com.porvenir.dto.RetiroCesantias;
import co.com.porvenir.dto.SaldoCensantias;
import co.com.porvenir.entidad.Afiliado;
import co.com.porvenir.entidad.Cesantia;
import co.com.porvenir.entidad.Empleador;
import co.com.porvenir.service.ServicioException;
import co.com.porvenir.service.impl.ServicioImplCesantias;

/**
 * Clase con las pruebas de la clase  ServicioImplCesantias
 * @author Alejandro Vivas
 * @since 0.0.1 20/03/2018
 * @version 0.0.1 20/03/2018
 */
public class ServicioImplCesantiasTest
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
	 * Dado: Un Empleador y Afiliados
	 * Cuando: validacionRetiroCesantias
	 * Entonces: Regresa datos del Empleador y Afiliado con nuevo saldo
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @throws ServicioException Sucede si falla la operacion
	 */
	@Test
	public void dadoUnEmpleadorYAfiliadosCuandoValidacionRetiroCesantiasEntoncesRegresaDatosEmpleadorAfiliadoConNuevoSaldo() throws ServicioException
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);		
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		Cesantia cesantia1 = DaoTestUtil.crearCesantia(afiliado1, entityManager);
		Afiliado afiliado2 = DaoTestUtil.crearAfiliado(empleador, entityManager);		
		Cesantia cesantia2 = DaoTestUtil.crearCesantia(afiliado2, entityManager);
		transaction.commit();
		
		ServicioImplCesantias servicioImplCesantias = new ServicioImplCesantias();
		List<RetiroCesantias> listaRetiroCesantias = new ArrayList<RetiroCesantias>();		
		
		RetiroCesantias retiroCesantias1 = new RetiroCesantias();
		retiroCesantias1.setIdAfiliado(afiliado1.getId());
		int monto1 = 5312;
		long saldoEsperado1 = cesantia1.getSaldo() - monto1;
		retiroCesantias1.setMonto(monto1);
		listaRetiroCesantias.add(retiroCesantias1);
		
		RetiroCesantias retiroCesantias2 = new RetiroCesantias();
		retiroCesantias2.setIdAfiliado(afiliado2.getId());
		int monto2 = 65482;
		long saldoEsperado2 = cesantia2.getSaldo() - monto2;
		retiroCesantias2.setMonto(monto2);
		listaRetiroCesantias.add(retiroCesantias2);
	
		ResultadoRetiroCesantias resultadoRetiroCesantias = servicioImplCesantias.validacionRetiroCesantias(empleador.getId(), listaRetiroCesantias);

		Assert.assertEquals("El metodo validacionRetiroCesantias debe regresar el mismo id del empleador enviado", empleador.getId() , resultadoRetiroCesantias.getIdEmpleador());
		Assert.assertEquals("El metodo validacionRetiroCesantias debe regresar mismo nombre del empleador",empleador.getNombre(),resultadoRetiroCesantias.getNombreEmpleador());
		Assert.assertEquals("El metodo validacionRetiroCesantias debe regresar una lista SaldoCensantias con dimension 2",2,resultadoRetiroCesantias.getSaldoCensantias().size());
		
		SaldoCensantias saldoCensantiasAfiliado1 = null;
		for(SaldoCensantias saldoCensantias : resultadoRetiroCesantias.getSaldoCensantias())
		{
			 if(saldoCensantias.getAfiliado().getId().equals(afiliado1.getId()))
			 {
				 saldoCensantiasAfiliado1 = saldoCensantias;
			 }
		}
		Assert.assertNotNull("El metodo validacionRetiroCesantias no regreso un SaldoCensantias esperado", saldoCensantiasAfiliado1);
		Assert.assertEquals("El metodo validacionRetiroCesantias no regreso un SaldoCensantias con el afiliado esperado",afiliado1,saldoCensantiasAfiliado1.getAfiliado());
		Assert.assertEquals("El metodo validacionRetiroCesantias no regreso un SaldoCensantias no regreso el monto esperado",monto1,saldoCensantiasAfiliado1.getMonto());
		Assert.assertEquals("El metodo validacionRetiroCesantias no regreso un SaldoCensantias no regreso el nuevo saldo esperado",saldoEsperado1,saldoCensantiasAfiliado1.getNuevoSaldo());
		
		SaldoCensantias saldoCensantiasAfiliado2 = null;
		for(SaldoCensantias saldoCensantias : resultadoRetiroCesantias.getSaldoCensantias())
		{
			 if(saldoCensantias.getAfiliado().getId().equals(afiliado2.getId()))
			 {
				 saldoCensantiasAfiliado2 = saldoCensantias;
			 }
		}
		Assert.assertNotNull("El metodo validacionRetiroCesantias no regreseo un SaldoCensantias esperado", saldoCensantiasAfiliado2);
		Assert.assertEquals("El metodo validacionRetiroCesantias no regreso un SaldoCensantias con el afiliado esperado",afiliado2,saldoCensantiasAfiliado2.getAfiliado());
		Assert.assertEquals("El metodo validacionRetiroCesantias no regreso un SaldoCensantias no regreso el monto esperado",monto2,saldoCensantiasAfiliado2.getMonto());
		Assert.assertEquals("El metodo validacionRetiroCesantias no regreso un SaldoCensantias no regreso el nuevo saldo esperado",saldoEsperado2,saldoCensantiasAfiliado2.getNuevoSaldo());
	}
	
	/**
	 * Dado: Un Id Empleador invalido y afiliados validos
	 * Cuando: ValidacionRetiroCesantias
	 * Entonces: RegresaListaSaldoCesantiasVacia
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @throws ServicioException Sucede si falla la operacion
	 */
	@Test
	public void dadoUnIdEmpleadorInvalidoYAfiliadosValidosCuandoValidacionRetiroCesantiasEntoncesRegresaListaSaldoCesantiasVacia() throws ServicioException
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);		
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		DaoTestUtil.crearCesantia(afiliado1, entityManager);
		Afiliado afiliado2 = DaoTestUtil.crearAfiliado(empleador, entityManager);		
		DaoTestUtil.crearCesantia(afiliado2, entityManager);
		transaction.commit();
		
		ServicioImplCesantias servicioImplCesantias = new ServicioImplCesantias();
		List<RetiroCesantias> listaRetiroCesantias = new ArrayList<RetiroCesantias>();		
		
		RetiroCesantias retiroCesantias1 = new RetiroCesantias();
		retiroCesantias1.setIdAfiliado(afiliado1.getId());
		int monto1 = 5312;
		retiroCesantias1.setMonto(monto1);
		listaRetiroCesantias.add(retiroCesantias1);
		
		RetiroCesantias retiroCesantias2 = new RetiroCesantias();
		retiroCesantias2.setIdAfiliado(afiliado2.getId());
		int monto2 = 65482;
		retiroCesantias2.setMonto(monto2);
		listaRetiroCesantias.add(retiroCesantias2);
	
		ResultadoRetiroCesantias resultadoRetiroCesantias = servicioImplCesantias.validacionRetiroCesantias(UUID.randomUUID().toString(), listaRetiroCesantias);

		Assert.assertEquals("El metodo validacionRetiroCesantias debe regresar una lista vacia", 0 , resultadoRetiroCesantias.getSaldoCensantias().size());
	}
	
	/**
	 * Dado: Un id empleador valido y Afiliados invalidos
	 * Cuando: validacionRetiroCesantias
	 * Entonces: Regresa una lista SaldoCesantias Vacia
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @throws ServicioException Sucede si falla la operacion
	 */
	@Test
	public void dadoUnIdEmpleadorValidoYAfiliadosInvalidosCuandoValidacionRetiroCesantiasEntoncesRegresaListaSaldoCesantiasVacia() throws ServicioException
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);		
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		DaoTestUtil.crearCesantia(afiliado1, entityManager);
		Afiliado afiliado2 = DaoTestUtil.crearAfiliado(empleador, entityManager);		
		DaoTestUtil.crearCesantia(afiliado2, entityManager);
		transaction.commit();
		
		ServicioImplCesantias servicioImplCesantias = new ServicioImplCesantias();
		List<RetiroCesantias> listaRetiroCesantias = new ArrayList<RetiroCesantias>();		
		
		RetiroCesantias retiroCesantias1 = new RetiroCesantias();
		retiroCesantias1.setIdAfiliado(afiliado1.getId() + UUID.randomUUID().toString());
		int monto1 = 5312;
		retiroCesantias1.setMonto(monto1);
		listaRetiroCesantias.add(retiroCesantias1);
		
		RetiroCesantias retiroCesantias2 = new RetiroCesantias();
		retiroCesantias2.setIdAfiliado(afiliado2.getId() + UUID.randomUUID().toString());
		int monto2 = 65482;
		retiroCesantias2.setMonto(monto2);
		listaRetiroCesantias.add(retiroCesantias2);
	
		ResultadoRetiroCesantias resultadoRetiroCesantias = servicioImplCesantias.validacionRetiroCesantias(UUID.randomUUID().toString(), listaRetiroCesantias);

		Assert.assertEquals("El metodo validacionRetiroCesantias debe regresar una lista vacia", 0 , resultadoRetiroCesantias.getSaldoCensantias().size());
	}
	
	/**
	 * Dado: Un Id de Empleador y una lista de RetiroCesantias valida
	 * Cuando: RetirarCesantias
	 * Entonces: Regresa una lista de RetiroCesantias y cambia saldo correctamente
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @throws ServicioException Si falla la operacion
	 */
	@Test
	public void dadoIdEmpleadorListaRetiroCesantiasValidaCuandoRetirarCesantiasEntoncesRegresaRetiroCesantiasYCambiaSaldo() throws ServicioException
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);		
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		Cesantia cesantia1 = DaoTestUtil.crearCesantia(afiliado1, entityManager);
		Afiliado afiliado2 = DaoTestUtil.crearAfiliado(empleador, entityManager);		
		Cesantia cesantia2 = DaoTestUtil.crearCesantia(afiliado2, entityManager);
		transaction.commit();
		
		ServicioImplCesantias servicioImplCesantias = new ServicioImplCesantias();
		List<RetiroCesantias> listaRetiroCesantias = new ArrayList<RetiroCesantias>();		
		
		RetiroCesantias retiroCesantias1 = new RetiroCesantias();
		retiroCesantias1.setIdAfiliado(afiliado1.getId());
		int monto1 = 5312;
		long saldoEsperado1 = cesantia1.getSaldo() - monto1;
		retiroCesantias1.setMonto(monto1);
		listaRetiroCesantias.add(retiroCesantias1);
		
		RetiroCesantias retiroCesantias2 = new RetiroCesantias();
		retiroCesantias2.setIdAfiliado(afiliado2.getId());
		int monto2 = 65482;
		long saldoEsperado2 = cesantia2.getSaldo() - monto2;
		retiroCesantias2.setMonto(monto2);
		listaRetiroCesantias.add(retiroCesantias2);
		
		ResultadoRetiroCesantias resultadoRetiroCesantias = servicioImplCesantias.retirarCesantias(empleador.getId(), listaRetiroCesantias);
		
		Assert.assertEquals("El metodo retirarCesantias debe regresar el mismo id del empleador enviado", empleador.getId() , resultadoRetiroCesantias.getIdEmpleador());
		Assert.assertEquals("El metodo retirarCesantias debe regresar mismo nombre del empleador",empleador.getNombre(),resultadoRetiroCesantias.getNombreEmpleador());
		Assert.assertEquals("El metodo retirarCesantias debe regresar una lista SaldoCensantias con dimension 2",2,resultadoRetiroCesantias.getSaldoCensantias().size());
		
		SaldoCensantias saldoCensantiasAfiliado1 = null;
		for(SaldoCensantias saldoCensantias : resultadoRetiroCesantias.getSaldoCensantias())
		{
			 if(saldoCensantias.getAfiliado().getId().equals(afiliado1.getId()))
			 {
				 saldoCensantiasAfiliado1 = saldoCensantias;
			 }
		}
		Assert.assertNotNull("El metodo retirarCesantias no regreso un SaldoCensantias esperado", saldoCensantiasAfiliado1);
		Assert.assertEquals("El metodo retirarCesantias no regreso un SaldoCensantias con el afiliado esperado",afiliado1,saldoCensantiasAfiliado1.getAfiliado());
		Assert.assertEquals("El metodo retirarCesantias no regreso un SaldoCensantias no regreso el monto esperado",monto1,saldoCensantiasAfiliado1.getMonto());
		Assert.assertEquals("El metodo retirarCesantias no regreso un SaldoCensantias no regreso el nuevo saldo esperado",saldoEsperado1,saldoCensantiasAfiliado1.getNuevoSaldo());
		
		SaldoCensantias saldoCensantiasAfiliado2 = null;
		for(SaldoCensantias saldoCensantias : resultadoRetiroCesantias.getSaldoCensantias())
		{
			 if(saldoCensantias.getAfiliado().getId().equals(afiliado2.getId()))
			 {
				 saldoCensantiasAfiliado2 = saldoCensantias;
			 }
		}
		Assert.assertNotNull("El metodo retirarCesantias no regreseo un SaldoCensantias esperado", saldoCensantiasAfiliado2);
		Assert.assertEquals("El metodo retirarCesantias no regreso un SaldoCensantias con el afiliado esperado",afiliado2,saldoCensantiasAfiliado2.getAfiliado());
		Assert.assertEquals("El metodo retirarCesantias no regreso un SaldoCensantias no regreso el monto esperado",monto2,saldoCensantiasAfiliado2.getMonto());
		Assert.assertEquals("El metodo retirarCesantias no regreso un SaldoCensantias no regreso el nuevo saldo esperado",saldoEsperado2,saldoCensantiasAfiliado2.getNuevoSaldo());
		
		entityManager.clear();
		
		Cesantia casantia1DespuesRetiro = entityManager.find(Cesantia.class, cesantia1.getId());
		Assert.assertEquals("El metodo retirarCesantias no actualizo el saldo correctamente",saldoEsperado1,casantia1DespuesRetiro.getSaldo());
	}
	
	/**
	 * Dado: Id Empleador y una lista RetiroCesantias con monto negativo
	 * Cuando: RetirarCesantias
	 * Entonces: Lanza ServicioException
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @throws ServicioException Debe suceder siempre
	 */
	@Test(expected=ServicioException.class)
	public void dadoIdEmpleadorListaRetiroCesantiasConMontoNegativoCuandoRetirarCesantiasEntoncesLanzaServicioException() throws ServicioException
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);		
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		DaoTestUtil.crearCesantia(afiliado1, entityManager);
		transaction.commit();
		
		ServicioImplCesantias servicioImplCesantias = new ServicioImplCesantias();
		List<RetiroCesantias> listaRetiroCesantias = new ArrayList<RetiroCesantias>();		
		
		RetiroCesantias retiroCesantias1 = new RetiroCesantias();
		retiroCesantias1.setIdAfiliado(afiliado1.getId());
		retiroCesantias1.setMonto(-5312);
		listaRetiroCesantias.add(retiroCesantias1);
		
		servicioImplCesantias.retirarCesantias(empleador.getId(), listaRetiroCesantias);
	}
	
	/**
	 * Dado: Id Empleador y una lista RetiroCesantias con monto cero
	 * Cuando: RetirarCesantias
	 * Entonces: Lanza ServicioException
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @throws ServicioException Debe suceder siempre
	 */
	@Test(expected=ServicioException.class)
	public void dadoIdEmpleadorListaRetiroCesantiasConMontoCeroCuandoRetirarCesantiasEntoncesLanzaServicioException() throws ServicioException
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);		
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		DaoTestUtil.crearCesantia(afiliado1, entityManager);
		transaction.commit();
		
		ServicioImplCesantias servicioImplCesantias = new ServicioImplCesantias();
		List<RetiroCesantias> listaRetiroCesantias = new ArrayList<RetiroCesantias>();		
		
		RetiroCesantias retiroCesantias1 = new RetiroCesantias();
		retiroCesantias1.setIdAfiliado(afiliado1.getId());
		retiroCesantias1.setMonto(0);
		listaRetiroCesantias.add(retiroCesantias1);
		
		servicioImplCesantias.retirarCesantias(empleador.getId(), listaRetiroCesantias);
	}
	
	/**
	 * Prueba que:
	 * Dado: Un Id Empleador valido y una lista de RetiroCesantias con monto invalido
	 * Cuando: RetirarCesantias
	 * Entonces: LanzaServicioException
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 * @throws ServicioException
	 */
	@Test(expected=ServicioException.class)
	public void dadoIdEmpleadorValidoListaRetiroCesantiasConMontoInvalidoCuandoRetirarCesantiasEntoncesLanzaServicioException() throws ServicioException
	{
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Empleador empleador = DaoTestUtil.crearEmpleador(entityManager);		
		Afiliado afiliado1 = DaoTestUtil.crearAfiliado(empleador, entityManager);
		Cesantia cesantia1 = DaoTestUtil.crearCesantia(afiliado1, entityManager);
		transaction.commit();
		
		ServicioImplCesantias servicioImplCesantias = new ServicioImplCesantias();
		List<RetiroCesantias> listaRetiroCesantias = new ArrayList<RetiroCesantias>();		
		
		RetiroCesantias retiroCesantias1 = new RetiroCesantias();
		retiroCesantias1.setIdAfiliado(afiliado1.getId());
		long monto1 = cesantia1.getSaldo() + 1;
		retiroCesantias1.setMonto(monto1);
		listaRetiroCesantias.add(retiroCesantias1);
		
		servicioImplCesantias.retirarCesantias(empleador.getId(), listaRetiroCesantias);		
	}
}
