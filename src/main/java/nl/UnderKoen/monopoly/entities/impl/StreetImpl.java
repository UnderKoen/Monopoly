package nl.UnderKoen.monopoly.entities.impl;

import javafx.scene.paint.Color;
import nl.UnderKoen.monopoly.entities.Street;
import nl.UnderKoen.monopoly.entities.Town;

/**
 * Created by Under_Koen on 23-05-17.
 */
public class StreetImpl implements Street {
    private String name;
    private Town town;
    private Category category;
    private double price;
    private boolean corner;

    @Override
    public Boolean isCorner() {
        return corner;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Town getTown() {
        return town;
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

    public void setTown(Town town) {
        this.town = town;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCorner(boolean corner) {
        this.corner = corner;
    }
}
