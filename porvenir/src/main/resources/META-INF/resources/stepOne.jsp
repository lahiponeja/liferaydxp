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


<portlet:actionURL name="uploadDocument" var="uploadDocumentURL"></portlet:actionURL>

<%
	ThemeDisplay themeD = null;
	if (request != null) {
		themeD = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	}
	Long groupId = themeD.getCompany().getGroup().getGroupId();
	String fileTitleCh = RetiroCesantiasPortletKeys.tituloArchivoCheque;
	String fileTitleCU = RetiroCesantiasPortletKeys.tituloArchivoCuenta;

	List<DLFolder> listFolder = DLFolderLocalServiceUtil.getDLFolders(-1, -1);
	Map<String, DLFolder> folders = new TreeMap<String, DLFolder>();
	DLFolder folderDL = folders.get("docs");
	//DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "docs");
	long folder = 44831;
	long folderIdCh = 0;
	long folderIdCu = 0;
	String nameCh = ""; 
	String nameCu = "";
	try {
		DLFileEntry fileEntryCH = com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil.getDLFileEntry(31724);

		fileEntryCH = fileEntryCH.toEscapedModel();

		long fileEntryIdCh = fileEntryCH.getFileEntryId();
		folderIdCh = fileEntryCH.getFolderId();
		nameCh = fileEntryCH.getName();
		String extensionCh = fileEntryCH.getExtension();
		String titleCh = fileEntryCH.getTitle();

		DLFileEntry fileEntryCU = com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil.getDLFileEntry(31724);

		fileEntryCU = fileEntryCU.toEscapedModel();

		long fileEntryIdCu = fileEntryCU.getFileEntryId();
		folderIdCu = fileEntryCU.getFolderId();
		nameCu = fileEntryCU.getName();
		String extensionCu = fileEntryCU.getExtension();
		String titleCH = fileEntryCU.getTitle();
		//Obtengo el directorio en el que están los archivos de la matriz
		DLFolder dir = DLFolderLocalServiceUtil.getFolder(themeD.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "docsUpload");

		//Se obtienen los ficheros del directorio
		List<DLFileEntry> dLFileEntrys = DLFileEntryLocalServiceUtil.getFileEntries(dir.getGroupId(), dir.getFolderId());
		
		List<DLFileEntry> dLFileEntrysAux=new ArrayList<DLFileEntry>(dLFileEntrys);
		
		Collections.sort(dLFileEntrysAux, new Comparator<DLFileEntry>(){

			
			public int compare(DLFileEntry o1, DLFileEntry o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});
		
		for (DLFileEntry file : dLFileEntrysAux) {
			if(file.getExtension().equals("xlsx")){
				System.out.println("nombre: " + file.getTitle());
				
			}
		}
	}catch(Exception e)
	{
		
	}
	
	

 
%>

<portlet:resourceURL var="resourceURL" />
<div class="row">
	<div class="col-md-12">
		<div class="page-header">
			<h1>
				<liferay-ui:message key="RetiroCesantiasPorlet.descargue" />
			</h1>
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
			<li class="nav-item"><a class="nav-link active" href="<%=themeD.getPathMain()%>/document_library/get_file?folderId=<%=folderIdCh%>&name=<%=HttpUtil.encodeURL(nameCh)%>"><liferay-ui:message key="RetiroCesantiasPorlet.tituloArchivoCheque" />.xls</a></li>
			<li class="nav-item"><a class="nav-link"  href="<%=themeD.getPathMain()%>/document_library/get_file?folderId=<%=folderIdCu%>&name=<%=HttpUtil.encodeURL(nameCu)%>">.xls<liferay-ui:message key="RetiroCesantiasPorlet.tituloArchivoCuenta" /></a></li>

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

				<label> <aui:input id="checkInput" name="checkInput" type="checkbox"> <liferay-ui:message	key="RetiroCesantiasPorlet.adjunte" /></aui:input>
				</label>
			</div>
			<aui:button type="submit" class="btn btn-primary" id="btnUploadFile" name="btnUploadFile" value="RetiroCesantiasPorlet.continuar">

			</aui:button>
		</aui:form>
	</div>
</div>
<script type="text/javascript">
	
	$(document).ready(function() {
		
	});
	
	AUI().use(
		    'aui-io-request',
		    function(A){

		});

	AUI().use(
			  'aui-form-validator',
			  function(Y) {
				  /* 			  }
				  
				  var DEFAULTS_FORM_VALIDATOR = Y.config.FormValidator;
				  Y.mix(
                             DEFAULTS_FORM_VALIDATOR.RULES,
                             {
                             customRuleForFile:function (value, fieldNode, ruleValue) {
                               var result = false;
                               var minsize=15; // min 1kb
                               var maxsize=20000; 
			            		if((value>minsize)&&(value<=maxsize)){
                                   result = true;
                              	}
                           		return result;
                             	},
                             },
                             true
                 		);
				  Y.mix(
                             DEFAULTS_FORM_VALIDATOR.STRINGS,
                             {
                            	 customRuleForFile:"El archivo debe pesar entre 1MB y 20MB",
                             },
                             true
                 );
				  */          
				  var rules = {
						  <portlet:namespace/>uploadFile: {
						        acceptFiles: 'xls, xlsx',
						        //customRuleForFile: <portlet:namespace/>uploadFile.size,
						        required: true
						      },
						  <portlet:namespace/>checkInput: {
							    required: true
							}
						  };
 
						var fieldStrings = {
								<portlet:namespace/>uploadFile: {
								acceptFiles: 'El tipo de archivo requerido es excel',
						        required: 'El archivo es requerido.'
						      	},
						     	 <portlet:namespace/>checkInput: {
						       required: 'Por favor confirme si desea adjuntar su archivo.'
								}
						      
						    };
						debugger;
			   
						
						var validator = new Y.FormValidator({
							  	boundingBox: '#<portlet:namespace/>uploadDoc',
						        fieldStrings: fieldStrings,
								rules: rules,
								showAllMessages: true
						});

						 var url = '<%=uploadDocumentURL.toString() %>';
							
						
						if(validator.hasErrors()){
							alert("hello");
							// event.preventDefault();
							}else{
								
								Y.io.request(url, {
									method: 'POST',
									form: { id: '<portlet:namespace/>uploadDoc' },
									dataType: 'json',
									on:{
									success: function(event, id, ob){
											/* if(this.get('responseData')!=null && this.get('responseData').organizationNameExists){
											A.one("#<portlet:namespace/>name").get('parentNode').removeClass('success').addClass('error');
											A.one("#<portlet:namespace/>name").addClass('error-field lfr-input-text').removeClass('success-field');
											A.one("#<portlet:namespace/>name").get('parentNode').append(A.one('#organizationNameError').show()); */
											var instance = this;
											//JSON Data coming back from Server
											var message = instance.get('responseData');
											if (message) {
											alert(message.retVal1);
											alert(message.retVal2)
											}
											else{
											//A.one('#organizationNameError').hide();
												if(!validator.hasErrors()){
													document.<portlet:namespace/>inputForm.submit();
												}
											}
										}
									}
								});
								
								
							}
						
						
					
						
						

			  }
			);
	

	
	AUI().use('aui-progressbar', function(y) {			
		new Y.ProgressBar(
			      {
			        boundingBox: '#<portlet:namespace/>id="formProgressBar"',
			        label: '40%',
			        max: 100,
			        min: 0,
			        on: {
			          complete: function(e) {
			            this.set('label', 'Complete!');
			          },
			          valueChange: function(e) {
			            this.set('label', e.newVal + '%');
			          }
			        },
			        value: 40,
			        width: 700
			      }
			    ).render();
		  
	});

</script>