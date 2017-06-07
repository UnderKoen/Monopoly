package nl.UnderKoen.monopoly.common.interfaces.map;

import javafx.scene.paint.Color;

import java.util.List;

/**
 * Created by Under_Koen on 02-06-17.
 */
public interface Town {
    List<Street> getStreets();

    String getName();

    Color getColor();

    int getId();
}