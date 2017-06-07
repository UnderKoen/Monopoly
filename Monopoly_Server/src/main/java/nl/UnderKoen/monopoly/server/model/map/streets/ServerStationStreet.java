package nl.UnderKoen.monopoly.server.model.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.StationType;
import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.StationStreet;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class ServerStationStreet implements StationStreet {
    //Ownable
    private Player owner;

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Player player) {
        this.owner = player;
    }

    @Override
    public boolean hasOwner() {
        return owner != null;
    }

    @Override
    public boolean isOwner(Player player) {
        return owner == player;
    }

    //Rentable
    private double buyPrice;
    private boolean onMortage;

    @Override
    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public double getRentPrice() {
        return getPrice(getOtherStations());
    }

    @Override
    public boolean isOnMortgage() {
        return onMortage;
    }

    @Override
    public void setMortgage(Boolean mortgage) {
        this.onMortage = mortgage;
    }

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

    //StationStreet
    private StationType stationType;
    private Map<Integer, Double> prices;

    @Override
    public StationType getStationType() {
        return stationType;
    }

    public void setStationType(StationType stationType) {
        this.stationType = stationType;
    }

    @Override
    public boolean hasOtherStations() {
        try {
            if (hasOwner()) {
                return (getOwner().getInventory().getStreets(StreetType.STATION).size() - 1) > 0;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getOtherStations() {
        try {
            if (hasOwner()) {
                return getOwner().getInventory().getStreets(StreetType.STATION).size() - 1;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public double getPrice(int amountOfStations) {
        return prices.get(amountOfStations);
    }

    public void setPrices(Map<Integer, Double> prices) {
        this.prices = prices;
    }
}
