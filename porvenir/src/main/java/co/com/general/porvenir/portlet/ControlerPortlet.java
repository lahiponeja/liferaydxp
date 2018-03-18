package co.com.general.porvenir.portlet;

import com.axa.portal.col.distributor.service.ObjectTransformer;
import com.axa.portal.col.distributor.service.ServiceConsumer;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.portal.commons.util.CommonsUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import co.com.RetiroCesantiasPorlet.constants.RetiroCesantiasPortletKeys;
import co.com.general.porvenir.constants.ControlerPortletKeys;
import co.com.general.porvenir.dto.Afiliado;
import co.com.general.porvenir.poi.ApachePOIExcelRead;
import co.com.porvenir.ws.ConsultaAfiliadosResponse;

/**
 * @author Manuel
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=Porvenir",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=" + RetiroCesantiasPortletKeys.Caption,
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ControlerPortletKeys.Controler, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ControlerPortlet extends MVCPortlet {

	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		super.doView(renderRequest, renderResponse);
	}

	@ProcessAction(name = "uploadDocument")
	public void uploadDocument(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {

		ThemeDisplay themeD = null;
		if (actionRequest != null) {
			themeD = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		}

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String fileName = uploadPortletRequest.getFileName("uploadFile");
		if (fileName != null && !fileName.isEmpty()) {
			try {
				File file = uploadPortletRequest.getFile("uploadFile");

				long userId = themeD.getUserId();
				long groupId;

				groupId = themeD.getScopeGroupId();

				ServiceContext serviceContext = new ServiceContext();
				serviceContext.setScopeGroupId(groupId);

				DLFolder dir = DLFolderLocalServiceUtil.getFolder(groupId,
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "docsUpload");

				DLAppLocalServiceUtil.addFileEntry(userId, groupId, dir.getFolderId(), "uploadPorvenir",
						new MimetypesFileTypeMap().getContentType(file), userId+"_"+CommonsUtil.stringToCalendar(Calendar.getInstance())+"_"+fileName, "", "", file, serviceContext);
				
				//Lee los registros del excel (dto)
				List<Afiliado> afiliadosExcel = ApachePOIExcelRead.readExcel(file);
				//llama al servicio, (dto)
				List<Afiliado> afiliados = new ArrayList<Afiliado>();
				if (afiliadosExcel  != null && !afiliadosExcel.isEmpty()){
					try {
						ConsultaAfiliadosResponse consultaAfiliados =ServiceConsumer.INSTANCE.consultarAfiliados(afiliadosExcel);
						afiliados = ObjectTransformer.convert(consultaAfiliados, afiliadosExcel);
					} catch (Exception e) {
						//LOGGER.error("Se ha presentado un error en el consumo del servicio", e);
					}
				}
				actionRequest.setAttribute("afiliados", afiliados);
				//redirect a la pagina 2
				actionResponse.setRenderParameter("jspPage", "/META-INF/resources/stepTwo.jsp");
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}