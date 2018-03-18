package co.com.porvenir.service;

import java.util.List;

import co.com.porvenir.dto.RetiroCesantias;
import co.com.porvenir.dto.SaldoCensantias;

public interface ServicioCesantias
{

	public List<SaldoCensantias> validacionRetiroCesantias(String idEmpleador, List<RetiroCesantias> retiroCesantias) throws ServicioException;

	public List<SaldoCensantias> retirarCesantias(String idEmpleador, List<RetiroCesantias> retiroCesantias) throws ServicioException;
}
