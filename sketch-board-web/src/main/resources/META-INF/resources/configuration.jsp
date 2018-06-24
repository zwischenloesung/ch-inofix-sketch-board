<%--
    configuration.jsp

    Created:    2018-06-23 by Michael Lustenberger
    Modified:   2018-06-23 by Michael Lustenberger
    Version:    1.0.0
--%>

<%@ include file="/init.jsp" %>

<%
    PortletURL portletURL = renderResponse.createRenderURL();

    String namespace = liferayPortletResponse.getNamespace();
%>

<style>
<!--
    .portlet-sketchboard .panel-title {
        position: relative;
    }
-->
</style>

<liferay-portlet:actionURL portletConfiguration="<%=true%>"
    var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%=true%>"
    var="configurationRenderURL" />

<aui:form action="<%=configurationActionURL%>" method="post" name="fm"
    onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveConfiguration();" %>'>

    <div class="portlet-configuration-body-content">

        <div class="container-fluid-1280">

            <liferay-ui:panel collapsible="<%=true%>"
                id="sketchBoardStartupPanel"
                persistState="<%=true%>"
                title="columns">

                <aui:fieldset cssClass="col-md-6">

                    <aui:field-wrapper label="startup"
                        helpMessage="startup-help" inlineField="false">

                        <aui:input name="preferences--startup--"
                            type="radio" value="show-list"
                            checked='<%=Validator.equals(startup, "show-list")%>'
                            label="show-list" inlineField="true" />
                        <aui:input name="preferences--startup--"
                            type="radio" value="show-board"
                            checked='<%=Validator.equals(startup, "show-board")%>'
                            label="show-board" inlineField="true" />
                    </aui:field-wrapper>
                </aui:fieldset>
            </liferay-ui:panel>
        </div>

        <aui:button-row>
            <aui:button type="submit" />
        </aui:button-row>

    </div>

</aui:form>

<aui:script>
    function <portlet:namespace />saveConfiguration() {
        var Util = Liferay.Util;

        var form = AUI.$(document.<portlet:namespace />fm);

        form.fm('columns').val(Util.listSelect(form.fm('currentColumns')));

        submitForm(form);
    }
</aui:script>

