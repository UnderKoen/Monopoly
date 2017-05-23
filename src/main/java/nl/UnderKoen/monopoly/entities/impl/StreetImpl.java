package nl.UnderKoen.monopoly.entities.impl;

import javafx.scene.paint.Color;
import nl.UnderKoen.monopoly.entities.Street;

/**
 * Created by Under_Koen on 23-05-17.
 */
public class StreetImpl implements Street {
    private String name;
    private Color color;
    private Category category;
    private double price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
