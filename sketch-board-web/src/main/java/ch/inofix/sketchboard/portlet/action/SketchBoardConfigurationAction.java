package ch.inofix.sketchboard.portlet.action;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import ch.inofix.sketchboard.constants.PortletKeys;
import ch.inofix.sketchboard.configuration.SketchBoardConfiguration;

/**
 * Configuration of Inofix' SketchBoard.
 *
 * @author Michael Lustenberger
 * @created 2018-06-23
 * @modified 2018-06-23
 * @version 1.0.0
 */

@Component(
    configurationPid = "ch.inofix.sketchboard.configuration.SketchBoardConfiguration",
    configurationPolicy = ConfigurationPolicy.OPTIONAL,
    immediate = true,
    property = {"javax.portlet.name=" + PortletKeys.SKETCH_BOARD},
    service = ConfigurationAction.class
)

public class SketchBoardConfigurationAction extends DefaultConfigurationAction {

    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest
            actionRequest, ActionResponse actionResponse) throws Exception {

        Long sketchBoardId = ParamUtil.getLong(actionRequest, "sketchBoardId");

// Does not work..        setPreference(actionRequest, "sketchBoardId", "22");
        PortletPreferences preferences = actionRequest.getPreferences();
        preferences.setValue("sketchBoardId", String.valueOf(sketchBoardId));
        preferences.store();

        super.processAction(portletConfig, actionRequest, actionResponse);
    }

    @Override
    public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws Exception {

        httpServletRequest.setAttribute(SketchBoardConfiguration.class.getName(), _sketchBoardConfiguration);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {

        _sketchBoardConfiguration = ConfigurableUtil.createConfigurable(
                SketchBoardConfiguration.class, properties);

    }

    private volatile SketchBoardConfiguration _sketchBoardConfiguration;
}

