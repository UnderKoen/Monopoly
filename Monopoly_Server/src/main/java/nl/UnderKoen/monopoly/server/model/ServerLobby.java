package nl.UnderKoen.monopoly.server.model;

import nl.UnderKoen.monopoly.common.enumeration.Color;
import nl.UnderKoen.monopoly.common.interfaces.Game;
import nl.UnderKoen.monopoly.common.interfaces.Lobby;
import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.server.controller.ServerLobbyController;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Under_Koen on 01-06-17.
 */
public class ServerLobby implements Lobby {
    protected final List<Player> players = new ArrayList<>();
    private State state = State.LOBBY;
    private Game game;
    private ServerLobbyController controller;

    public void setController(ServerLobbyController controller) {
        this.controller = controller;
    }

    @Override
    public Game getGame() throws RemoteException {
        return game;
    }

    @Override
    public void setGame(Game game) throws RemoteException {
        this.game = game;
    }

    @Override
    public void setState(State state) throws RemoteException {
        this.state = state;
    }

    @Override
    public State getState() throws RemoteException {
        return state;
    }

    @Override
    public Player registerPlayer(String playerName) throws RemoteException {
        return controller.registerPlayer(playerName);
    }

    @Override
    public List<Player> getPlayers() throws RemoteException {
        return players;
    }

    @Override
    public void disconnect(Player pl) throws RemoteException {
        boolean removed = controller.removePlayer(pl, true);
        System.out.printf("Player %s has %s logged off.\n", pl.getUsername(),
                removed ? "succesfully" : "unsuccesfully");
    }

    @Override
    public void setColor(Player pl, Color newColor) throws RemoteException {
        controller.setColor(pl, newColor);
    }

    @Override
    public void startGame() throws RemoteException {
        controller.startGame();
    }
}
