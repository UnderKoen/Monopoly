package nl.UnderKoen.monopoly.common.interfaces;

import nl.UnderKoen.monopoly.common.interfaces.map.Map;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.NormalStreet;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Under_Koen on 07-06-17.
 */
public interface Game extends Remote {
    void createMap() throws RemoteException;

    int getRound() throws RemoteException;

    void nextRound() throws RemoteException;

    void nextTurn() throws RemoteException;

    void start() throws RemoteException;

    Map getMap() throws RemoteException;

    void updateMap() throws RemoteException;

    List<Player> getPlayers() throws RemoteException;

    /**
     * ordered by order of turns
     */
    List<Player> getPlayersOrded() throws RemoteException;

    Player getTurn() throws RemoteException;

    void buildBuilding(Player player, NormalStreet street, int amount) throws RemoteException;

    void removeBuilding(Player player, NormalStreet street, int amount) throws RemoteException;

    void throwDices() throws RemoteException;

    void trade(UUID tradeKey, Player with) throws RemoteException;

    void addTrade(Player player, TradeInventory request, TradeInventory reward) throws RemoteException;

    void removeTrade(UUID key) throws RemoteException;

    Throw getLastThrow() throws RemoteException;

    void updateInventory() throws RemoteException;
}
