package nl.UnderKoen.monopoly.server.controller;

import nl.UnderKoen.monopoly.common.interfaces.Game;
import nl.UnderKoen.monopoly.common.interfaces.Lobby;
import nl.UnderKoen.monopoly.common.interfaces.Lobby.State;
import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.utils.Color;
import nl.UnderKoen.monopoly.common.utils.Scheduler;
import nl.UnderKoen.monopoly.server.model.ServerPlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Under_Koen on 01-06-17.
 */
public class ServerLobbyController {

    private Lobby lobby;

    public ServerLobbyController(Lobby lobby) {
        this.lobby = lobby;
    }

    public void startGame() throws RemoteException {
        if (lobby.getState() != State.LOBBY) {
            lobby.setState(State.STARTING);
        }
        List<Player> playersReady = new ArrayList<>();
        List<Player> playersUnready = new ArrayList<>();
        for (Player player : lobby.getPlayers()) {
            if (player.getColor() != null) {
                playersReady.add(player);
            } else {
                playersUnready.add(player);
            }
        }
        if (playersReady.size() < 2) {
            for (Player pl : lobby.getPlayers()) {
                //TODO let player know that there are no other players
            }
            return;
        }
        List<Runnable> runs = new ArrayList<>();
        for (Player player : playersUnready) {
            runs.add(() -> {
                try {
                    lobby.getPlayers().remove(player);
                    //TODO let the client know that they have been kicked
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        }
        Scheduler.runAsyncdSync(runs);

        Game game = new ServerGame(lobby.getPlayers());
        game.createMap();
        startupGame(game);
        //TODO startupGame(game);
    }

    public void startupGame(Game game) throws RemoteException {
        Game gameSkeleton = (Game) UnicastRemoteObject.exportObject(game, 0);
        lobby.setState(State.IN_GAME);
        lobby.setGame(gameSkeleton);
        List<Runnable> runners = new ArrayList<>();
        for (Player pl : lobby.getPlayers()) {
            runners.add(() -> {
                try {
                    //TODO start the client
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        }
        Scheduler.runAsyncdSync(runners);
        Scheduler.runAsync(() -> {
            boolean hasCastException;
            do {
                hasCastException = false;
                try {
                    Thread.sleep(100L);
                    for (Player pl : gameSkeleton.getPlayers()) {
                        //TODO
                        //UpdateMap updateMap = pl.getUpdateable(UpdateMap.class);
                        //updateMap.testConnection();
                    }
                } catch (Exception ex) {
                    hasCastException = true;
                    break;
                }
            } while (hasCastException);
            try {
                gameSkeleton.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public Player registerPlayer(String username) throws RemoteException {
        switch (lobby.getState()) {
            case IN_GAME:
            case STARTING:
                for (Player player : lobby.getGame().getPlayers()) {
                    if (player.getUsername().equals(username)) {
                        return player;
                    }
                }
                break;
            case LOBBY:
                Player pl = (Player) UnicastRemoteObject.exportObject(new ServerPlayer(username), 0);
                Iterator<Player> playersIT = lobby.getPlayers().iterator();
                while (playersIT.hasNext()) {
                    Player player = playersIT.next();
                    try {
                        if (player.getUsername().equals(pl.getUsername())) {
                            System.out.printf("Kicking player %s for dube name\n", pl.getUsername());
                            playersIT.remove();
                        }
                    } catch (RemoteException ex) {
                    }
                }
                lobby.getPlayers().add(pl);
                System.out.printf("Player %s has joined!\n", pl.getUsername());
                return pl;
            default:
                break;
        }
        return null;
    }

    public void setColor(Player pl, Color newColor) throws RemoteException {
        switch (lobby.getState()) {
            case STARTING:
                break;
            case IN_GAME:
                break;
            case LOBBY:
                boolean freeColor = true;
                for (Player player : lobby.getPlayers()) {
                    if (player.getColor() == newColor && newColor != null) {
                        freeColor = false;
                    }
                }
                if (!freeColor) {
                    break;
                }
                System.out.printf("\t%s [%s] - new color = %s\n", pl.getUsername(), pl.getColor(), newColor);
                Color color = pl.getColor();
                pl.setColor(newColor);
                //TODO update clients to change color
        }
    }

    public boolean removePlayer(Player pl, boolean shouldRemove) throws RemoteException {
        lobby.setColor(pl, null);
        if (shouldRemove) {
            return lobby.getPlayers().remove(pl);
        }
        return true;
    }
}
