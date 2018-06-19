import * as d3 from 'd3/dist/d3';

export default function(portletNamespace, json) {
    Liferay.Loader.require('sketch-board-web@1.0.0/js/noteit.board.es', function (noteit) {

        function createBoard(json) {
            board = new noteit.SketchBoard(`#${portletNamespace}-mainSVG`);
            let s = new noteit.Stack(board, board.group,
                        "Type", ["#f7ff72", "#ff6ee2", "#6ee0ff"], [14,14]);
            if (typeof json !== 'undefined' && json.length > 3 ) {
                board.fromJSON(json);
            }
        }

        function createTextarea(json) {
            store = storeDiv.append("textarea").attr("rows", 100)
                                    .attr("cols", 80).attr("value", json);
            store.text(json);
        }

        var board;
        createBoard(json);

        var boardDiv = d3.select(`#${portletNamespace}-board`);
        boardDiv.style("height", "100%");
        boardDiv.style("width", "100%");
        var storeDiv = d3.select(`#${portletNamespace}-json`);
        storeDiv.style("visibility", "hidden");

        storeDiv.style("height", "0%");
        storeDiv.style("width", "100%");
        var store = null;

        var curOutputJSON = false;
        let switchButtonDiv = d3.select(`#${portletNamespace}-button`);
        var switchButton = switchButtonDiv.append("input")
                    .attr("type", "button").attr("value", "JSON")
                    .on("click", function() {
            curOutputJSON = !curOutputJSON;

            if (curOutputJSON === true) {
                switchButton.attr("value", "JSON");
                storeDiv.style("visibility", "visible");
                storeDiv.style("height", "100%");
                boardDiv.style("visibility", "hidden");
//                boardDiv.style("height", "0%");
                switchButton.attr("value", "SVG");
//                store.text(board.toJSON("  "));
                createTextarea(board.toJSON("  "));
                board.group.remove();
                board = null;
            } else {
                switchButton.attr("value", "SVG");
                storeDiv.style("visibility", "hidden");
                storeDiv.style("height", "0%");
                boardDiv.style("visibility", "visible");
//                boardDiv.style("height", "100%");
                switchButton.attr("value", "JSON");
                createBoard(store.node().value);
                store.remove();
            }
        });
    });
}

