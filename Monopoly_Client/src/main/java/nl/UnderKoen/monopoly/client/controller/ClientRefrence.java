package nl.UnderKoen.monopoly.client.controller;

import nl.UnderKoen.monopoly.common.interfaces.Player;

/**
 * Created by Under_Koen on 09-06-17.
 */
public class ClientRefrence {
    private static Player thePlayer;

    public static Player getThePlayer() {
        return thePlayer;
    }

    public static void setThePlayer(Player player) {
        ClientRefrence.thePlayer = player;
    }

    /*TODO public static void registerUpdateable(Updatable<?> updatable) {
        try {
            getThePlayer().registerUpdateable((Updatable<Lobby>) UnicastRemoteObject.exportObject(updatable, 0));
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }*/
}
