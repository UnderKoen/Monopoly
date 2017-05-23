package nl.UnderKoen.monopoly.entities.impl;

import nl.UnderKoen.monopoly.entities.Inventory;
import nl.UnderKoen.monopoly.entities.Street;

import java.util.List;

/**
 * Created by D0an on 23-05-17.
 */
public class InventoryImpl implements Inventory {

    long cash;
    int freecards;
    List<Street> streets;

    @Override
    public long getCash() { return cash; }

    @Override
    public int getFreeCards() { return freecards; }

    @Override
    public List<Street> getStreets() { return streets; }

    public void setCash(long cash){ this.cash = cash; }

    public void setFreeCards(int freecards) { this.freecards = freecards; }

    public void setStreets(List<Street> streets) { this.streets = streets; }
}
