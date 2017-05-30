package nl.UnderKoen.monopoly.client.builders;

import javafx.scene.paint.Color;
import nl.UnderKoen.monopoly.client.entities.Street;
import nl.UnderKoen.monopoly.client.entities.Town;
import nl.UnderKoen.monopoly.client.entities.impl.StreetImpl;
import nl.UnderKoen.monopoly.client.entities.impl.TownImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Under_Koen on 23-05-17.
 */
public class TownBuilder {
    private TownImpl town;

    public TownBuilder() {
        town = new TownImpl();
    }

    public TownBuilder setName(String name) {
        town.setName(name);
        return this;
    }

    public TownBuilder setColor(Color color) {
        town.setColor(color);
        return this;
    }

    public TownBuilder addStreet(String name, double price) {
        StreetImpl street = new StreetImpl();
        street.setName(name);
        street.setPrice(price);
        street.setCategory(Street.Category.NORMAL);
        List<Street> streets = town.getStreets();
        if (streets == null) {
            streets = new ArrayList<>();
        }
        street.setTown(town);
        streets.add(street);
        town.setStreets(streets);
        return this;
    }

    public Town build() {
        return town;
    }
}
