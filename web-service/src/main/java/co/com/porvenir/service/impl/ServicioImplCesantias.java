/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE 
 * VASS Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Alejandro Vivas
 * @version 0.0.1 20/03/2018
 * @since 0.0.1 20/03/2018
 */
package co.com.porvenir.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import co.com.porvenir.dao.hibernate.CesantiaHibernateDao;
import co.com.porvenir.dao.hibernate.JPAInit;
import co.com.porvenir.dao.hibernate.TransaccionCensantiasHibernateDao;
import co.com.porvenir.dto.ResultadoRetiroCesantias;
import co.com.porvenir.dto.RetiroCesantias;
import co.com.porvenir.dto.SaldoCensantias;
import co.com.porvenir.entidad.Afiliado;
import co.com.porvenir.entidad.Cesantia;
import co.com.porvenir.entidad.TransaccionCensantias;
import co.com.porvenir.service.ServicioCesantias;
import co.com.porvenir.service.ServicioException;

/**
 * Clase con la logica de cesantias
 * @author Alejandro Vivas
 * @since 0.0.1 20/03/2018
 * @version 0.0.1 20/03/2018
 */
public class ServicioImplCesantias implements ServicioCesantias
{
	/** Dao para la entida Cesantia */
	private CesantiaHibernateDao cesantiaDao = new CesantiaHibernateDao();
	/** Dao para la entidad TransaccionCensantias */
	private TransaccionCensantiasHibernateDao transaccionCensantiasHibernateDao = new TransaccionCensantiasHibernateDao();

	@Override
	public ResultadoRetiroCesantias validacionRetiroCesantias(String idEmpleador, List<RetiroCesantias> listaRetiroCesantias) throws ServicioException
	{
		EntityManager entityManager = JPAInit.createEntityManager();
		this.cesantiaDao.setEntityManager(entityManager);
		try
		{
			List<String> idsAfiliados = new ArrayList<String>();
			for (RetiroCesantias retiroCesantias : listaRetiroCesantias)
			{
				idsAfiliados.add(retiroCesantias.getIdAfiliado());
			}

			List<Cesantia> cesantias = this.cesantiaDao.cesantiasFiltroEmpleadorAfiliados(idEmpleador, idsAfiliados);
			if (cesantias.isEmpty())
			{
				ResultadoRetiroCesantias resultadoRetiroCesantias = new ResultadoRetiroCesantias();
				resultadoRetiroCesantias.setIdEmpleador(idEmpleador);
				resultadoRetiroCesantias.setSaldoCensantias(new ArrayList<SaldoCensantias>());				
				return resultadoRetiroCesantias;
			}

			List<SaldoCensantias> listaSaldoCensantias = new ArrayList<SaldoCensantias>();
			for (Cesantia cesantia : cesantias)
			{
				SaldoCensantias saldoCensantias = new SaldoCensantias();
				saldoCensantias.setAfiliado(cesantia.getAfiliado());
				long monto = getMontoAfiliado(cesantia.getAfiliado(), listaRetiroCesantias);
				saldoCensantias.setMonto(monto);
				long nuevoSaldo = cesantia.getSaldo() - monto;
				saldoCensantias.setNuevoSaldo(nuevoSaldo);
				listaSaldoCensantias.add(saldoCensantias);
			}
			
			ResultadoRetiroCesantias resultadoRetiroCesantias = new ResultadoRetiroCesantias();
			resultadoRetiroCesantias.setSaldoCensantias(listaSaldoCensantias);
			resultadoRetiroCesantias.setIdEmpleador(idEmpleador);
			resultadoRetiroCesantias.setNombreEmpleador(listaSaldoCensantias.get(0).getAfiliado().getEmpleador().getNombre());

			return resultadoRetiroCesantias;
		}
		catch (Exception e)
		{
			throw new ServicioException("Error al validar cesantias", e);
		}
		finally
		{
			entityManager.close();
		}
	}

