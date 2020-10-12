import Graph from "./utilities/services/Graph.js";
import Toast from "./utilities/services/Toast.js";
import Validator from "./utilities/services/Validator.js";

const graph = new Graph();

document.addEventListener("DOMContentLoaded", () => {
    graph.restoreDots();

    graph.redrawField();
    document.getElementById("graph-form:r-value_input").onchange = () => {
        graph.redrawField();
        graph.clearDots();
    };

    document.getElementById("crutch").onclick = () => {
        const clickPoint = {
            x: document.getElementById("graph-form:x-value_input").value,
            y: document.querySelector("input[name='graph-form:y-value']:checked").value
        };

        const r = $('#graph-form\\:r-value_input').val();

        if (!clickPoint.x || !clickPoint.y || !r) {
            return;
        }

        const isHit = Validator.isHit( clickPoint.x, clickPoint.y, r);

        graph.drawDots(clickPoint.x * 20 + 150, 150 - clickPoint.y * 20, r, isHit);
    };
});

$('svg').on('click', ( event ) => {
    const clickPoint = graph.getClickPoint(event);
    const r = $('#graph-form\\:r-value_input').val();

    if (r === undefined) {
        Toast.errorToast("You haven't chosen r");
        return;
    }

    const relativeUnit = 20;

    document.getElementById("graph-form-hidden:x-value-hidden_input").value = ((clickPoint.x - 150) / relativeUnit).toFixed(3);
    document.getElementById("graph-form-hidden:x-value-hidden_hinput").value = ((clickPoint.x - 150) / relativeUnit).toFixed(3);
    document.getElementById("graph-form-hidden:y-value-hidden_input").value = (( 150 - clickPoint.y ) / relativeUnit).toFixed(3);
    document.getElementById("graph-form-hidden:y-value-hidden_hinput").value = (( 150 - clickPoint.y ) / relativeUnit).toFixed(3);
    document.getElementById("graph-form-hidden:r-value-hidden_input").value = r;
    document.getElementById("graph-form-hidden:r-value-hidden_hinput").value = r;
    document.getElementById("graph-form-hidden:j_idt44").click();

    const isHit = Validator.isHit(((clickPoint.x - 150) / relativeUnit).toFixed(3),
                                  (( 150 - clickPoint.y ) / relativeUnit).toFixed(3),
                                  r);

    graph.drawDots(clickPoint.x, clickPoint.y, r, isHit);
});

