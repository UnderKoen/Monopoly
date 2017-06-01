package nl.UnderKoen.monopoly.server;

import nl.UnderKoen.monopoly.common.MonopolyStatics;
import nl.UnderKoen.monopoly.common.interfaces.Lobby;
import nl.UnderKoen.monopoly.server.model.ServerLobby;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Under_Koen on 31-05-17.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        Remote svr = UnicastRemoteObject.exportObject(new ServerLobby(), 0);

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind(MonopolyStatics.LOBBY_KEY, svr);

        Lobby obj = (Lobby) registry.lookup(MonopolyStatics.LOBBY_KEY);
        while (true) {

        }
    }
}
