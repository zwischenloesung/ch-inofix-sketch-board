import * as d3 from 'd3/dist/d3';

export default function(portletNamespace, json, buttonSwitchTo) {
    Liferay.Loader.require('sketch-board-web@1.0.0/js/noteit.board.es', function (noteit) {

        function createBoard(json) {
            board = new noteit.SketchBoard(`#${portletNamespace}-mainSVG`);
            let s = new noteit.Stack(board, board.group,
                        "Type", ["#f7ff72", "#ff6ee2", "#6ee0ff"], [14,14]);
            if (typeof json !== 'undefined' && json.length > 3 ) {
                board.fromJSON(json);
            }
        }

        var board;
        createBoard(json);

        var boardDiv = d3.select(`#${portletNamespace}-board`);
        boardDiv.style("height", "100%");
        boardDiv.style("width", "100%");
        var storeDiv = d3.select(`#${portletNamespace}-persist`);
        var store = d3.select(`#${portletNamespace}-json`);

        storeDiv.style("height", "0px");
        storeDiv.style("width", "100%");
        storeDiv.style("visibility", "hidden");

        var curOutputJSON = false;
        var switchButton = d3.select(`#${portletNamespace}-svg-json-button`);
        switchButton.on("click", function() {
            curOutputJSON = !curOutputJSON;

            if (curOutputJSON === true) {
                switchButton.attr("value", "JSON");
                storeDiv.style("visibility", "visible");
                storeDiv.style("height", "100%");
                boardDiv.style("visibility", "hidden");
                boardDiv.style("height", "0px");
                switchButton.text(buttonSwitchTo[1]);
                store.attr("value", board.toJSON("  "));
                board.group.remove();
                board = null;
            } else {
                switchButton.attr("value", "SVG");
                storeDiv.style("visibility", "hidden");
                storeDiv.style("height", "0px");
                boardDiv.style("visibility", "visible");
                boardDiv.style("height", "100%");
                switchButton.text(buttonSwitchTo[0]);
                createBoard(store.node().value);
            }
        });
    });
}

