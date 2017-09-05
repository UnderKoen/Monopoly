package nl.UnderKoen.monopoly.common.interfaces;

import nl.UnderKoen.monopoly.common.interfaces.map.Street;
import nl.UnderKoen.monopoly.common.utils.Color;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface Player extends Remote {
    boolean isOnStreet(Street street) throws RemoteException;

    Street getStreetStandingOn() throws RemoteException;

    void setStreetStandingOn(Street street) throws RemoteException;

    Color getColor() throws RemoteException;

    void setColor(Color color) throws RemoteException;

    Inventory getInventory() throws RemoteException;

    String getUsername() throws RemoteException;
}
