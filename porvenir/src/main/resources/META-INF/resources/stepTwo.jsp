<%@ include file="/init.jsp" %>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="init.jsp"%>   
<%@ page import="java.util.List"%>
<%@ page import="co.com.general.porvenir.dto.Afiliado"%>
<portlet:actionURL name="stepThree" var="stepThreeURL"></portlet:actionURL>
<%

	List<Afiliado> afiliados = (List<Afiliado>)renderRequest.getAttribute("afiliados"); 
	//List<Afiliado> afiliados =  new ArrayList();
	System.out.println(afiliados.size());
	if (afiliados != null && !afiliados.isEmpty())
%>    
<div class="row">
								<div class="col-md-12">
									<aui:form id="stepTwo" name="stepTwo" action="${stepThreeURL}" method="post" enctype="multipart/form-data">
									<table class="table table-sm">
										<thead>
											<tr>
												<th>
													
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
													<liferay-ui:message key="RetiroCesantiasPorlet.concepto" />
												</th>
												<th>
												X	
												</th>

											</tr>
										</thead>
										<tbody>

										<% for (int i=0; i< afiliados.size(); i++){ 
											Afiliado afiliado = (Afiliado)afiliados.get(i);
											String inputCheck="check"+afiliado.getIdAfiliado();
											String inputId="id"+afiliado.getIdAfiliado();
											String inputNombre="nombre"+afiliado.getIdAfiliado();
											String inputSaldo="saldo"+afiliado.getIdAfiliado();
											String inputMotivo="motivo"+afiliado.getIdAfiliado();
										%>
												
											<tr>
												<td>
												<aui:input id="<%=inputCheck%>"  name="" type="checkbox">
												
												</aui:input> 
												</td>
												<td> 
												<aui:input id="<%=inputId%>" name="" type="text" value="<%=afiliado.getIdAfiliado()%>" disabled="disabled"></aui:input>
													
												</td>
												<td>
												<aui:input id="<%=inputNombre%>" name="" type="text" value="<%=afiliado.getNombreAfiliado()%>" disabled="disabled"></aui:input>
												
													
												</td>
												<td>
													<aui:input id="<%=inputSaldo%>" name="" type="text" value="<%=afiliado.getSaldoCesantias()%>" disabled="disabled"></aui:input>
												
													
												</td>
												<td>
													<aui:select class="btn btn-primary dropdown-toggle" id="<%=inputMotivo%>" 	showEmptyOption="true"  name="product"  placeholder="Select a product">
	            										<aui:option value="RetiroCesantiasPorlet.educacion"><liferay-ui:message key="RetiroCesantiasPorlet.educacion" /></aui:option>
													    <aui:option value="RetiroCesantiasPorlet.retiro"><liferay-ui:message key="RetiroCesantiasPorlet.retiro" /></aui:option>
													    <aui:option value="RetiroCesantiasPorlet.vivienda"><liferay-ui:message key="RetiroCesantiasPorlet.vivienda" /></aui:option>
													    <aui:option value="RetiroCesantiasPorlet.otro"><liferay-ui:message key="RetiroCesantiasPorlet.otro" /></aui:option>
													    <aui:validator name="required">
													    function() {
										                		debugger;
										                		console.log("Validador"+<%=inputCheck%>);
										                        return AUI.$('#<portlet:namespace /><%=inputCheck%>').prop('checked');
										                }
													    </aui:validator>
	        										</aui:select>		
												</td>
												<td>
												<a href="#">
												  <span class="glyphicon glyphicon-trash"></span>
												</a>
												</td>
												
											</tr>
										<% } %>
										
										</tbody>
									
									</table>
									<aui:button type="submit" class="btn btn-primary" id="btnNextStep" name="btnNextStep" value="RetiroCesantiasPorlet.continuar" ></aui:button>
									</aui:form>
								</div>
							</div>