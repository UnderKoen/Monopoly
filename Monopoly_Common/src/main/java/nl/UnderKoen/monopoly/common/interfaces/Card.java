package nl.UnderKoen.monopoly.common.interfaces;

import nl.UnderKoen.monopoly.common.enumeration.SpecialCardType;

import java.io.Serializable;

/**
 * Created by Under_Koen on 02-06-17.
 */
public interface Card extends Serializable {
    CardAction getAction();

    SpecialCardType getType();

    void use();
}
