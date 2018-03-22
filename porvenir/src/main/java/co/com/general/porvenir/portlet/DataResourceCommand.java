package co.com.general.porvenir.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import co.com.general.porvenir.constants.ControlerPortletKeys;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ControlerPortletKeys.Controler,
	        "mvc.command.name=/data/event"
	    },
	    service = MVCResourceCommand.class
	)
public class DataResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest arg0, ResourceResponse arg1) throws PortletException {
		// TODO Auto-generated method stub
		return false;
	}

}
