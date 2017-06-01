package nl.UnderKoen.monopoly.common.interfaces;

import javafx.scene.paint.Color;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Under_Koen on 01-06-17.
 */
public interface Lobby extends Remote {
    enum State {
        LOBBY, STARTING, IN_GAME
    }

    Player registerPlayer(String player) throws RemoteException;

    List<Player> getPlayers() throws RemoteException;

    void disconnect(Player pl) throws RemoteException;

    void setColor(Player pl, Color newColor) throws RemoteException;

    void startGame() throws RemoteException;
}
