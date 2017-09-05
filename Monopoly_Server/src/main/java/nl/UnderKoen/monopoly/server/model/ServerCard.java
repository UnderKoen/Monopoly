package nl.UnderKoen.monopoly.server.model;

import nl.UnderKoen.monopoly.common.enumeration.SpecialCardType;
import nl.UnderKoen.monopoly.common.interfaces.Card;
import nl.UnderKoen.monopoly.common.interfaces.CardAction;

/**
 * Created by Under_Koen on 08-08-17.
 */
public class ServerCard implements Card {
    public CardAction cardAction;
    public SpecialCardType type;


    @Override
    public CardAction getAction() {
        return cardAction;
    }

    @Override
    public SpecialCardType getType() {
        return type;
    }

    @Override
    public void use() {

    }

    public void setCardAction(CardAction cardAction) {
        this.cardAction = cardAction;
    }

    public void setType(SpecialCardType type) {
        this.type = type;
    }
}
