package nl.UnderKoen.monopoly.entities;

import java.util.List;

/**
 * Created by Under_Koen on 22-05-17.
 */
public interface Inventory {
    long getCash();

    List<Street> getStreets();
}
