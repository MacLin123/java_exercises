package com.mycompany.inherit;

import java.util.Objects;

public class Item {
    private String description;
    private double price;

    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || !(otherObject instanceof Item)) return false;
        Item item = (Item) otherObject;
        return Double.compare(item.price, price) == 0 && description.equals(item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price);
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
