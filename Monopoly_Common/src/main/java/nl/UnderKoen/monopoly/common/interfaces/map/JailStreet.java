package nl.UnderKoen.monopoly.common.interfaces.map;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.Player;

import java.io.Serializable;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface JailStreet extends Street, Serializable {

    boolean canMove(Player player);

    @Override
    default StreetType getStreetType() {
        return StreetType.JAIL;
    }
}
