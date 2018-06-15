import * as d3 from 'd3/dist/d3';

export default function(portletNamespace, json) {
    Liferay.Loader.require('sketch-board-web@1.0.0/js/noteit.board.es', function (noteit) {

        let board = new noteit.SketchBoard(`#${portletNamespace}-mainSVG`);
        let rstack = new noteit.Stack(board, board.group, "Type", ["#f7ff72", "#ff6ee2", "#6ee0ff"], [14,14]);
        if (typeof json !== 'undefined' && json.length > 3 ) {
            board.fromJSON(json);
        }
    });
}

