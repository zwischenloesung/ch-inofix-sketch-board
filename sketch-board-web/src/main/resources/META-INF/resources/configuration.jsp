<%--
    configuration.jsp

    Created:    2018-06-23 by Michael Lustenberger
    Modified:   2018-06-25 by Michael Lustenberger
    Version:    1.0.1
--%>

<%@ include file="/init.jsp" %>

<%
    PortletURL portletURL = renderResponse.createRenderURL();

    String namespace = liferayPortletResponse.getNamespace();
%>
<%--
<style>
    .portlet-sketchboard .panel-title {
        position: relative;
    }
</style>
--%>
<liferay-portlet:actionURL portletConfiguration="<%=true%>"
    var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%=true%>"
    var="configurationRenderURL" />

<aui:form action="<%=configurationActionURL%>" method="post" name="fm">

    <div class="portlet-configuration-body-content">

        <div class="container-fluid-1280">

            <liferay-ui:panel collapsible="<%=true%>"
                id="sketchBoardIdPanel"
                persistState="<%=true%>"
                title="sketch-board">

                <aui:fieldset cssClass="col-md-6">

                    <aui:input
                        name="sketchBoardId"
                        value="<%=String.valueOf(sketchBoardId)%>"
                        helpMessage="sketch-board-id-help" />
                </aui:fieldset>
            </liferay-ui:panel>
        </div>

        <aui:button-row>
            <aui:button type="submit" />
        </aui:button-row>

    </div>

</aui:form>

