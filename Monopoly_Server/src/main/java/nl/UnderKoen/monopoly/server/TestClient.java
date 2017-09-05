package nl.UnderKoen.monopoly.server;

import nl.UnderKoen.monopoly.common.MonopolyStatics;
import nl.UnderKoen.monopoly.common.interfaces.Game;
import nl.UnderKoen.monopoly.common.interfaces.Lobby;
import nl.UnderKoen.monopoly.common.interfaces.map.Map;
import nl.UnderKoen.monopoly.common.utils.Color;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class TestClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(1099);
        Lobby lobby = (Lobby) registry.lookup(MonopolyStatics.LOBBY_KEY);
        lobby.registerPlayer("Under_Koen").setColor(Color.BLUE);
        lobby.registerPlayer("Staafjes").setColor(Color.BROWN);
        lobby.startGame();
        Game game = lobby.getGame();
        Map map = game.getMap();
    }
}