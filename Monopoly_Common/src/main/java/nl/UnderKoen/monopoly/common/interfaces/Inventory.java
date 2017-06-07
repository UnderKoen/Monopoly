package nl.UnderKoen.monopoly.common.interfaces;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.map.OwnableStreet;
import nl.UnderKoen.monopoly.common.interfaces.map.Street;
import nl.UnderKoen.monopoly.common.interfaces.map.Town;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Under_Koen on 02-06-17.
 */
public interface Inventory extends Remote {
    boolean hasStreet(Street street) throws RemoteException;

    List<OwnableStreet> getStreets() throws RemoteException;

    List<OwnableStreet> getStreets(StreetType streetType) throws RemoteException;

    List<Town> getFullTowns() throws RemoteException;

    double getMoney() throws RemoteException;

    void setMoney(double money) throws RemoteException;

    void addMoney(double money) throws RemoteException;

    void removeMoney(double money) throws RemoteException;
}
