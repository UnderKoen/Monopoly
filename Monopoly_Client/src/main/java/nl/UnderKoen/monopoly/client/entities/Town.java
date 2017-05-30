package nl.UnderKoen.monopoly.client.entities;

import javafx.scene.paint.Color;

import java.util.List;

/**
 * Created by Under_Koen on 23-05-17.
 */
public interface Town {
    String getName();

    Color getColor();

    Street getStreet(String streetName);

    List<Street> getStreets();
}
