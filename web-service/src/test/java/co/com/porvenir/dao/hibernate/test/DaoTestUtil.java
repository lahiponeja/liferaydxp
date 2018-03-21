/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 20/03/2018
 * @since 0.0.1 20/03/2018
 */
package co.com.porvenir.dao.hibernate.test;

import java.util.Random;
import java.util.UUID;

import javax.persistence.EntityManager;

import co.com.porvenir.entidad.Afiliado;
import co.com.porvenir.entidad.Cesantia;
import co.com.porvenir.entidad.Empleador;

/**
 * Clase con utilidades para hacer las pruebas de los DAOs
 * @author Alejandro Vivas
 * @since 0.0.1 20/03/2018
 * @version 0.0.1 20/03/2018
 */
public class DaoTestUtil
{
	/**
	 * Crea un empleador	
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param entityManager EntityManajer de JPA utilizado para crear el dato.
	 * @return Empleador creado
	 */
	public static Empleador crearEmpleador(EntityManager entityManager)
	{
		Empleador empleador = new Empleador();
		empleador.setId(UUID.randomUUID().toString());
		empleador.setNombre("Empresa:" + empleador.getId());
		entityManager.persist(empleador);
		return empleador;
	}
	
	/**
	 * Crea un afiliado
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param empleador Empleador del afiliado.
	 * @param entityManager EntityManajer de JPA utilizado para crear el dato. 
	 * @return Afiliado creado.
	 */
	public static Afiliado crearAfiliado(Empleador empleador,EntityManager entityManager)
	{
		Afiliado afiliado = new Afiliado();
		afiliado.setEmpleador(empleador);
		afiliado.setId(UUID.randomUUID().toString());
		afiliado.setNombre("Juan Carlos:" + afiliado.getId());
		entityManager.persist(afiliado);
		return afiliado;
	}
	
	/**
	 * Crear una cesantia para un afiliado.
	 * @author Alejandro Vivas
	 * @since 0.0.1 20/03/2018
	 * @version 0.0.1 20/03/2018
	 * @param afiliado Afiliado al que se le crea la cesantia
	 * @param entityManager EntityManajer de JPA utilizado para crear el dato. 
	 * @return Cesantia con el dato creado.
	 */
	public static Cesantia crearCesantia(Afiliado afiliado,EntityManager entityManager)
	{		
		Cesantia cesantia = new Cesantia();
		cesantia.setAfiliado(afiliado);
		cesantia.setSaldo(1_000_000*new Random().nextInt(10));
		entityManager.persist(cesantia);
		return cesantia;
	}
}
