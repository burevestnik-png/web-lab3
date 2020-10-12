export default class Validator {
    static isHit(x, y, r) {
        return this.isRound(x, y, r) || this.isSquare(x, y, r) || this.isTriangle(x, y, r);
    }

    static isSquare(x, y, r) {
        return x >= -r && x <= 0 && y >= 0 && y <= r;
    }

    static isTriangle(x, y, r) {
        return x >= -r && x <= 0 && y >= -r/2.0 && y <= 0 && y >= (-x/2.0 - r/2.0);
    }

    static isRound(x, y,  r) {
        return x >= 0 && y <= 0 && (y * y + x * x) <= r * r / 4.0;
    }
}