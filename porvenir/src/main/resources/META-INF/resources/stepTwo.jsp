<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="init.jsp"%>   
<%@ page import="java.util.List"%>
<%@ page import="co.com.general.porvenir.dto.Afiliado"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%

	 List<Afiliado> afiliados = (List<Afiliado>)renderRequest.getAttribute("afiliados"); 
	//List<Afiliado> afiliados =  new ArrayList();
	//System.out.println(afiliados.size());
	if (afiliados != null && !afiliados.isEmpty()) {
%>    
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
									<a class="btn btn-primary" href="${stepThreeURL}">Continuar</a>
									<a class="" data-param></a>
								</div>
							</div>

<<<<<<< HEAD
<aui:script use="aui-node,aui-io-request,aui-base">
      
	A.on('click', function() {
=======
						</tr>
					</thead>
					<tbody>
						<% 
											for(int i=0; i<afiliados.size(); i++){
												Afiliado afiliado = afiliados.get(i);
										%>
							<c:set var='inputCheck' value='check+${afiliado.idAfiliado}' />
							<c:set var='inputId' value='id+${afiliado.idAfiliado}' />
							<c:set var='inputNombre' value='nombre+${afiliado.idAfiliado}' />
							<c:set var='inputSaldo' value='saldo+${afiliado.idAfiliado}' />
							<c:set var='inputMotivo' value='motivo+${afiliado.idAfiliado}' />

							<tr>
								<td>
									<!--             									<input name='errorMessageAnchor' hidden/> -->
									<aui:input id="${inputCheck}" name=""
										class="checkbox selectorCheck"
										type="checkbox">
									</aui:input>
								</td>
								<td><aui:input id="${inputId}" name=""
										type="text" value="<%=afiliado.getIdAfiliado() %>" disabled="disabled">
									</aui:input></td>
								<td><aui:input id="${inputNombre}" name=""
										type="text" value="<%=afiliado.getNombreAfiliado() %>"
										disabled="disabled">
									</aui:input></td>
								<td><aui:input id="${inputSaldo}" name=""
										type="text" value="<%=afiliado.getSaldoCesantias() %>"
										disabled="disabled">
									</aui:input></td>
								<td><aui:select value=""
										class="btn btn-primary dropdown-toggle" id=""
										showEmptyOption="true" required="true" name=""
										placeholder="Seleccione">
										<aui:option value="RetiroCesantiasPorlet.educacion">
											<liferay-ui:message key="RetiroCesantiasPorlet.educacion" />
										</aui:option>
										<aui:option value="RetiroCesantiasPorlet.retiro">
											<liferay-ui:message key="RetiroCesantiasPorlet.retiro" />
										</aui:option>
										<aui:option value="RetiroCesantiasPorlet.vivienda">
											<liferay-ui:message key="RetiroCesantiasPorlet.vivienda" />
										</aui:option>
										<aui:option value="RetiroCesantiasPorlet.otro">
											<liferay-ui:message key="RetiroCesantiasPorlet.otro" />
										</aui:option>
									</aui:select></td>
								<td><a href="#"> <span
										class="glyphicon glyphicon-trash"></span>
								</a></td>

							</tr>
							<% 
												}
											%>

					</tbody>

				</table>
				<aui:button type="submit" value="Continuar" />
			</aui:form>
		</div>
	</div>
</div>
<% } %>
<style>
.control-label{
	display:none;
}
</style>
>>>>>>> branch 'master' of https://github.com/mfelipeac/Demo.git
	
	debugger;
	var group = new A.CheckboxGroup(A.all(':checkbox'))
    console.log(group.cb_list);
	    	        	
	 group.cb_list.each(function() {
	    	        		var currentNode = this;
	    	        		console.log("check is chacked "+this);
	    	        		var checki = this.getAttribute('checked')
	    	        		debugger;
	    	            	console.log("check is chacked "+checki);
	    	                                       
	    	            });
	
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
