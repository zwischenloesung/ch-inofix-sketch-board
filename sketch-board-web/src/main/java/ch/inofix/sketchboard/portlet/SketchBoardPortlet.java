package ch.inofix.sketchboard.portlet;

import ch.inofix.sketchboard.constants.SketchBoardPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author mic
 */
@Component(
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
		"javax.portlet.name=" + SketchBoardPortletKeys.SketchBoard,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SketchBoardPortlet extends MVCPortlet {
}