import App from "./App.js";
import Graph from "./utilities/services/Graph.js";
import DataExtractor from "./utilities/services/DataExtractor.js";

const graph = new Graph();

$('svg').on('click', ( event ) => {
    const clickPoint = graph.getClickPoint(event);

    console.log(clickPoint.x);
    const r = DataExtractor.getR();

    if (r === undefined) {
        alert("Ops. Choose r.");
        return;
    }

    const relativeUnit = 100 / r;
    // $("#graph-from\\:x-value_input").val(((clickPoint.x - 150) / relativeUnit).toFixed(2));
    document.getElementById("graph-form:x-value_input").value = ((clickPoint.x - 150) / relativeUnit).toFixed(3);
    document.getElementById("graph-form:y-value-hidden_input").value = (( 150 - clickPoint.y ) / relativeUnit).toFixed(3);

    // if (r === undefined) {
    //     this.modal.open(
    //         "Oops",
    //         "It seems that you hadn't chosen R value"
    //     );
    //     return;
    // }

    graph.drawDots([ clickPoint.x ], clickPoint.y, r, [true],true);
    // $('input[name="x-group"]:checked').click();
    // this.$yInput.val('')

    // const relativeUnit = 100 / r;
    //
    // const formData = new FormData();
    // formData.append("xValues", `${  ((clickPoint.x - 150) / relativeUnit).toFixed(2) }`);
    // formData.append("y", `${ (( 150 - clickPoint.y ) / relativeUnit).toFixed(2) }`);
    // formData.append("r", r);
    //
    // fetch('/web/api', {
    //     method: 'POST',
    //     body: formData
    // })
    //     .then(response => response.text())
    //     .then(data => {
    //         document.write(data);
    //     })

    // Toast.successToast('Data was sent to server');
});

// document.getElementById()

export function draw() {
    console.log("her");
}