package nl.UnderKoen.monopoly.common.interfaces.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.interfaces.map.Corner;

import java.util.List;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface JailCorner extends Corner {
    boolean isInJail(Player player);

    List<Player> getPlayersInJail();

    void addPlayerToJail(Player player);

    void removePlayerFromJail(Player player);

    double getPrisonLeavePrice();

    @Override
    default StreetType getStreetType() {
        return StreetType.JAIL;
    }
}