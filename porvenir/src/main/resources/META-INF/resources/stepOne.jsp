<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="javax.activation.MimetypesFileTypeMap"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@ page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@ page import="com.liferay.document.library.kernel.model.DLFolder"%>
<%@ page import="com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.TreeMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="co.com.RetiroCesantiasPorlet.constants.RetiroCesantiasPortletKeys"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="java.util.ResourceBundle"%>

<portlet:actionURL name="uploadDocument" var="uploadDocumentURL"></portlet:actionURL>

<%
	System.out.println("Nueva version");
	ThemeDisplay themeD = null;
	if (request != null) {
		themeD = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	}
	Long groupId = themeD.getCompany().getGroup().getGroupId();
	String fileTitleCh = RetiroCesantiasPortletKeys.tituloArchivoCheque;
	String fileTitleCU = RetiroCesantiasPortletKeys.tituloArchivoCuenta;

	List<DLFolder> listFolder = DLFolderLocalServiceUtil.getDLFolders(-1, -1);
	Map<String, DLFolder> folders = new TreeMap<String, DLFolder>();
	//DLFolder folderDL = folders.get("docs");
	String docsBase = LanguageUtil.get(ResourceBundle.getBundle("content/Language", request.getLocale()), "Folder.base");
	String docsUpload = LanguageUtil.get(ResourceBundle.getBundle("content/Language", request.getLocale()), "Folder.carga");
	String archivoCheque = LanguageUtil.get(ResourceBundle.getBundle("content/Language", request.getLocale()), "Nombre.archivoCheque");
	String archivoCuenta = LanguageUtil.get(ResourceBundle.getBundle("content/Language", request.getLocale()), "Nombre.archivoCuenta");

	DLFolder folderDL = DLFolderLocalServiceUtil.getFolder(themeD.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, docsBase);

	DLFileEntry fileEntryCH = com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil.getFileEntry(themeD.getScopeGroupId(), folderDL.getFolderId(), archivoCheque);

	DLFileEntry fileEntryCU = com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil.getFileEntry(themeD.getScopeGroupId(), folderDL.getFolderId(), archivoCheque);

	fileEntryCU = fileEntryCU.toEscapedModel();

	long folderIdCh = fileEntryCH.getFolderId();
	long folderIdCu = fileEntryCU.getFolderId();
	String nameCh = fileEntryCH.getName();
	String nameCu = fileEntryCH.getName();
 
%>

<portlet:resourceURL var="resourceURL" />
<div class="row">
	<div class="col-md-12">
		<div class="page-header">
			<h1>
				<liferay-ui:message key="RetiroCesantiasPorlet.descargue" />
			</h1>
		</div>
			<div>
				<span>Hola este es un cambio, realizado el dia 23 de Marzo en el laboratorio digital para <b>Porvenir</b></span>
			</div>
		<dl>
			<dt>
				<liferay-ui:message key="RetiroCesantiasPorlet.diligencio" />
			</dt>

			<dt>
				<liferay-ui:message key="RetiroCesantiasPorlet.subir" />
			</dt>
			<dd>
				<span>.</span>
			</dd>
		</dl>
		<ul class="nav" style="display: inline;">
			<li class="nav-item"  style="display: inline-block;"><a class="nav-link active" href="<%=themeD.getPathMain()%>/document_library/get_file?folderId=<%=folderIdCh%>&name=<%=HttpUtil.encodeURL(nameCh)%>"><span class="glyphicon glyphicon-download-alt">&nbsp;</span><liferay-ui:message key="RetiroCesantiasPorlet.tituloArchivoCheque" />.xls</a></li>
			<li class="nav-item"  style="display: inline-block;"><a class="nav-link"  href="<%=themeD.getPathMain()%>/document_library/get_file?folderId=<%=folderIdCu%>&name=<%=HttpUtil.encodeURL(nameCu)%>"><span class="glyphicon glyphicon-download-alt">&nbsp;</span><liferay-ui:message key="RetiroCesantiasPorlet.tituloArchivoCuenta" />.xls</a></li>

		</ul>
		<aui:form id="uploadDoc" name="uploadDoc" action="${uploadDocumentURL}" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="exampleInputFile"> <liferay-ui:message
						key="RetiroCesantiasPorlet.tituloAdjuntar" />

				</label>
				<aui:input type="file" class="form-control-file" id="uploadFile" name="uploadFile"></aui:input>
				<p class="help-block">
					<liferay-ui:message key="RetiroCesantiasPorlet.ayudaAdjuntar" />
				</p>
			</div>
			<div class="progress" id="formProgressBar" name="formProgressBar">
				<div class="progress-bar w-75"></div>
			</div>
			<div class="checkbox">
				<label for="checkInput">
				 <liferay-ui:message	key="RetiroCesantiasPorlet.adjunte" />
				</label>
				<aui:input id="checkInput" name="checkInput" type="checkbox"></aui:input> 
				
			</div>
			<aui:button type="submit" class="btn btn-primary" id="btnUploadFile" name="btnUploadFile" value="RetiroCesantiasPorlet.continuar" >

			</aui:button>
		</aui:form>
	</div>
</div>
<script type="text/javascript">

	AUI().use(
		    'aui-io-request',
		    function(A){

		});

	YUI().use('aui-form-validator','aui-progressbar',
            function(Y) {
			var progress= new Y.ProgressBar({
					        boundingBox: '#formProgressBar',
					        label: '0%',
					        max: 100,
					        min: 0,
					        on: {
					          complete: function(e) {
					            this.set('label', 'Completado!');
					          },
					          valueChange: function(e) {
					            this.set('label', e.newVal + '%');
					          }
					        },
					        value: 0,
					        width: 700
					      }).render();

		  var DEFAULTS_FORM_VALIDATOR = Y.config.FormValidator;
		  Y.mix(
                     DEFAULTS_FORM_VALIDATOR.RULES,
                     {
                     customRuleForFile:function (value, fieldNode, ruleValue) {
                       var result = false;
                       var minsize=2000; // min 1kb
                       var maxsize=100000; 
                       var file=<portlet:namespace/>uploadFile;
                       if((file.files[0].size>minsize)&&(file.files[0].size<=maxsize)){
                        	   result = true;
                           }
                      	return result;
                     	},
                     },
                     true
         		);
		 var rules = {
				  <portlet:namespace/>uploadFile: {
				        acceptFiles: 'xls, xlsx',
				        customRuleForFile:true,
				        required: true
				      },
				  <portlet:namespace/>checkInput: {
					    required: true
					}
				  };

		var fieldStrings = {
						<portlet:namespace/>uploadFile: {
						acceptFiles: 'El tipo de archivo requerido es excel',
				        required: 'El archivo es requerido.',
				        customRuleForFile:"El archivo debe pesar entre 2MB y 100MB",
				      	},
				     	 <portlet:namespace/>checkInput: {
				       required: 'Por favor confirme si desea adjuntar su archivo.'
						}
				      
				    };
				//debugger;
	   
				
				var validator = new Y.FormValidator({
					  	boundingBox: '#<portlet:namespace/>uploadDoc',
				        fieldStrings: fieldStrings,
						rules: rules,
						showAllMessages: true
				});
				
			Y.one('#<portlet:namespace/>uploadFile').on('click', function(){
	            	 progress.set('value', 100);
	            	
	            	 })
                              
             Y.one('.btn').on('click', function(){
            	 progress.set('value', 100);
            	 validator.validate();
            	 })
          }
  );

</script>

<style>
	.acceptFiles{
		color:red;
	}
	.customRuleForFile{
		color:red;
	}
</style>