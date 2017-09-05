package nl.UnderKoen.monopoly.server.model;

/**
 * Created by Under_Koen on 09-06-17.
 */
public class ServerDice {
    private int dice;

    public void throwDice() {
        dice = 1 + (int) (Math.random() * 6D);
    }

    public int getValue() {
        return dice;
    }
}
