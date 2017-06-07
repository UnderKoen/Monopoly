package nl.UnderKoen.monopoly.server;

import nl.UnderKoen.monopoly.common.interfaces.map.Map;
import nl.UnderKoen.monopoly.server.model.map.ServerMap;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class TestClient {
    public static void main(String[] args) throws Exception {
        //Registry registry = LocateRegistry.getRegistry(1099);
        //Lobby lobby = (Lobby) registry.lookup(MonopolyStatics.LOBBY_KEY);
        Map map = new ServerMap();
        map.createMap();
    }
}
