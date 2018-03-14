package co.com.general.porvenir.portlet;

import co.com.general.porvenir.constants.ControlerPortletKeys;

import com.axa.portal.col.distributor.service.ServiceConsumer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import co.com.RetiroCesantiasPorlet.constants.RetiroCesantiasPortletKeys;
/**
 * @author Manuel
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.Porvenir",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=" + RetiroCesantiasPortletKeys.Caption,
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ControlerPortletKeys.Controler,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ControlerPortlet extends MVCPortlet {
	
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		System.out.println("doView");
		try {
			ServiceConsumer.INSTANCE.consumeConsultarProductoCompania("1", "2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}
}