package nl.UnderKoen.monopoly.common.interfaces.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.interfaces.map.Corner;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface JailCorner extends Corner {

    boolean canMove(Player player);

    @Override
    default StreetType getStreetType() {
        return StreetType.JAIL;
    }
}