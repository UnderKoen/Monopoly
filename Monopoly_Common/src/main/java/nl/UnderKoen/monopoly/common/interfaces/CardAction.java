package nl.UnderKoen.monopoly.common.interfaces;

import nl.UnderKoen.monopoly.common.enumeration.CardActionType;

import java.io.Serializable;

/**
 * Created by Under_Koen on 07-06-17.
 */
public interface CardAction extends Serializable {
    CardActionType getActionType();

    void run(Player player);
}
