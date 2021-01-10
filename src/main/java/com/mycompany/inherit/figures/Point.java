package com.mycompany.inherit.figures;

import java.util.Objects;

public class Point {
    protected final double x;
    protected final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point translate(double x, double y) {
        return new Point(this.x + x, this.y + y);
    }

    public Point scale(double factor) {
        return new Point(this.x * factor, this.y * factor);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}