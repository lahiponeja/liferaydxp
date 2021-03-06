/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 21/03/2018
 * @since 0.0.1 21/03/2018
 */
package co.com.porvenir.dao.hibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.com.porvenir.dao.hibernate.JPAInit;
import co.com.porvenir.entidad.Afiliado;
import co.com.porvenir.entidad.Cesantia;
import co.com.porvenir.entidad.Empleador;

/**
 * Clase con los datos para la carga de datos iniciales
 * @author Alejandro Vivas
 * @since 0.0.1 21/03/2018
 * @version 0.0.1 21/03/2018
 */
public class CargaDatosIniciales {
	
	/**
	 * Carga datos iniciales de la aplicacion.
	 * @author Alejandro Vivas
	 * @since 0.0.1 21/03/2018
	 * @version 0.0.1 21/03/2018
	 */
	public static void cargarDatosIniciales()
	{
		EntityManager entityManager = JPAInit.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Empleador empleador1 = new Empleador();
		empleador1.setId("1");
		empleador1.setNombre("Asociados SAS");
		entityManager.persist(empleador1);
		
		Afiliado afiliado1 = new Afiliado();
		afiliado1.setEmpleador(empleador1);
		afiliado1.setId("CC1111");
		afiliado1.setNombre("Juan Carlos Perez");
		entityManager.persist(afiliado1);
		
		Cesantia cesantia1 = new Cesantia();
		cesantia1.setAfiliado(afiliado1);
		cesantia1.setSaldo(1_000_000);
		entityManager.persist(cesantia1);
		
		Afiliado afiliado2 = new Afiliado();
		afiliado2.setEmpleador(empleador1);
		afiliado2.setId("CC2222");
		afiliado2.setNombre("Ricardo Rodriguez");
		entityManager.persist(afiliado2);
		Cesantia cesantia2 = new Cesantia();
		cesantia2.setAfiliado(afiliado2);
		cesantia2.setSaldo(2_000_000);
		entityManager.persist(cesantia2);
		
		Afiliado afiliado3 = new Afiliado();
		afiliado3.setEmpleador(empleador1);
		afiliado3.setId("CC3333");
		afiliado3.setNombre("Sofia Martinez");
		entityManager.persist(afiliado3);
		
		Cesantia cesantia3 = new Cesantia();
		cesantia3.setAfiliado(afiliado3);
		cesantia3.setSaldo(3_000_000);
		entityManager.persist(cesantia3);
		
		Afiliado afiliado4 = new Afiliado();
		afiliado4.setEmpleador(empleador1);
		afiliado4.setId("CC4444");
		afiliado4.setNombre("Pedro Rodriguez");
		entityManager.persist(afiliado4);
		
		Cesantia cesantia4 = new Cesantia();
		cesantia4.setAfiliado(afiliado4);
		cesantia4.setSaldo(4_000_000);
		entityManager.persist(cesantia4);
		
		Afiliado afiliado5 = new Afiliado();
		afiliado5.setEmpleador(empleador1);
		afiliado5.setId("CC5555");
		afiliado5.setNombre("Javier Rodriguez");
		entityManager.persist(afiliado5);
		
		Cesantia cesantia5 = new Cesantia();
		cesantia5.setAfiliado(afiliado5);
		cesantia5.setSaldo(4_000_000);
		entityManager.persist(cesantia5);
		
		Empleador empleador2 = new Empleador();
		empleador2.setId("2");
		empleador2.setNombre("Sociedad San Diego LTDA");
		entityManager.persist(empleador2);
		
		Afiliado afiliado6 = new Afiliado();
		afiliado6.setEmpleador(empleador2);
		afiliado6.setId("CC6");
		afiliado6.setNombre("Miguel Hernandez");
		entityManager.persist(afiliado6);
		
		Cesantia cesantia6 = new Cesantia();
		cesantia6.setAfiliado(afiliado6);
		cesantia6.setSaldo(4_000_000);
		entityManager.persist(cesantia6);
		
		Afiliado afiliado7 = new Afiliado();
		afiliado7.setEmpleador(empleador2);
		afiliado7.setId("CC7");
		afiliado7.setNombre("Carolina Gutierrez");
		entityManager.persist(afiliado7);
		Cesantia cesantia7 = new Cesantia();
		cesantia7.setAfiliado(afiliado7);
		cesantia7.setSaldo(5_000_000);
		entityManager.persist(cesantia7);
		
		Afiliado afiliado8 = new Afiliado();
		afiliado8.setEmpleador(empleador2);
		afiliado8.setId("CC8");
		afiliado8.setNombre("Sofia Martinez");
		entityManager.persist(afiliado8);
		Cesantia cesantia8 = new Cesantia();
		cesantia8.setAfiliado(afiliado8);
		cesantia8.setSaldo(6_000_000);
		entityManager.persist(cesantia8);
		
		transaction.commit();
	}
}
