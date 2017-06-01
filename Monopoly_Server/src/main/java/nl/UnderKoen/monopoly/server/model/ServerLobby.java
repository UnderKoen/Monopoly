package nl.UnderKoen.monopoly.server.model;

import javafx.scene.paint.Color;
import nl.UnderKoen.monopoly.common.interfaces.Lobby;
import nl.UnderKoen.monopoly.common.interfaces.Player;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Under_Koen on 01-06-17.
 */
public class ServerLobby implements Lobby {
    @Override
    public Player registerPlayer(String player) throws RemoteException {
        return null;
    }

    @Override
    public List<Player> getPlayers() throws RemoteException {
        return null;
    }

    @Override
    public void disconnect(Player pl) throws RemoteException {

    }

    @Override
    public void setColor(Player pl, Color newColor) throws RemoteException {

    }

    @Override
    public void startGame() throws RemoteException {

    }
}
