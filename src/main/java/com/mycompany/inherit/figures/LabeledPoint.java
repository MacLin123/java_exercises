package com.mycompany.inherit.figures;

import java.util.Objects;

public class LabeledPoint extends Point {
    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabeledPoint that = (LabeledPoint) o;
        return label.equals(that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    /**
     * x and y can be accessed in subclass
     * @return
     */
    @Override
    public String toString() {
        return "LabeledPoint{" +
                "label='" + label + '\'' +
                ", x = " + x +
                ", y = " + y + '}';
    }
}
