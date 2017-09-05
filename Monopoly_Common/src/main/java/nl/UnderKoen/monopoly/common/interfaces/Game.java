package nl.UnderKoen.monopoly.common.interfaces;

import nl.UnderKoen.monopoly.common.enumeration.GameState;
import nl.UnderKoen.monopoly.common.interfaces.map.Map;
import nl.UnderKoen.monopoly.common.interfaces.map.OwnableStreet;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.NormalStreet;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Under_Koen on 07-06-17.
 */
public interface Game extends Remote {
    void start() throws RemoteException;

    Map getMap() throws RemoteException;

    void createMap() throws RemoteException;

    void updateMap() throws RemoteException;

    GameState getState() throws RemoteException;

    int getRound() throws RemoteException;

    void nextRound() throws RemoteException;

    Player getTurn() throws RemoteException;

    void nextTurn() throws RemoteException;

    List<Player> getPlayersOrded() throws RemoteException;

    List<Player> getPlayers() throws RemoteException;

    void buildHouses(Player player, NormalStreet street, int amount) throws RemoteException;

    void removeHouses(Player player, NormalStreet street, int amount) throws RemoteException;

    void throwDices() throws RemoteException;

    void trade(UUID tradeKey, Player with) throws RemoteException;

    void addTrade(Player player, TradeInventory request, TradeInventory reward) throws RemoteException;

    void removeTrade(UUID key) throws RemoteException;

    Throw getLastThrow() throws RemoteException;

    void updateInventory() throws RemoteException;

    double getBeginMoney() throws RemoteException;

    void buyStreet(OwnableStreet street, Player player) throws RemoteException;

    void buyHouse(OwnableStreet street, Player player) throws RemoteException;

    void sellHouse(OwnableStreet street, Player player) throws RemoteException;
}
