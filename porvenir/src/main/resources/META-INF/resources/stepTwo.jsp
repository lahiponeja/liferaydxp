<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="init.jsp"%>   
<%@ page import="java.util.List"%>
<%@ page import="co.com.general.porvenir.dto.Afiliado"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:resourceURL id="/data/event" var="dataURL" />

<p>
	<b><liferay-ui:message key="RetiroCesantiasPorlet.caption"/></b>
</p>
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="tabbable" id="tabs-94785">
				<ul class="nav nav-tabs">
					<li class="nav-item">
						<a class="nav-link" href="#panel-1" data-toggle="tab"><liferay-ui:message key="RetiroCesantiasPorlet.medioPago"/></a>
					</li>
					<li class="nav-item">
						<a class="nav-link active" href="#panel-2" data-toggle="tab"><liferay-ui:message key="RetiroCesantiasPorlet.ingreso"/></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#panel-3" data-toggle="tab"><liferay-ui:message key="RetiroCesantiasPorlet.revision"/></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#panel-4" data-toggle="tab"><liferay-ui:message key="RetiroCesantiasPorlet.fin"/></a>
					</li>
				</ul>
			</div>
		</div>
	</div>

<portlet:actionURL name="stepThree" var="stepThreeURL"></portlet:actionURL>
							<div class="row">
								<div class="col-md-12">
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
													<liferay-ui:message key="RetiroCesantiasPorlet.concepto" />
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
													<aui:select value="${afiliado.motivo}" class="btn btn-primary dropdown-toggle" id="${inputMotivo}" showEmptyOption="true"  name=""  placeholder="Seleccione">
	            										<aui:option value="RetiroCesantiasPorlet.educacion"><liferay-ui:message key="RetiroCesantiasPorlet.educacion" /></aui:option>
													    <aui:option value="RetiroCesantiasPorlet.retiro"><liferay-ui:message key="RetiroCesantiasPorlet.retiro" /></aui:option>
													    <aui:option value="RetiroCesantiasPorlet.vivienda"><liferay-ui:message key="RetiroCesantiasPorlet.vivienda" /></aui:option>
													    <aui:option value="RetiroCesantiasPorlet.otro"><liferay-ui:message key="RetiroCesantiasPorlet.otro" /></aui:option>
												</aui:select>		
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
									<a class="" href="${stepThreeURL}">Continuar</a>
									<a class="" data-param>set data</a>
								</div>
							</div>

<aui:script use="aui-node,aui-io-request,aui-base">
      
	A.on('click', function() {
	AUI().use('aui-io-request', function(A){
		A.io.request('<%=dataURL.toString()%>', { 
			method: 'post', 
				on: {
					success: function() {
						console.log("suc");
					}, 
					failure: function(event, id, xhr) {
						console.log("errro");
					} 
				} 
		}); 
	});
}, "[data-param]"); 
      });

	  /*     A.one('#<portlet:namespace/>btnNextStep').on(
	    	        'click',
	    	        function(event) {
	    	            alert('Thank you for clicking.')
	    	        }
	    	    ); */
	      
</aui:script>
