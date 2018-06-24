<%@ include file="/init.jsp" %>

<%
    String[] buttonSwitchTo = new String[2];
    buttonSwitchTo[0] = LanguageUtil.get(request, "button-switch-to-backend");
    buttonSwitchTo[1] = LanguageUtil.get(request, "button-switch-to-frontend");
%>
<portlet:actionURL name="saveBoardAs" var="saveBoardAsURL"></portlet:actionURL>

<portlet:renderURL var="openBoardURL">
    <portlet:param name="mvcPath" value="/list.jsp"></portlet:param>
</portlet:renderURL>

<div id="<portlet:namespace />-all" width="100%" height="2000px">
    <div id="<portlet:namespace />-button">
<%--
        <aui:button-row>
            <button id="<portlet:namespace />-save-board-button" class="btn btn-default" type="button">Save Board</button>
            <button id="<portlet:namespace />-save-board-as-button" class="btn btn-default" type="button">Save Board As</button>
            <aui:button onClick="<%= openBoardURL.toString() %>" value="Open Board"></aui:button>
            <button id="<portlet:namespace />-clear-board-button" class="btn btn-default" type="button">New Board</button>
        </aui:button-row>
--%>
        <aui:button-row>
            <button
                id="<portlet:namespace />-svg-json-button"
                class="btn btn-default"
                type="button">
                    <%=buttonSwitchTo[0]%>
            </button>
        </aui:button-row>
    </div>
    <hr/>
    <div id="<portlet:namespace />-persist">
        <aui:form
            action="<%= saveBoardAsURL %>"
            name="<portlet:namespace />-fm">

            <aui:fieldset>
                <aui:input name="name"></aui:input>
                <aui:input name="description"></aui:input>
                <aui:input name="configuration"></aui:input>
                <aui:input id="-json" name="setup">
                </aui:input>
            </aui:fieldset>
            <aui:button-row>
                <aui:button type="submit"></aui:button>
            </aui:button-row>
        </aui:form>
    </div>

    <div id="<portlet:namespace />-board" class="board">
        <svg id="<portlet:namespace />-mainSVG" width="100%" height="2000px"></svg>
    </div>
</div>

<aui:script require="sketch-board-web@1.0.0">
    sketchBoardWeb100.default('<portlet:namespace />', '', ['<%=buttonSwitchTo[0]%>','<%=buttonSwitchTo[1]%>']);
</aui:script>

