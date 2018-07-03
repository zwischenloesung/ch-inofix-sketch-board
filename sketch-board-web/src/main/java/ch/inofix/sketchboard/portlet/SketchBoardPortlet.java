package ch.inofix.sketchboard.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import ch.inofix.sketchboard.constants.PortletKeys;
import ch.inofix.sketchboard.model.SketchBoard;
import ch.inofix.sketchboard.service.SketchBoardService;

/**
 * @author Michael Lustenberger
 * @created 2018-06-01
 * @modified 2018-06-22
 * @version 1.0.0
 */
@Component(
    configurationPid = "ch.inofix.sketchboard.configuration.SketchBoardConfiguration",
    immediate = true,
    property = {
        "com.liferay.portlet.css-class-wrapper=portlet-sketch-board",
        "com.liferay.portlet.display-category=category.inofix",
        "com.liferay.portlet.instanceable=true",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.scopeable=true",
        "javax.portlet.display-name=Sketch Board Portlet",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.name=" + PortletKeys.SKETCH_BOARD,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class SketchBoardPortlet extends MVCPortlet {

    public void addSketchBoard(ActionRequest request, ActionResponse response)
            throws PortalException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                                        SketchBoard.class.getName(), request);

        String name = ParamUtil.getString(request, "name");
        String description = ParamUtil.getString(request, "description");
        String configuration = ParamUtil.getString(request, "configuration");
        String setup = ParamUtil.getString(request, "setup");

        long sketchBoardId = ParamUtil.getLong(request, "sketchBoardId");

        try {
            if (sketchBoardId > 0) {

                _sketchBoardService.updateSketchBoard(
                    serviceContext.getUserId(), sketchBoardId, name,
                    description, configuration, setup, serviceContext);
            } else {

                _sketchBoardService.addSketchBoard(
                    serviceContext.getUserId(), name, description,
                    configuration, setup, serviceContext);
            }
            SessionMessages.add(request, "sketchBoardAdded");

            PortletPreferences preferences = request.getPreferences();
            preferences.setValue("sketchBoardId",
                                    String.valueOf(sketchBoardId));
            preferences.store();
            response.setRenderParameter(
                    "sketchBoardId", Long.toString(sketchBoardId));

        } catch (Exception e) {

            SessionErrors.add(request, e.getClass().getName());

            PortalUtil.copyRequestParameters(request, response);

            response.setRenderParameter("mvcPath", "/view.jsp");
        }
    }

    public void deleteSketchBoard(ActionRequest request,
        ActionResponse response) throws PortalException {

        long sketchBoardId = ParamUtil.getLong(request, "sketchBoardId");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                                        SketchBoard.class.getName(), request);

        try {
            response.setRenderParameter(
                    "sketchBoardId", Long.toString(sketchBoardId));

            _sketchBoardService.deleteSketchBoard(
                                        sketchBoardId, serviceContext);
        } catch (Exception e) {

            SessionErrors.add(request, e.getClass().getName());

            PortalUtil.copyRequestParameters(request, response);

            response.setRenderParameter("mvcPath", "/view.jsp");
        }
    }

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(
                    SketchBoard.class.getName(), renderRequest);

            long groupId = serviceContext.getScopeGroupId();
            long sketchBoardId = ParamUtil.getLong(
                                    renderRequest, "sketchBoardId");
            PortletPreferences preferences = renderRequest.getPreferences();
            long configuredBoardId = Long.valueOf(preferences.getValue(
                        "sketchBoardId", String.valueOf(sketchBoardId)));

            if (sketchBoardId > 0) {

                SketchBoard sketchBoard = _sketchBoardService.getSketchBoard(
                                                    sketchBoardId);
            } else if (configuredBoardId > 0) {

                SketchBoard sketchBoard = _sketchBoardService.getSketchBoard(
                                                        configuredBoardId);
                sketchBoardId = configuredBoardId;
            } else {

                SketchBoard sketchBoard = _sketchBoardService.addSketchBoard(
                                    serviceContext.getUserId(), "Example", "",
                                    "", "", serviceContext);
                sketchBoardId = sketchBoard.getSketchBoardId();
            }
            renderRequest.setAttribute("sketchBoardId", sketchBoardId);
        } catch (Exception e) {

            throw new PortletException(e);
        }

        super.render(renderRequest, renderResponse);
    }

    @Reference(unbind = "-")
    protected void setSketchBoardService(
            SketchBoardService sketchBoardService) {
        _sketchBoardService = sketchBoardService;
    }

    private SketchBoardService _sketchBoardService;
}

