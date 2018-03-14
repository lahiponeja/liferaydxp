<%@ include file="/init.jsp" %>

<!-- <p>
	<b><liferay-ui:message key="retiromasivocesantiasportlet_Retiromasivocesantiasportletmvcportlet.caption"/></b>
</p>-->
    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="tabbable" id="tabs-94785">
				<ul class="nav nav-tabs">
					<li class="nav-item">
						<a class="nav-link active" href="#panel-1" data-toggle="tab">Elegir medio de pago</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#panel-2" data-toggle="tab">Ingreso de Datos</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#panel-3" data-toggle="tab">Revisi�n de Datos</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#panel-4" data-toggle="tab">Fin del servicio</a>
					</li>
				</ul>
				<div class="tab-content">
				<div class="tab-pane active" id="panel-1">
				<%@include file="stepOne.jsp"%>		
				</div>
				<div class="tab-pane" id="panel-2">
				<%@include file="stepTwo.jsp"%>				
				</div>
				<div class="tab-pane" id="panel-3">
				<%@include file="stepThree.jsp"%>	
				</div>
				<div class="tab-pane" id="panel-4">
				<%@include file="stepFour.jsp"%>	
				</div>
				</div>
			</div>
		</div>
	</div>