package nl.UnderKoen.monopoly.server.model;

import nl.UnderKoen.monopoly.common.interfaces.Inventory;
import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.interfaces.map.Street;
import nl.UnderKoen.monopoly.common.utils.Color;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class ServerPlayer implements Player {
    private String username;
    private Color color;
    private Inventory inventory;
    private Street current;

    public ServerPlayer(String username) {
        this.username = username;
        try {
            this.inventory = (Inventory) UnicastRemoteObject.exportObject(new ServerInventory(), 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isOnStreet(Street street) {
        return street == current;
    }

    @Override
    public Street getStreetStandingOn() {
        return current;
    }

    @Override
    public void setStreetStandingOn(Street street) throws RemoteException {
        current = street;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
