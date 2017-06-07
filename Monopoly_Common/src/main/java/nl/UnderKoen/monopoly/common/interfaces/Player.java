package nl.UnderKoen.monopoly.common.interfaces;

import javafx.scene.paint.Color;
import nl.UnderKoen.monopoly.common.interfaces.map.Street;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface Player {
    boolean isOnStreet(Street street);

    Street getStreetStandingOn();

    Color getColor();

    Inventory getInventory();

    String getUsername();
}
