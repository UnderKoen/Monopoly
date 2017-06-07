package nl.UnderKoen.monopoly.common.interfaces.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.StationType;
import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.map.OwnableStreet;
import nl.UnderKoen.monopoly.common.interfaces.map.Rentable;

/**
 * Created by Under_Koen on 02-06-17.
 */
public interface StationStreet extends OwnableStreet, Rentable {
    StationType getStationType();

    boolean hasOtherStations();

    int getOtherStations();

    double getPrice(int amountOfStations);

    @Override
    default StreetType getStreetType() {
        return StreetType.STATION;
    }
}