	@Override
	public ResultadoRetiroCesantias retirarCesantias(String idEmpleador, List<RetiroCesantias> listaRetiroCesantias) throws ServicioException
	{
		EntityManager entityManager = JPAInit.createEntityManager();
		EntityTransaction entityTransaction = null;
		try
		{			
			this.cesantiaDao.setEntityManager(entityManager);
			this.transaccionCensantiasHibernateDao.setEntityManager(entityManager);
			
			for (RetiroCesantias retiroCesantias : listaRetiroCesantias)
			{
				if (retiroCesantias.getMonto() <= 0)
				{
					throw new ServicioException("El monto:" + retiroCesantias.getMonto() + " del retiro de cesantia para el afiliado con identificacion:" + retiroCesantias.getIdAfiliado()
					        + " es invalido por ser menor a o igual a cero");
				}
			}

			List<String> idsAfiliados = new ArrayList<String>();
			for (RetiroCesantias retiroCesantias : listaRetiroCesantias)
			{
				idsAfiliados.add(retiroCesantias.getIdAfiliado());
			}

			List<Cesantia> cesantias = this.cesantiaDao.cesantiasFiltroEmpleadorAfiliados(idEmpleador, idsAfiliados);
			if (cesantias.isEmpty())
			{
				ResultadoRetiroCesantias resultadoRetiroCesantias = new ResultadoRetiroCesantias();
				resultadoRetiroCesantias.setIdEmpleador(idEmpleador);
				resultadoRetiroCesantias.setSaldoCensantias(new ArrayList<SaldoCensantias>());				
				return resultadoRetiroCesantias;
			}

			// Inicia la tansaccion para definir el nuevo saldo para todos los retiros
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			List<SaldoCensantias> listaSaldoCensantias = new ArrayList<SaldoCensantias>();
			for (Cesantia cesantia : cesantias)
			{
				long monto = getMontoAfiliado(cesantia.getAfiliado(), listaRetiroCesantias);
				long nuevoSaldo = cesantia.getSaldo() - monto;
				if (nuevoSaldo >= 0)
				{
					SaldoCensantias saldoCensantias = new SaldoCensantias();
					saldoCensantias.setAfiliado(cesantia.getAfiliado());
					saldoCensantias.setMonto(monto);
					saldoCensantias.setNuevoSaldo(nuevoSaldo);
					saldoCensantias.setEstado("Autorizado");
					listaSaldoCensantias.add(saldoCensantias);
					
					TransaccionCensantias transaccionCensantias = new TransaccionCensantias();
					transaccionCensantias.setAfiliado(cesantia.getAfiliado());
					transaccionCensantias.setCantidad(monto);
					transaccionCensantias.setEmpleador(cesantia.getAfiliado().getEmpleador());
					transaccionCensantias.setMensaje("Retiro de cesantias");
					transaccionCensantias.setSaldoAntiguo(cesantia.getSaldo());
					transaccionCensantias.setSaldoNuevo(nuevoSaldo);

					transaccionCensantias.setTipoTransaccion(1);
					transaccionCensantias.setTipoRetiro(1);

					cesantia.setSaldo(nuevoSaldo);// Define el nuevo saldo de cesantia (JPA Guarda el dato en este momento)
					long idTransaccionCesantias = transaccionCensantiasHibernateDao.agregar(transaccionCensantias); // Guardar nueva transaccion
					saldoCensantias.setIdTransaccionCesantias(idTransaccionCesantias);
				}
				else
				{	
					entityTransaction.rollback();
					throw new ServicioException("El monto:" + monto + " del retiro de cesantia para el afiliado con identificacion:" + cesantia.getAfiliado().getId() + " es mayor al saldo actual");
				}
			}
			// Nota: Solo hace commit si todos los retiros son validos
			entityTransaction.commit();
			
			ResultadoRetiroCesantias resultadoRetiroCesantias = new ResultadoRetiroCesantias();
			resultadoRetiroCesantias.setSaldoCensantias(listaSaldoCensantias);
			resultadoRetiroCesantias.setIdEmpleador(idEmpleador);
			resultadoRetiroCesantias.setNombreEmpleador(listaSaldoCensantias.get(0).getAfiliado().getEmpleador().getNombre());
			return resultadoRetiroCesantias;
		}
		catch (Exception e)
		{
			if(entityTransaction != null)
			{
				entityTransaction.rollback();
			}
			throw new ServicioException("Error al retirar las cesantias", e);
		}
		finally
		{
			entityManager.close();
		}
	}

	/**
	 * Regresa el monto para un afiliado
	 * @param afiliado Afiliado al que se le busca el monto
	 * @param listaRetiroCesantias Lista con los retiros de las cesantias
	 * @return Monto del afiliado
	 */
	private long getMontoAfiliado(Afiliado afiliado, List<RetiroCesantias> listaRetiroCesantias)
	{
		for (RetiroCesantias retiroCesantias : listaRetiroCesantias)
		{
			if (retiroCesantias.getIdAfiliado().equals(afiliado.getId()))
			{
				return retiroCesantias.getMonto();
			}
		}
		return -1L;
	}
}
