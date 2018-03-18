<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="init.jsp"%>   
<%@ page import="java.util.List"%>
<%@ page import="co.com.general.porvenir.dto.Afiliado"%>
<%
	List<Afiliado> afiliados = (List<Afiliado>)renderRequest.getAttribute("afiliados");
	if (afiliados != null && !afiliados.isEmpty())
%>    
<div class="row">
								<div class="col-md-12">
									<table class="table table-sm">
										<thead>
											<tr>
												<th>
													#
												</th>
												<th>
													Identificación
												</th>
												<th>
													Nombre
												</th>
												<th>
													Saldo Retiro
												</th>
												<th>
													Concepto de Retiro
												</th>
												<th>
												X	
												</th>

											</tr>
										</thead>
										<tbody>
										
										<% for (int i=0; i< afiliados.size(); i++){ 
											Afiliado afiliado = afiliados.get(i);
										%>
												
											<tr>
												<td>
												<label><input type="checkbox" value=""></label>	
												</td>
												<td> 
													<%=afiliado.getIdAfiliado() %>
												</td>
												<td>
													<%=afiliado.getNombreAfiliado() %>
												</td>
												<td>
													<%=afiliado.getSaldoCesantias() %>
												</td>
												<td>
													<div class="dropdown">
														<button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
															Retiro
														</button>
														<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
															 <a class="dropdown-item disabled" href="#">Vivienda</a> <a class="dropdown-item" href="#">Educación</a> <a class="dropdown-item" href="#">Otro</a>
														</div>
													</div>
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
								</div>
							</div>