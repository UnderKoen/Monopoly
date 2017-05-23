package nl.UnderKoen.monopoly.entities.impl;

import javafx.scene.paint.Color;
import nl.UnderKoen.monopoly.entities.Street;
import nl.UnderKoen.monopoly.entities.Town;

import java.util.List;

/**
 * Created by Under_Koen on 23-05-17.
 */
public class TownImpl implements Town {
    private String name;
    private Color color;
    private List<Street> streets;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Street getStreet(String streetName) {
        for (Street street: streets) {
            if (street.getName().contentEquals(streetName)) {
                return street;
            }
        }
        return null;
    }

    @Override
    public List<Street> getStreets() {
        return streets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }
}
