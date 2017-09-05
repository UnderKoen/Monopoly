package nl.UnderKoen.monopoly.server.controller;

import nl.UnderKoen.monopoly.common.enumeration.GameState;
import nl.UnderKoen.monopoly.common.interfaces.*;
import nl.UnderKoen.monopoly.common.interfaces.map.Map;
import nl.UnderKoen.monopoly.common.interfaces.map.OwnableStreet;
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

    ServerTurnController turnController;

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
        turnController = new ServerTurnController(this);

        if (players != null) {
            setPlayers(players);
            players.sort(Comparator.comparingInt(Object::hashCode));
        }
        System.out.println("\tRandomized players");

        for (Player player: getPlayers()) {
            try {
                player.getInventory().setMoney(getBeginMoney());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\tGiven players money");
    }

    @Override
    public void start() throws RemoteException {
        System.out.println("\tStarted game!");
        if (state == null) {
            state = GameState.INIT;
        }

        nextTurn();
    }

    @Override
    public Map getMap() throws RemoteException {
        return map;
    }

    public void setMap(ServerMap map) {
        this.map = map;
    }

    @Override
    public void createMap() throws RemoteException {
        map.createMap();
    }

    @Override
    public void updateMap() throws RemoteException {
        //TODO update client
    }

    @Override
    public GameState getState() {
        return this.state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    @Override
    public int getRound() throws RemoteException {
        return round;
    }

    @Override
    public void nextRound() throws RemoteException {
        round++;
    }

    public int newTurn() {
        return ++turn - 1;
    }

    public void resetTurn() {
        turn = 0;
    }

    @Override
    public Player getTurn() throws RemoteException {
        return getPlayersOrded().get(0);
    }

    @Override
    public void nextTurn() throws RemoteException {
        lastThrow = null;
        turnController.nextTurn();
    }

    @Override
    public List<Player> getPlayersOrded() {
        List<Player> orded = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            orded.add(players.get((i + turn) % players.size()));
        }
        return orded;
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public void buildHouses(Player player, NormalStreet street, int amount) throws RemoteException {
        //TODO mapController
    }

    @Override
    public void removeHouses(Player player, NormalStreet street, int amount) throws RemoteException {
        //TODO mapController
    }

    @Override
    public void throwDices() throws RemoteException {
        ServerThrowController diceController = new ServerThrowController(this);
        lastThrow = diceController.getThrow();
        //TODO Update clients
    }

    @Override
    public void trade(UUID tradeKey, Player with) throws RemoteException {
        //TODO tradeController
    }

    @Override
    public void addTrade(Player player, TradeInventory request, TradeInventory reward) throws RemoteException {
        //TODO tradeController
    }

    @Override
    public void removeTrade(UUID key) throws RemoteException {
        //TODO tradeController
    }

    @Override
    public Throw getLastThrow() throws RemoteException {
        return lastThrow;
    }

    @Override
    public void updateInventory() throws RemoteException {
        //TODO update client
    }

    @Override
    public double getBeginMoney() {
        return beginMoney;
    }

    @Override
    public void buyStreet(OwnableStreet street, Player player) {
        //TODO shopController
    }

    @Override
    public void buyHouse(OwnableStreet street, Player player) {
        //TODO shopController
    }

    @Override
    public void sellHouse(OwnableStreet street, Player player) {
        //TODO shopController
    }
}
