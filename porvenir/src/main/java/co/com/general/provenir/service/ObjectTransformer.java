package co.com.general.provenir.service;

import java.util.ArrayList;
import java.util.List;

import co.com.general.porvenir.dto.Afiliado;
import co.com.porvenir.ws.AfiliadoResponse;
import co.com.porvenir.ws.ConsultaAfiliadosResponse;

/**
 * @author USER
 * Facade Pattern
 */
public class ObjectTransformer {
	
	/**
	 * @param consulta
	 * @param afiliadosExcel
	 * @return
	 */
	public static List<Afiliado> convert(ConsultaAfiliadosResponse consulta, List<Afiliado> afiliadosExcel){
		List<Afiliado> afiliados = new ArrayList<Afiliado>(); 
		List<AfiliadoResponse> afiliadosResponse = consulta.getAfiliados();
		for (AfiliadoResponse afiliadoResponse : afiliadosResponse) {
			
			Afiliado afiliado = new Afiliado();
			afiliado.setIdAfiliado(afiliadoResponse.getId());
			afiliado.setMontoRetiro((double)afiliadoResponse.getCantidadRetiro());
			afiliado.setSaldoCesantias((double)afiliadoResponse.getSaldoCesantias());
			
			for (Afiliado afiliadoE : afiliadosExcel) {
				if (afiliado.getIdAfiliado().equals(afiliadoE.getIdAfiliado())){
					afiliado.setNombreAfiliado(afiliadoE.getNombreAfiliado());
					afiliado.setIdEmpleador(afiliadoE.getIdEmpleador());
					continue;
				}
			} 
			afiliados.add(afiliado);
		}
		
		return afiliados;
	}

}
