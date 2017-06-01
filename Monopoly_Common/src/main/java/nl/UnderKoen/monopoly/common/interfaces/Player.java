package nl.UnderKoen.monopoly.common.interfaces;

import nl.UnderKoen.monopoly.common.interfaces.map.Street;

import java.io.Serializable;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface Player extends Serializable {
    boolean isOnStreet(Street street);

    Street getCurrentStreet();
}
