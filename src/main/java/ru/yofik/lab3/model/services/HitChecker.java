package ru.yofik.lab3.model.services;

public final class HitChecker {
    public static boolean isHit(double x, double y, double r) {
        return isRound(x, y, r) || isSquare(x, y, r) || isTriangle(x, y, r);
    }

    private static boolean isSquare(double x, double y, double r) {
        return x >= -r && x <= 0 && y >= 0 && y <= r;
    }

    private static boolean isTriangle(double x, double y, double r) {
        return x >= -r && x <= 0 && y >= -r/2.0 && y <= 0 && y >= (-x/2.0 - r/2.0);
    }

    private static boolean isRound(double x, double y, double r) {
        return x >= 0 && y <= 0 && (y * y + x * x) <= r * r / 4.0;
    }
}
