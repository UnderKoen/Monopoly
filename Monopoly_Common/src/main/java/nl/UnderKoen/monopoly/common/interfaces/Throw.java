package nl.UnderKoen.monopoly.common.interfaces;

/**
 * Created by Under_Koen on 07-06-17.
 */
public interface Throw {
    void throwDice();

    int getValue();

    int getDiceLeft();

    int getDiceRight();

    boolean isDoubleThrowned();
}
