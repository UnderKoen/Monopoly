package nl.UnderKoen.monopoly.common.interfaces.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.SpecialCardType;
import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.Card;
import nl.UnderKoen.monopoly.common.interfaces.map.Street;

import java.util.List;

/**
 * Created by Under_Koen on 07-06-17.
 */
public interface SpecialCardStreet extends Street {
    SpecialCardType getSpecialCardType();

    Card getRandomCard();

    void removeCard(Card card);

    List<Card> getAllCards();

    @Override
    default StreetType getStreetType() {
        return StreetType.SPECIAL_CARD;
    }
}
