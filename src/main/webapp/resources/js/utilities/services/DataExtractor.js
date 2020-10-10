export default class DataExtractor {
    static getValues() {
        return {
            x: this.getX(),
            y: this.getY(),
            r: this.getR()
        }
    }

    static getX() {

        return undefined;
    }

    static getR() {
        return $('#graph-form\\:r-value_input').val();
    }

    static getY() {
        return undefined;
    }
}