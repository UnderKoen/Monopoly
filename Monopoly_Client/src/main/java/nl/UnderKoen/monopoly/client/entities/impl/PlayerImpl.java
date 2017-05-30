package nl.UnderKoen.monopoly.client.entities.impl;

import nl.UnderKoen.monopoly.client.entities.Inventory;
import nl.UnderKoen.monopoly.client.entities.Player;

/**
 * Created by Under_Koen on 22-05-17.
 */
public class PlayerImpl implements Player {

    private String name;
    private Inventory inventory;

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
