package nl.UnderKoen.monopoly.common.interfaces;

import nl.UnderKoen.monopoly.common.interfaces.map.OwnableStreet;

import java.util.List;

/**
 * Created by Under_Koen on 07-06-17.
 */
public interface TradeInventory {
    double getMoney();

    List<OwnableStreet> getStreets();
}
