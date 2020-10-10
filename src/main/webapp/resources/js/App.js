// import Toast from "./utilities/components/Toast.js";
import DataExtractor from "./utilities/services/DataExtractor.js";
// import ModalWindow from "./utilities/components/Modal.js";
import Graph from "./utilities/services/Graph.js";

export default class App {
    graph;
    modal;

    constructor(  ) {
        this.graph = new Graph();
        // this.modal = new ModalWindow();
    }

    init() {
        $('svg').on('click', ( event ) => {
            console.log(document.getElementsByTagName("form").elements);
            const clickPoint = this.graph.getClickPoint(event);

            console.log(clickPoint.x);
            const r = DataExtractor.getR();

            if (r === undefined) {
                alert("Ops. Choose r.");
                return;
            }

            const relativeUnit = 100 / r;
            $("#graph-from\\:x-value_input").val(((clickPoint.x - 150) / relativeUnit).toFixed(2));


            // if (r === undefined) {
            //     this.modal.open(
            //         "Oops",
            //         "It seems that you hadn't chosen R value"
            //     );
            //     return;
            // }

            this.graph.drawDots([ clickPoint.x ], clickPoint.y, r, [true],true);
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
        })
    }
}