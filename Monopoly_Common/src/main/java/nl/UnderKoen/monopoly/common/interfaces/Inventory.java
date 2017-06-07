package nl.UnderKoen.monopoly.common.interfaces;

import nl.UnderKoen.monopoly.common.interfaces.map.OwnableStreet;
import nl.UnderKoen.monopoly.common.interfaces.map.Street;
import nl.UnderKoen.monopoly.common.interfaces.map.Town;

import java.util.List;

/**
 * Created by Under_Koen on 02-06-17.
 */
public interface Inventory {
    boolean hasStreet(Street street);

    List<OwnableStreet> getStreets();

    List<Town> getFullTowns();

    double getMoney();

    void setMoney(double money);

    void addMoney(double money);

    void removeMoney(double money);
}
