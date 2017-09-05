package nl.UnderKoen.monopoly.common.interfaces.map;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.Player;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface Street extends Serializable {
    int getId();

    void setId(int id);

    boolean isStanding(Player player);

    List<Player> getPlayersStanding();

    void addPlayerStanding(Player player);

    void removePlayerStanding(Player player);

    StreetType getStreetType();
}
