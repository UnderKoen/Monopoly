package nl.UnderKoen.monopoly.common.interfaces.map;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.Player;

import java.util.List;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface Street {
    int getId();

    boolean isStanding(Player player);

    List<Player> getPlayersStanding();

    void addPlayerStanding(Player player);

    StreetType getStreetType();
}
