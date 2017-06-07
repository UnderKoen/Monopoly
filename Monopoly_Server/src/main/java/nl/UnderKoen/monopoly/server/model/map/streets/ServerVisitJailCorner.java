package nl.UnderKoen.monopoly.server.model.map.streets;

import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.VisitJailCorner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class ServerVisitJailCorner implements VisitJailCorner {
    //Street
    private int id;
    private List<Player> standing = new ArrayList<>();

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean isStanding(Player player) {
        return false;
    }

    @Override
    public List<Player> getPlayersStanding() {
        return standing;
    }

    @Override
    public void addPlayerStanding(Player player) {
        this.standing.add(player);
    }
}
