package co.com.porvenir.service;

import java.util.List;

import co.com.porvenir.dto.ResultadoRetiroCesantias;
import co.com.porvenir.dto.RetiroCesantias;

public interface ServicioCesantias
{

	public ResultadoRetiroCesantias validacionRetiroCesantias(String idEmpleador, List<RetiroCesantias> retiroCesantias) throws ServicioException;

	public ResultadoRetiroCesantias retirarCesantias(String idEmpleador, List<RetiroCesantias> retiroCesantias) throws ServicioException;
}
