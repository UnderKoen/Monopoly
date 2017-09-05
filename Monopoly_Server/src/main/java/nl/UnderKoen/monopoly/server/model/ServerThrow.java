package nl.UnderKoen.monopoly.server.model;

import nl.UnderKoen.monopoly.common.interfaces.Throw;

/**
 * Created by Under_Koen on 09-06-17.
 */
public class ServerThrow implements Throw {
    private ServerDice[] dices = new ServerDice[2];

    @Override
    public void throwDice() {
        for (int i = 0; i < dices.length; i++) {
            dices[i] = new ServerDice();
            dices[i].throwDice();
        }
    }

    @Override
    public int getValue() {
        int ret = 0;
        for (ServerDice dice : dices) {
            ret += dice.getValue();
        }
        return ret;
    }

    @Override
    public int getDiceLeft() {
        return dices[0].getValue();
    }

    @Override
    public int getDiceRight() {
        return dices[1].getValue();
    }

    @Override
    public boolean isDoubleThrowned() {
        return getDiceLeft() == getDiceRight();
    }
}
