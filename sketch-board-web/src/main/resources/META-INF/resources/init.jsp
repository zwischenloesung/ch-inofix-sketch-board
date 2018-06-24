<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="ch.inofix.sketchboard.configuration.SketchBoardConfiguration" %>

<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>

<%@ page import="com.liferay.portal.kernel.portlet.PortalPreferences" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<%@ page import="javax.portlet.PortletPreferences" %>
<%@page import="javax.portlet.PortletURL"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(request);

    SketchBoardConfiguration sketchBoardConfiguration = (SketchBoardConfiguration) request
            .getAttribute(SketchBoardConfiguration.class.getName());

    String startup = "";
    if (Validator.isNotNull(sketchBoardConfiguration)) {
        startup = GetterUtil.getString(portletPreferences.getValue("startup", "show-list"));
    }
%>
