package nl.UnderKoen.monopoly.server.model;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.Inventory;
import nl.UnderKoen.monopoly.common.interfaces.map.OwnableStreet;
import nl.UnderKoen.monopoly.common.interfaces.map.Street;
import nl.UnderKoen.monopoly.common.interfaces.map.Town;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.NormalStreet;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class ServerInventory implements Inventory {
    private double money;
    private List<OwnableStreet> streets;

    public ServerInventory() {
        this.money = 0;
        this.streets = new ArrayList<>();
    }

    @Override
    public boolean hasStreet(Street street) throws RemoteException {
        return streets.contains(street);
    }

    @Override
    public List<OwnableStreet> getStreets() throws RemoteException {
        return streets;
    }

    @Override
    public List<OwnableStreet> getStreets(StreetType streetType) throws RemoteException {
        List<OwnableStreet> streets = new ArrayList<>(getStreets());
        streets.removeIf(street -> street.getStreetType() != streetType);
        return streets;
    }

    @Override
    public List<Town> getFullTowns() throws RemoteException {
        List<Town> towns = new ArrayList<>();
        for (Street streetT : streets) {
            if (streetT instanceof NormalStreet) {
                NormalStreet street = (NormalStreet) streetT;
                if (streets.containsAll(street.getTown().getStreets()) && !towns.contains(street.getTown())) {
                    towns.add(street.getTown());
                }
            }
        }
        return towns;
    }

    @Override
    public double getMoney() throws RemoteException {
        return money;
    }

    @Override
    public void setMoney(double money) throws RemoteException {
        this.money = money;
    }

    @Override
    public void addMoney(double money) throws RemoteException {
        setMoney(getMoney() + money);
    }

    @Override
    public void removeMoney(double money) throws RemoteException {
        setMoney(getMoney() - money);
    }

    @Override
    public boolean hasMoney(double money) throws RemoteException {
        return (getMoney() - money) >= 0;
    }
}
