package ru.yofik.lab3.result;

public final class Result {
    private final double x;
    private final double y;
    private final int r;
    private final boolean isHit;


    public Result(double x, double y, int r, boolean isHit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isHit = isHit;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public boolean isHit() {
        return isHit;
    }

    @Override
    public String toString() {
        return "Result{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", isHit=" + isHit +
                '}';
    }
}
