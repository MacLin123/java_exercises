package com.mycompany.inherit.figures;

import java.util.Objects;

public class Line extends Shape {
    private Point to;

    public Line(Point from, Point to) {
        super(from);
        this.to = to;
    }

    @Override
    public Point getCenter() {
        return new Point((getPoint().getX() + to.getX()) / 2,
                (getPoint().getY() + to.getY()) / 2);
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Line clone = (Line) super.clone();
        clone.to = new Point(to.getX(), to.getY());
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Line line = (Line) o;
        return to.equals(line.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), to);
    }
}
