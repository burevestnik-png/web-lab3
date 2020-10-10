import Toast from "./utilities/components/Toast.js";
import DataExtractor from "./utilities/services/DataExtractor.js";
import Validator from "./utilities/services/Validator.js";
import ModalWindow from "./utilities/components/Modal.js";

export default class App {
    constructor(  ) {
    }

    init() {
        $('svg').on('click', ( event ) => {
            /*const clickPoint = this.graph.getClickPoint(event);

            const r = DataExtractor.getR();
            if (r === undefined) {
                this.modal.open(
                    "Oops",
                    "It seems that you hadn't chosen R value"
                )
                return;
            }

            this.graph.drawDots([ clickPoint.x ], clickPoint.y, r, true)
            $('input[name="x-group"]:checked').click();
            this.$yInput.val('')

            const relativeUnit = 100 / r;

            const formData = new FormData();
            formData.append("xValues", `${  ((clickPoint.x - 150) / relativeUnit).toFixed(2) }`);
            formData.append("y", `${ (( 150 - clickPoint.y ) / relativeUnit).toFixed(2) }`);
            formData.append("r", r);

            fetch('/web/api', {
                method: 'POST',
                body: formData
            })
                .then(response => response.text())
                .then(data => {
                    document.write(data);
                })*/

            Toast.successToast('Data was sent to server');
        })
    }
}