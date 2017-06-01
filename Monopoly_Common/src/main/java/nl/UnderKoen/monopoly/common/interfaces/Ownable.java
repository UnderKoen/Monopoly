package nl.UnderKoen.monopoly.common.interfaces;

import java.io.Serializable;

/**
 * Created by Under_Koen on 31-05-17.
 */
    public interface Ownable extends Serializable {
    Player getOwner();

    void setOwner(Player player);

    boolean hasOwner();

    boolean isOwner(Player player);
}