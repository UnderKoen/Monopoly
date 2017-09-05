package nl.UnderKoen.monopoly.server.model.map.streets;

import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.StartCorner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class ServerStartCorner implements StartCorner {
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

    //StartCorner
    private double PassReward;
    private double HitReward;

    @Override
    public double getOnPassReward() {
        return PassReward;
    }

    public void setPassReward(double passReward) {
        PassReward = passReward;
    }

    @Override
    public double getOnHitReward() {
        return HitReward;
    }

    public void setHitReward(double hitReward) {
        HitReward = hitReward;
    }
}
