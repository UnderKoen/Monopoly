package nl.UnderKoen.monopoly.common.interfaces.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.StationType;
import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.Player;
import nl.UnderKoen.monopoly.common.interfaces.map.OwnableStreet;
import nl.UnderKoen.monopoly.common.interfaces.map.Rentable;

/**
 * Created by Under_Koen on 02-06-17.
 */
public interface StationStreet extends OwnableStreet, Rentable {
    StationType getStationType();

    /**
     * @return the amount of other station the player has
     */
    int hasOtherStations(Player player);

    @Override
    default StreetType getStreetType() {
        return StreetType.STATION;
    }
}