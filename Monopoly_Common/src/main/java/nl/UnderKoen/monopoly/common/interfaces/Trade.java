package nl.UnderKoen.monopoly.common.interfaces;

import java.util.UUID;

/**
 * Created by Under_Koen on 07-06-17.
 */
public interface Trade {
    UUID getID();

    Player getPlayer();

    TradeInventory getRequest();

    TradeInventory getReward();
}
