<%@ include file="/init.jsp" %>

<div id="<portlet:namespace />-all" width="100%" height="2000px">
    <div id="<portlet:namespace />-button"></div>
    <div id="<portlet:namespace />-json"></div>
    <div id="<portlet:namespace />-board" class="board">
        <svg id="<portlet:namespace />-mainSVG" width="100%" height="2000px"></svg>
    </div>
</div>

<aui:script require="sketch-board-web@1.0.0">
    sketchBoardWeb100.default('<portlet:namespace />');
</aui:script>

