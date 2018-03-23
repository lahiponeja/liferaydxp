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
									<aui:form id="stepThree" name="stepThree" action="${stepThreeURL}" method="post" enctype="multipart/form-data">
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

										 <c:forEach items='${afiliados}' var='afiliado'>
										<c:set var='inputCheck' value='check+${afiliado.idAfiliado}' />
										<c:set var='inputId' value='id+${afiliado.idAfiliado}' />
										<c:set var='inputNombre' value='nombre+${afiliado.idAfiliado}' />
										<c:set var='inputSaldo' value='saldo+${afiliado.idAfiliado}' />
										<c:set var='inputRetiro' value='Retiro+${afiliado.idAfiliado}' />
										<c:set var='inputMotivo' value='motivo+${afiliado.idAfiliado}' />
										
											<tr>
												<td>
												<aui:input id="${inputCheck}"  name="" type="checkbox" >
												</aui:input> 
												</td>
												<td> 
												<aui:input id="${inputId}" name="" type="text" value="${afiliado.idAfiliado}" disabled="disabled"></aui:input>
												</td>
												<td>
												<aui:input id="${inputNombre}" name="" type="text" value="${afiliado.nombreAfiliado}" disabled="disabled"></aui:input>
												</td>
												<td>
													<aui:input id="${inputSaldo}" name="" type="text" value="${afiliado.saldoCesantias}" disabled="disabled"></aui:input>
												</td>
												<td>
													<aui:input id="${inputRetiro}" name="" type="text" value="${afiliado.montoRetiro}" disabled="disabled"></aui:input>
												</td>
												<td>
													<aui:select value="${afiliado.tipoDocumentoBeneficiario}" class="btn btn-primary dropdown-toggle" id="tipoDocBen${afiliado.idAfiliado}" showEmptyOption="true"  name=""  placeholder="Seleccione">
	            										<aui:option value="RetiroCesantiasPorlet.CC"><liferay-ui:message key="RetiroCesantiasPorlet.CC" /></aui:option>
													    <aui:option value="RetiroCesantiasPorlet.CE"><liferay-ui:message key="RetiroCesantiasPorlet.CE" /></aui:option>
													    <aui:option value="RetiroCesantiasPorlet.NIT"><liferay-ui:message key="RetiroCesantiasPorlet.NIT" /></aui:option>
												</aui:select>		
												</td>
												<td>
												<aui:input id="inputNoDocumento+${afiliado.idAfiliado}" name="" type="text" value="${afiliado.numeroDocumentoBeneficiario}" disabled="disabled"></aui:input>
												</td>
												<td>
												<aui:input id="inputNombreRazon+${afiliado.idAfiliado}" name="" type="text" value="${afiliado.razonSocialBeneficiario}" disabled="disabled"></aui:input>
												</td>
												
												<td>
												<a href="#">
												  <span class="glyphicon glyphicon-trash"></span>
												</a>
												</td>
												
											</tr>
										</c:forEach>
												
										
										</tbody>
									
									</table>
									<a class="btn btn-primary" href="${stepFourURL}">Continuar</a>
									</aui:form>
								</div>
							</div>


