package nl.UnderKoen.monopoly.server.model;

import nl.UnderKoen.monopoly.common.enumeration.CardActionType;
import nl.UnderKoen.monopoly.common.interfaces.CardAction;
import nl.UnderKoen.monopoly.common.interfaces.Player;

/**
 * Created by Under_Koen on 08-08-17.
 */
public class ServerCardAction implements CardAction {
    CardActionType ActionType;

    @Override
    public CardActionType getActionType() {
        return ActionType;
    }

    public void setActionType(CardActionType actionType) {
        ActionType = actionType;
    }

    @Override
    public void run(Player player) {

    }
}
