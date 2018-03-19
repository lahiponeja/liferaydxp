package co.com.porvenir.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import co.com.porvenir.dao.hibernate.CesantiaHibernateDao;
import co.com.porvenir.dao.hibernate.JPAInit;
import co.com.porvenir.dao.hibernate.TransaccionCensantiasHibernateDao;
import co.com.porvenir.dto.RetiroCesantias;
import co.com.porvenir.dto.SaldoCensantias;
import co.com.porvenir.entidad.Afiliado;
import co.com.porvenir.entidad.Cesantia;
import co.com.porvenir.entidad.TransaccionCensantias;
import co.com.porvenir.service.ServicioCesantias;
import co.com.porvenir.service.ServicioException;

public class ServicioImplCesantias implements ServicioCesantias
{

	private CesantiaHibernateDao cesantiaDao = new CesantiaHibernateDao();
	
	private TransaccionCensantiasHibernateDao transaccionCensantiasHibernateDao = new TransaccionCensantiasHibernateDao();

	@Override
	public List<SaldoCensantias> validacionRetiroCesantias(String idEmpleador, List<RetiroCesantias> listaRetiroCesantias)
	{
		EntityManager entityManager = JPAInit.createEntityManager();
		this.cesantiaDao.setEntityManager(entityManager);
		
		List<String> idsAfiliados = new ArrayList<String>();
		for (RetiroCesantias retiroCesantias : listaRetiroCesantias)
		{
			idsAfiliados.add(retiroCesantias.getIdAfiliado());
		}

		List<Cesantia> cesantias = this.cesantiaDao.cesantiasFiltroEmpleadorAfiliados(idEmpleador, idsAfiliados);
		if (cesantias.isEmpty())
		{
			return Collections.emptyList();
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

		return listaSaldoCensantias;
	}

	/**
	 * 
	 * @param afiliado
	 * @param listaRetiroCesantias
	 * @return
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

	@Override
	public List<SaldoCensantias> retirarCesantias(String idEmpleador, List<RetiroCesantias> listaRetiroCesantias) throws ServicioException
	{
		EntityManager entityManager = JPAInit.createEntityManager();
		this.cesantiaDao.setEntityManager(entityManager);
		this.transaccionCensantiasHibernateDao.setEntityManager(entityManager);
		
		for (RetiroCesantias retiroCesantias : listaRetiroCesantias)
		{
			if (retiroCesantias.getMonto() <= 0)
			{
				throw new ServicioException("El monto:" + retiroCesantias.getMonto() +" del retiro de cesantia para el afiliado con identificacion:" + retiroCesantias.getIdAfiliado() + " es invalido por ser menor a o igual a cero");
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
			return Collections.emptyList();
		}

		entityManager.getTransaction().begin();
		List<SaldoCensantias> listaSaldoCensantias = new ArrayList<SaldoCensantias>();
		for (Cesantia cesantia : cesantias)
		{
			SaldoCensantias saldoCensantias = new SaldoCensantias();
			saldoCensantias.setAfiliado(cesantia.getAfiliado());
			long monto = getMontoAfiliado(cesantia.getAfiliado(), listaRetiroCesantias);

			saldoCensantias.setMonto(monto);
			long nuevoSaldo = cesantia.getSaldo() - monto;
			saldoCensantias.setNuevoSaldo(nuevoSaldo);
			saldoCensantias.setEstado("Autorizado");
			
			listaSaldoCensantias.add(saldoCensantias);

			if (nuevoSaldo >= 0)
			{
				TransaccionCensantias transaccionCensantias = new TransaccionCensantias();
				transaccionCensantias.setAfiliado(cesantia.getAfiliado());
				transaccionCensantias.setCantidad(monto);
				transaccionCensantias.setEmpleador(cesantia.getAfiliado().getEmpleador());
				transaccionCensantias.setMensaje("Retiro de cesantias");
				transaccionCensantias.setSaldoAntiguo(cesantia.getSaldo());
				transaccionCensantias.setSaldoNuevo(nuevoSaldo);
				
				transaccionCensantias.setTipoTransaccion(1);
				transaccionCensantias.setTipoRetiro(1);
				
				cesantia.setSaldo(nuevoSaldo);// Guardar nuevo saldo de cesantia
				// Guardar nueva transaccion
				long idTransaccionCesantias = transaccionCensantiasHibernateDao.agregar(transaccionCensantias);
				saldoCensantias.setIdTransaccionCesantias(idTransaccionCesantias);
			}
			else
			{
				throw new ServicioException("El monto:" + monto +" del retiro de cesantia para el afiliado con identificacion:" + cesantia.getAfiliado().getId() + " es mayor al saldo actual");
			}
			
			entityManager.getTransaction().commit();
		}

		return listaSaldoCensantias;
	}
}
