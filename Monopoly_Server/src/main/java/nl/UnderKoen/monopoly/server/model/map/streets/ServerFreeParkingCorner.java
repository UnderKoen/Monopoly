package nl.UnderKoen.monopoly.server.model.map.streets;

import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.FreeParkingCorner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class ServerFreeParkingCorner implements FreeParkingCorner {
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

    @Override
    public void removePlayerStanding(Player player) {
        standing.remove(player);
    }

    //FreeParkingCorner
    private double jackpot;
    private double standardJackpot;

    @Override
    public double getJackpot() {
        return jackpot;
    }

    @Override
    public void setJackpot(double jackpot) {
        this.jackpot = jackpot;
    }

    @Override
    public double getStandardJackpot() {
        return standardJackpot;
    }

    public void setStandardJackpot(double standardJackpot) {
        this.standardJackpot = standardJackpot;
    }

    @Override
    public void resetJackpot() {
        setJackpot(getStandardJackpot());
    }
}
