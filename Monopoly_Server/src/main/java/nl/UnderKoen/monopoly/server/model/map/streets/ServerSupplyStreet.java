package nl.UnderKoen.monopoly.server.model.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.enumeration.SupplyType;
import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.SupplyStreet;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class ServerSupplyStreet implements SupplyStreet {
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
            return getPrice(0);
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

    //SupplyStreet
    private SupplyType supplyType;
    private Map<Integer, Double> prices;

    @Override
    public SupplyType getSupplyType() {
        return supplyType;
    }

    public void setSupplyType(SupplyType supplyType) {
        this.supplyType = supplyType;
    }

    @Override
    public boolean hasOtherSupplies() {
        try {
            if (hasOwner()) {
                return (getOwner().getInventory().getStreets(StreetType.SUPPLY).size() - 1) > 0;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getOtherSupplies() {
        try {
            if (hasOwner()) {
                return getOwner().getInventory().getStreets(StreetType.SUPPLY).size() - 1;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public double getPrice(int amountOfSupplies) {
        return prices.get(amountOfSupplies);
    }

    public void setPrices(Map<Integer, Double> prices) {
        this.prices = prices;
    }
}
