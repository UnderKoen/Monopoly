package nl.UnderKoen.monopoly.server.controller;

import nl.UnderKoen.monopoly.common.enumeration.GameState;
import nl.UnderKoen.monopoly.common.interfaces.*;
import nl.UnderKoen.monopoly.common.interfaces.map.Map;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.NormalStreet;
import nl.UnderKoen.monopoly.server.model.map.ServerMap;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class ServerGame implements Game {
    private List<Player> players;
    private List<Trade> trades = new ArrayList<>();
    private Map map = new ServerMap();
    private double beginMoney = 1500;
    private int round = -1;
    private int turn = -1;
    private Throw lastThrow;
    private GameState state;

    public ServerGame(List<Player> players) {
        System.out.println("Starting game!");
        this.players = players;
        //CONTROLLERS
        if (players != null) {
            setPlayers(players);
            players.sort(Comparator.comparingInt(Object::hashCode));
        }
        System.out.println("\tRandomized players");

    }

    @Override
    public void start() throws RemoteException {

    }

    @Override
    public Map getMap() throws RemoteException {
        return null;
    }

    @Override
    public void createMap() throws RemoteException {

    }

    @Override
    public void updateMap() throws RemoteException {

    }

    @Override
    public int getRound() throws RemoteException {
        return 0;
    }

    @Override
    public void nextRound() throws RemoteException {

    }

    @Override
    public Player getTurn() throws RemoteException {
        return null;
    }

    @Override
    public void nextTurn() throws RemoteException {

    }

    @Override
    public List<Player> getPlayers() throws RemoteException {
        return null;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public void buildHouses(Player player, NormalStreet street, int amount) throws RemoteException {

    }

    @Override
    public void removeHouses(Player player, NormalStreet street, int amount) throws RemoteException {

    }

    @Override
    public void throwDices() throws RemoteException {

    }

    @Override
    public void trade(UUID tradeKey, Player with) throws RemoteException {

    }

    @Override
    public void addTrade(Player player, TradeInventory request, TradeInventory reward) throws RemoteException {

    }

    @Override
    public void removeTrade(UUID key) throws RemoteException {

    }

    @Override
    public Throw getLastThrow() throws RemoteException {
        return null;
    }

    @Override
    public void updateInventory() throws RemoteException {

    }

    @Override
    public double getBeginMoney() {
        return 0;
    }
}
