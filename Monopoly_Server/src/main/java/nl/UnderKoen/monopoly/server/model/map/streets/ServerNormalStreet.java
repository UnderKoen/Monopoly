package nl.UnderKoen.monopoly.server.model.map.streets;

import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.interfaces.map.Town;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.NormalStreet;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class ServerNormalStreet implements NormalStreet {
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
        if (hasOwner()) {
            return getPrice(getHouses());
        }
        return 0;
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

    @Override
    public void removePlayerStanding(Player player) {
        standing.remove(player);
    }

    //NormalStreet
    private double housePrice;
    private int houses;
    private String name;
    private Town town;
    private Map<Integer, Double> prices;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(double housePrice) {
        this.housePrice = housePrice;
    }

    @Override
    public int getHouses() {
        return houses;
    }

    @Override
    public void setHouses(int houses) {
        this.houses = houses;
    }

    @Override
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Override
    public boolean hasFullTown() {
        try {
            if (hasOwner()) {
                return getOwner().getInventory().getFullTowns().contains(getTown());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public double getPrice(int numberOfHouses) {
        if (numberOfHouses == 0 && hasFullTown()) {
            return prices.get(numberOfHouses) * 2;
        }
        return prices.get(numberOfHouses);
    }

    public void setPrices(Map<Integer, Double> prices) {
        this.prices = prices;
    }
}
