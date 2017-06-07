package nl.UnderKoen.monopoly.common.interfaces;

import nl.UnderKoen.monopoly.common.enumeration.CardActionType;

/**
 * Created by Under_Koen on 07-06-17.
 */
public interface CardAction {
    CardActionType getActionType();

    void run(Player player);
}
