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

<%
ThemeDisplay themeD=null;
if (request != null) {
	themeD = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
}
 Long groupId = themeD.getCompany().getGroup().getGroupId();
 String fileTitleCh = RetiroCesantiasPortletKeys.tituloArchivoCheque;
 String fileTitleCU = RetiroCesantiasPortletKeys.tituloArchivoCuenta;

 
List<DLFolder> listFolder = DLFolderLocalServiceUtil.getDLFolders(-1, -1);
Map<String, DLFolder> folders = new TreeMap<String, DLFolder>();
 DLFolder folderDL=folders.get("docs");
 //DLFolder dlFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "docs");
 long folder=44831;

 DLFileEntry fileEntryCH =com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil.getDLFileEntry(31724);

 
 fileEntryCH = fileEntryCH.toEscapedModel();

 long fileEntryIdCh = fileEntryCH.getFileEntryId();
 long folderIdCh = fileEntryCH.getFolderId();
 String nameCh = fileEntryCH.getName();
 String extensionCh = fileEntryCH.getExtension();
 String titleCh = fileEntryCH.getTitle();

 
 DLFileEntry fileEntryCU =com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil.getDLFileEntry(31724);

 
 fileEntryCU = fileEntryCU.toEscapedModel();

 long fileEntryIdCu = fileEntryCU.getFileEntryId();
 long folderIdCu = fileEntryCU.getFolderId();
 String nameCu = fileEntryCU.getName();
 String extensionCu = fileEntryCU.getExtension();
 String titleCH = fileEntryCU.getTitle();

%>
<portlet:resourceURL var="resourceURL"/>
	<div class="row">
		<div class="col-md-12">
				<div class="page-header">
					<h1>
						<%=RetiroCesantiasPortletKeys.descargue %>
					</h1>
				</div>
				<dl>
					<dt>
						<%=RetiroCesantiasPortletKeys.diligencio %>
					</dt>
					
					<dt>
						<%=RetiroCesantiasPortletKeys.subir %>
					</dt>
					<dd>
						<span>.</span>
					</dd>
				</dl>
				<ul class="nav" style="display: inline;">
					<li class="nav-item">
						<a class="nav-link active" href="<%= themeD.getPathMain() %>/document_library/get_file?folderId=<%= folderIdCh %>&name=<%= HttpUtil.encodeURL(nameCh) %>">	<%=RetiroCesantiasPortletKeys.tituloArchivoCheque %></a>
					
						</li>
					<li class="nav-item">
						<a class="nav-link" href="<%= themeD.getPathMain() %>/document_library/get_file?folderId=<%= folderIdCu %>&name=<%= HttpUtil.encodeURL(nameCu) %>">	<%=RetiroCesantiasPortletKeys.tituloArchivoCuenta %></a>
					</li>
					
				</ul>
				<form role="form" enctype="multipart/form-data">
					<div class="form-group">
						 
						<label for="exampleInputFile">
							Adjunte su archivo
						</label>
						<input type="file" class="form-control-file" id="exampleInputFile">
						<p class="help-block">
							<%=RetiroCesantiasPortletKeys.ayudaAdjuntar %>
						</p>
					</div>
					<div class="progress">
							<div class="progress-bar w-75">
							</div>
					</div>
					<div class="checkbox">
						 
						<label>
							<input type="checkbox"> <%=RetiroCesantiasPortletKeys.adjunte %>
						</label>
					</div> 
					<button type="submit" class="btn btn-primary">
						 <%=RetiroCesantiasPortletKeys.continuar %>
					</button>
				</form>
			</div>
		</div>
		<script type="text/javascript">
	
 
</script>