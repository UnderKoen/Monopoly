package nl.UnderKoen.monopoly.server;

import nl.UnderKoen.monopoly.common.MonopolyStatics;
import nl.UnderKoen.monopoly.common.interfaces.Lobby;
import nl.UnderKoen.monopoly.server.controller.ServerLobbyController;
import nl.UnderKoen.monopoly.server.model.ServerLobby;

import java.io.File;
import java.io.FileOutputStream;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Under_Koen on 31-05-17.
 */
public class Server {

    private static Lobby lobby;

    public static void main(String[] args) throws Exception {
        File rmilog = new File("rmilog.latest");
        rmilog.delete();
        RemoteServer.setLog(new FileOutputStream(rmilog));

        ServerLobby lobby = new ServerLobby();
        ServerLobbyController lobbyController = new ServerLobbyController(lobby);
        lobby.setController(lobbyController);
        setLobby(lobby);

        Remote lobbySkeleton = UnicastRemoteObject.exportObject(new ServerLobby(), 0);

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind(MonopolyStatics.LOBBY_KEY, lobbySkeleton);

        System.out.println("Server online!");
    }

    public static Lobby getLobby() {
        return lobby;
    }

    public static void setLobby(Lobby lobby) {
        Server.lobby = lobby;
    }
}
