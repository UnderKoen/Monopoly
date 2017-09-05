package nl.UnderKoen.monopoly.server.controller;

import nl.UnderKoen.monopoly.common.interfaces.Throw;
import nl.UnderKoen.monopoly.server.model.ServerThrow;

/**
 * Created by Under_Koen on 09-06-17.
 */
public class ServerThrowController {
    private ServerGame controller;

    private Throw lastThrow;

    public ServerThrowController(ServerGame serverGame) {
        this.controller = serverGame;
        lastThrow = new ServerThrow();
        lastThrow.throwDice();
    }

    public Throw getThrow() {
        return lastThrow;
    }
}
