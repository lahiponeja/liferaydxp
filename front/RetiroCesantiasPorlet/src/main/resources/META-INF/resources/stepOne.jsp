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


<%
ThemeDisplay themeD=null;
if (request != null) {
	themeD = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
}
 Long groupId = themeD.getCompany().getGroup().getGroupId();
 String fileTitle = "ArchivoRetiroMasivoCesantiasEmpleador";
 

 
List<DLFolder> listFolder = DLFolderLocalServiceUtil.getDLFolders(-1, -1);
Map<String, DLFolder> folders = new TreeMap<String, DLFolder>();
 DLFolder folderDL=folders.get("docs");
 //DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "docs");
 long folder=44831;

 DLFileEntry fileEntry =com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil.getDLFileEntry(44835);

 
 fileEntry = fileEntry.toEscapedModel();

 long fileEntryId = fileEntry.getFileEntryId();
 long folderId = fileEntry.getFolderId();
 String name = fileEntry.getName();
 String extension = fileEntry.getExtension();
 String title = fileEntry.getTitle();

%>
<portlet:resourceURL var="resourceURL"/>
	<div class="row">
		<div class="col-md-12">
				<div class="page-header">
					<h1>
						Descargue el archivo excel
					</h1>
				</div>
				<dl>
					<dt>
						¿Ya diligencio su Excel?
					</dt>
					
					<dt>
						A continuación podrá subir el archivo de Excel que descargo un vez lo haya diligenciado-
					</dt>
					<dd>
						<span>.</span>
					</dd>
				</dl>
				<ul class="nav" style="display: inline;">
					<li class="nav-item">
						<a class="nav-link active" href="<%= themeD.getPathMain() %>/document_library/get_file?folderId=<%= folderId %>&name=<%= HttpUtil.encodeURL(name) %>">%= fileEntry.getTitle() %">.xls Abono a cuentas</a>
					
						</li>
					<li class="nav-item">
						<a class="nav-link" href="#">.xls Pago por cheque</a>
					</li>
					
				</ul>
				<form role="form" enctype="multipart/form-data">
					<div class="form-group">
						 
						<label for="exampleInputFile">
							Adjunte su archivo
						</label>
						<input type="file" class="form-control-file" id="exampleInputFile">
						<p class="help-block">
							Example block-level help text here.
						</p>
					</div>
					<div class="progress">
							<div class="progress-bar w-75">
							</div>
					</div>
					<div class="checkbox">
						 
						<label>
							<input type="checkbox"> Adjunte su archivo
						</label>
					</div> 
					<button type="submit" class="btn btn-primary">
						Continuar
					</button>
				</form>
			</div>
		</div>
		<script type="text/javascript">
	
 
</script>