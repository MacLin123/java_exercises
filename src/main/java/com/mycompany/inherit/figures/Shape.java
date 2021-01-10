package com.mycompany.inherit.figures;

import java.util.Objects;

public abstract class Shape implements Cloneable {
    private Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public Shape() {
        point = new Point(0, 0);
    }

    public void moveBy(double dx, double dy) {
        point = new Point(dx + point.getX(), dy + point.getY());
    }

    public abstract Point getCenter();

    public Point getPoint() {
        return point;
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
        Shape clone = (Shape) super.clone();
        clone.point = new Point(getPoint().getX(), getPoint().getY());
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return point.equals(shape.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
