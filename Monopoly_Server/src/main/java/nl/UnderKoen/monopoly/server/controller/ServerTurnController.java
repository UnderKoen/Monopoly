package nl.UnderKoen.monopoly.server.controller;

import nl.UnderKoen.monopoly.common.enumeration.GameState;

import java.rmi.RemoteException;

/**
 * Created by Under_Koen on 09-06-17.
 */
public class ServerTurnController {
    private ServerGame controller;

    public ServerTurnController(ServerGame serverGame) {
        this.controller = serverGame;
    }

    public void nextTurn() throws RemoteException {
        if (controller.newTurn() >= controller.getPlayers().size() - 1) {
            controller.resetTurn();
            controller.nextRound();
            if (controller.getState() == GameState.INIT && controller.getRound() == 1) {
                controller.setState(GameState.IN_GAME);
            }
        }
        switch (controller.getState()) {
            case END:
                break;
            case INIT:
                //TODO
                break;
            case IN_GAME:
                onTurn();
                break;
        }
    }

    public void onTurn() {
        try {
            if (controller.getState() != GameState.IN_GAME) {
                return;
            }
            System.out.println(controller.getTurn().getUsername() + "'s turn is now.");
            //TODO client shit
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
