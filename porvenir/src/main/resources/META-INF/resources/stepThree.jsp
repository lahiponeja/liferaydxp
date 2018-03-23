<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="init.jsp"%>   
<%@ page import="java.util.List"%>
<%@ page import="co.com.general.porvenir.dto.Afiliado"%>

<portlet:actionURL name="stepFour" var="stepFourURL"></portlet:actionURL>
<%

	 List<Afiliado> afiliados = (List<Afiliado>)renderRequest.getAttribute("afiliados"); 
	//List<Afiliado> afiliados =  new ArrayList();
	//System.out.println(afiliados.size());
	if (afiliados != null && !afiliados.isEmpty()) {
%>    
							<div class="row">
								<div class="col-md-12">
									<aui:form id="stepThree" name="stepThree" action="${stepFourURL}" method="post" enctype="multipart/form-data">
									<table class="table table-sm">
										<thead>
											<tr>
												<th>
													<aui:input id="selectAllt"  name="" type="checkbox" >
												
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
<<<<<<< HEAD

										 <c:forEach items='${afiliados}' var='afiliado'>
										<c:set var='inputCheck' value='check+${afiliado.idAfiliado}' />
										<c:set var='inputId' value='id+${afiliado.idAfiliado}' />
										<c:set var='inputNombre' value='nombre+${afiliado.idAfiliado}' />
										<c:set var='inputSaldo' value='saldo+${afiliado.idAfiliado}' />
										<c:set var='inputRetiro' value='Retiro+${afiliado.idAfiliado}' />
										<c:set var='inputMotivo' value='motivo+${afiliado.idAfiliado}' />
=======
										<% 
											for(int i=0; i<afiliados.size(); i++){
												Afiliado afiliado = afiliados.get(i);
										%>
										
>>>>>>> branch 'master' of https://github.com/mfelipeac/Demo.git
										
											<tr>
												<td>
												<aui:input id=""  name="" type="checkbox" >
												</aui:input> 
												</td>
												<td> 
												<aui:input id="" name="" type="text" value="<%=afiliado.getIdAfiliado() %>" disabled="disabled"></aui:input>
												</td>
												<td>
												<aui:input id="" name="" type="text" value="<%=afiliado.getNombreAfiliado() %>" disabled="disabled"></aui:input>
												</td>
												<td>
													<aui:input id="" name="" type="text" value="<%=afiliado.getSaldoCesantias() %>" disabled="disabled"></aui:input>
												</td>
												<td>
<<<<<<< HEAD
													<aui:input id="${inputRetiro}" name="" type="text" value="${afiliado.montoRetiro}" disabled="disabled"></aui:input>
=======
												<aui:input id="" name="" type="text" value="" disabled="disabled"></aui:input>
>>>>>>> branch 'master' of https://github.com/mfelipeac/Demo.git
												</td>
												<td>
													<aui:select value="" class="btn btn-primary dropdown-toggle" id="" showEmptyOption="true"  name=""  placeholder="Seleccione">
	            										<aui:option value="RetiroCesantiasPorlet.CC"><liferay-ui:message key="RetiroCesantiasPorlet.CC" /></aui:option>
													    <aui:option value="RetiroCesantiasPorlet.CE"><liferay-ui:message key="RetiroCesantiasPorlet.CE" /></aui:option>
													    <aui:option value="RetiroCesantiasPorlet.NIT"><liferay-ui:message key="RetiroCesantiasPorlet.NIT" /></aui:option>
												</aui:select>		
												</td>
												<td>
												<aui:input id="" name="" type="text" value="" disabled="disabled"></aui:input>
												</td>
												<td>
												<aui:input id="" name="" type="text" value="" disabled="disabled"></aui:input>
												</td>
												
												<td>
												<a href="#">
												  <span class="glyphicon glyphicon-trash"></span>
												</a>
												</td>
												
											</tr>
											<% 
												}
											%>
												
										
										</tbody>
									
									</table>
									<a class="btn btn-primary" href="${stepFourURL}">Continuar</a>
									</aui:form>
								</div>
							</div>
<% } %>

