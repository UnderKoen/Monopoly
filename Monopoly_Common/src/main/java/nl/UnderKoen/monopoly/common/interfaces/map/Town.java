package nl.UnderKoen.monopoly.common.interfaces.map;

import javafx.scene.paint.Color;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.NormalStreet;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Under_Koen on 02-06-17.
 */
public interface Town extends Serializable {
    List<NormalStreet> getStreets();

    String getName();

    Color getColor();

    int getId();
}