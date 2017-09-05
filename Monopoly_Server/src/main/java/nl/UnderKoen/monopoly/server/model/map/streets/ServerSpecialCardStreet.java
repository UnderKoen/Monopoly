package nl.UnderKoen.monopoly.server.model.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.SpecialCardType;
import nl.UnderKoen.monopoly.common.interfaces.Card;
import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.SpecialCardStreet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class ServerSpecialCardStreet implements SpecialCardStreet {
    //Street
    private int id;
    private List<Player> standing = new ArrayList<>();

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean isStanding(Player player) {
        return false;
    }

    @Override
    public List<Player> getPlayersStanding() {
        return standing;
    }

    @Override
    public void addPlayerStanding(Player player) {
        this.standing.add(player);
    }

    @Override
    public void removePlayerStanding(Player player) {
        standing.remove(player);
    }

    //SpecialCardStreet
    private SpecialCardType specialCardType;
    private List<Card> cards;

    @Override
    public SpecialCardType getSpecialCardType() {
        return specialCardType;
    }

    public void setSpecialCardType(SpecialCardType specialCardType) {
        this.specialCardType = specialCardType;
    }

    @Override
    public Card getRandomCard() {
        return cards.get(new Random().nextInt(cards.size()));
    }

    @Override
    public void removeCard(Card card) {
        cards.remove(card);
    }

    @Override
    public List<Card> getAllCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCards(Card card) {
        if (cards == null) cards = new ArrayList<>();
        cards.add(card);
    }
}
