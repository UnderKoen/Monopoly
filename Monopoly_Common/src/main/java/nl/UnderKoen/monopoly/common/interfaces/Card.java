package nl.UnderKoen.monopoly.common.interfaces;

import nl.UnderKoen.monopoly.common.enumeration.CardType;

/**
 * Created by Under_Koen on 02-06-17.
 */
public interface Card {
    CardAction getAction();

    CardType getType();

    void use();
}
