package nl.UnderKoen.monopoly.server.model.map.streets;

import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.JailCorner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class ServerJailCorner implements JailCorner {
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

    //JailCorner
    private List<Player> inJail = new ArrayList<>();
    private double prisonLeavePrice;

    @Override
    public boolean isInJail(Player player) {
        return inJail.contains(player);
    }

    @Override
    public List<Player> getPlayersInJail() {
        return inJail;
    }

    @Override
    public void addPlayerToJail(Player player) {
        inJail.add(player);
    }

    @Override
    public void removePlayerFromJail(Player player) {
        inJail.remove(player);
    }

    @Override
    public double getPrisonLeavePrice() {
        return prisonLeavePrice;
    }

    public void setPrisonLeavePrice(double prisonLeavePrice) {
        this.prisonLeavePrice = prisonLeavePrice;
    }
}
