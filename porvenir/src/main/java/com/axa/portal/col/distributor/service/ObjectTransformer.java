package com.axa.portal.col.distributor.service;

import java.util.ArrayList;
import java.util.List;

import co.com.general.porvenir.dto.Afiliado;
import co.com.porvenir.ws.AfiliadoResponse;
import co.com.porvenir.ws.ConsultaAfiliadosResponse;

public class ObjectTransformer {
	
	
	public static List<Afiliado> convert(ConsultaAfiliadosResponse consulta, List<Afiliado> afiliadosExcel){
		List<Afiliado> afiliados = new ArrayList<Afiliado>(); 
		List<AfiliadoResponse> afiliadosResponse = consulta.getAfiliados();
		for (AfiliadoResponse afiliadoResponse : afiliadosResponse) {
			
			Afiliado afiliado = new Afiliado();
			afiliado.setIdAfiliado(afiliadoResponse.getId());
			afiliado.setMontoRetiro(Integer.valueOf(String.valueOf(afiliadoResponse.getCantidadRetiro())));
			afiliado.setSaldoCesantias(Integer.valueOf(String.valueOf(afiliadoResponse.getSaldoCesantias())));
			
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
