<%@ include file="/init.jsp" %>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="init.jsp"%>   
<%@ page import="java.util.List"%>
<%@ page import="co.com.general.porvenir.dto.Afiliado"%>

<portlet:actionURL name="stepFour" var="stepFourURL"></portlet:actionURL>
<%

	/* List<Afiliado> afiliados = (List<Afiliado>)renderRequest.getAttribute("afiliados"); 
	//List<Afiliado> afiliados =  new ArrayList();
	System.out.println(afiliados.size());
	if (afiliados != null && !afiliados.isEmpty()) */
%>    
							<div class="row">
								<div class="col-md-12">
									<aui:form id="stepTwo" name="stepTwo" action="${stepThreeURL}" method="post" enctype="multipart/form-data">
									<table class="table table-sm">
										<thead>
											<tr>
												<th>
													<aui:input id="selectAll"  name="" type="checkbox" >
												
													</aui:input> 
												</th>
												<th>
													<liferay-ui:message key="RetiroCesantiasPorlet.identificacion" />
												</th>
												<th>
													<liferay-ui:message key="RetiroCesantiasPorlet.nombre" />
												</th>
												<th>
													<liferay-ui:message key="RetiroCesantiasPorlet.saldo" />
												</th>
												<th>
													<liferay-ui:message key="RetiroCesantiasPorlet.saldoretirar" />
												</th>
												<th>
													<liferay-ui:message key="RetiroCesantiasPorlet.concepto" />
												</th>
												<th>
													<liferay-ui:message key="RetiroCesantiasPorlet.tipodocumento" />
												</th>
												<th>
													<liferay-ui:message key="RetiroCesantiasPorlet.nodocumento" />
												</th>
													<th>
													<liferay-ui:message key="RetiroCesantiasPorlet.nombrerazon" />
												</th>
												<th>
												X	
												</th>

											</tr>
										</thead>
										<tbody>

										<% /* for (int i=0; i< afiliados.size(); i++){ 
											Afiliado afiliado = (Afiliado)afiliados.get(i);
											String inputCheck="check"+afiliado.getIdAfiliado();
											String inputId="id"+afiliado.getIdAfiliado();
											String inputNombre="nombre"+afiliado.getIdAfiliado();
											String inputSaldo="saldo"+afiliado.getIdAfiliado();
											String inputMotivo="motivo"+afiliado.getIdAfiliado();
										 */
										 %>
												
											<tr>
												<td>
												<aui:input id="inputCheck"  name="" type="checkbox" >
												
												</aui:input> 
												</td>
												<td> 
												<aui:input id="inputId" name="" type="text" value="afiliado.getIdAfiliado()" disabled="disabled"></aui:input>
													
												</td>
												<td>
												<aui:input id="inputNombre" name="" type="text" value="afiliado.getNombreAfiliado()" disabled="disabled"></aui:input>
												
													
												</td>
												<td>
													<aui:input id="inputSaldo" name="" type="text" value="afiliado.getSaldoCesantias()" disabled="disabled"></aui:input>
												
													
												</td>
												<td>
													<aui:input id="inputSaldoRetirar" name="" type="text" value="afiliado.getSaldoCesantiasRetirar()" disabled="disabled"></aui:input>
												
													
												</td>
												<td>
													<aui:select class="btn btn-primary dropdown-toggle" id="inputTipo" 	showEmptyOption="true"  name=""  placeholder="Seleccione">
	            										<aui:option value="RetiroCesantiasPorlet.educacion"><liferay-ui:message key="RetiroCesantiasPorlet.CC" /></aui:option>
													    <aui:option value="RetiroCesantiasPorlet.retiro"><liferay-ui:message key="RetiroCesantiasPorlet.CE" /></aui:option>
													    <aui:option value="RetiroCesantiasPorlet.vivienda"><liferay-ui:message key="RetiroCesantiasPorlet.NIT" /></aui:option>
													    <aui:option value="RetiroCesantiasPorlet.otro"><liferay-ui:message key="RetiroCesantiasPorlet.otro" /></aui:option>
												</aui:select>		
												</td>
												<td>
												<aui:input id="inputNoDocumento" name="" type="text" value="afiliado.getNombreAfiliado()" disabled="disabled"></aui:input>
												
													
												</td>
												
												<td>
												<aui:input id="inputNombreRazon" name="" type="text" value="afiliado.getNombreAfiliado()" disabled="disabled"></aui:input>
												
													
												</td>
												
												<td>
												<a href="#">
												  <span class="glyphicon glyphicon-trash"></span>
												</a>
												</td>
												
											</tr>
										<% //} %>
										
										</tbody>
									
									</table>
									<aui:button type="submit" class="btn btn-primary" id="btnNextStepThree" name="btnNextStepThree" value="RetiroCesantiasPorlet.continuar" aria-disabled="true"></aui:button>
									</aui:form>
								</div>
							</div>

<aui:script use="aui-node,aui-io-request,aui-base,aui-loading-mask,aui-form-validator">
      
/*       A.ready(function() {
            loading();
            onload();
            
      });

      function loading(){
            try {
                  A.use('aui-loading-mask', function(A) {
                        A.one('.container-fluid').plug(A.LoadingMask, { background: '#FFF', strings: { }, messageEl: A.one(".loadingMaskLoader") });
                        A.one('.container-fluid').loadingmask.show();
                  });
            } catch(err) {
                console.error("problema cargando la mascara");
            }     
      }
      
	  function onload(){
	       // debugger;
	       // alert("Hola");
	          
	      } 
      
	      
	      A.one('#<portlet:namespace/>btnNextStepThree').on(
	    	        'click',
	    	        function(event) {
	    	            alert('Thank you for clicking.')
	    	        }
	    	    );
	      
	  
	     /*  A.on('click', function() {
	    	  debugger;
	          //carteraMora(this);
	    	  alert("evento");
	      }, "<portlet:namespace/>btnNextStep"); */

 */
</aui:script>
