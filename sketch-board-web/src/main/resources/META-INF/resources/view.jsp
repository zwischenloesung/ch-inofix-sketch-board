<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="sketch-board-web.caption"/></b>
</p>

<div id="<portlet:namespace />"></div>

<aui:script require="sketch-board-web@1.0.0">
    sketchBoardWeb100.default('<portlet:namespace />');
</aui:script>
