package nl.UnderKoen.monopoly.entities.impl;

import nl.UnderKoen.monopoly.entities.Inventory;
import nl.UnderKoen.monopoly.entities.Player;
import nl.UnderKoen.monopoly.entities.Street;

/**
 * Created by Under_Koen on 22-05-17.
 */
public class PlayerImpl implements Player {

    private String name;
    private Inventory inventory;
    private int freecards;

    @Override
    public String getName() {
        return name;
    }


    @Override
    public Inventory getInventory() {
        return inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
