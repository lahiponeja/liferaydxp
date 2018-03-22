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
<<<<<<< HEAD
									<aui:form id="stepTwo" name="stepTwo">
									
										<table class="table table-sm">
=======
									<table class="table table-sm">
>>>>>>> branch 'master' of https://github.com/mfelipeac/Demo.git
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
<<<<<<< HEAD
												
            									<input name='errorMessageAnchor' hidden/>
												<aui:input id="${inputCheck}"  name="" class="checkbox" type="checkbox" >
=======
												<aui:input id="${inputCheck}"  name="" type="checkbox" >
>>>>>>> branch 'master' of https://github.com/mfelipeac/Demo.git
												
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
<<<<<<< HEAD
									<a class="btn btn-primary" href="${stepThreeURL}">Continuar</a>
									<a class="" data-param>set data</a>
									</aui:form>
=======
									<a class="" href="${stepThreeURL}">Continuar</a>
									<a class="" data-param>set data</a>
>>>>>>> branch 'master' of https://github.com/mfelipeac/Demo.git
								</div>
							</div>
<<<<<<< HEAD
	<script type="text/javascript">
=======
>>>>>>> branch 'master' of https://github.com/mfelipeac/Demo.git

<<<<<<< HEAD
 //Listen for click on toggle checkbox
$('#selectAll').click(function(event) {   
    if(this.checked) {
        // Iterate each checkbox
        $(':checkbox').each(function() {
        	console.log("check "+this);
            this.checked = true;                        
        });
        $("#filters select").each(function() {
        	console.log("select "+this);
        	this.required = true;                        
        });
    }else {
    	$(':checkbox').each(function() {
            this.checked = false;                        
        })
        $("#filters select").each(function() {
            this.required = false;                        
        })
    	
    	
    }
    
}); 



</script>		

				

<aui:script use="aui-node,aui-io-request,aui-base">



A.on('click', function() {
	
	AUI().use('aui-node', function(A){
		A.one('.btn').on('click', function(){
			debugger;
		    var values = [];
		    A.all('input[type=checkbox]').each(function(){
		        if(this.get('checked')){
		            values.push(this.get('value'));
		        }
		    });
		    console.log(values);
		}); });
		
		AUI().use('aui-io-request', function(A){
=======
<aui:script use="aui-node,aui-io-request,aui-base">
      
	A.on('click', function() {
	AUI().use('aui-io-request', function(A){
>>>>>>> branch 'master' of https://github.com/mfelipeac/Demo.git
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
