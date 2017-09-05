package nl.UnderKoen.monopoly.common.interfaces.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.map.OwnableStreet;
import nl.UnderKoen.monopoly.common.interfaces.map.RentableStreet;
import nl.UnderKoen.monopoly.common.interfaces.map.Town;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface NormalStreet extends OwnableStreet, RentableStreet {

    String getName();

    /**
     * Times 5 for hotel price.
     */
    double getHousePrice();

    /**
     * When 5 it is a hotel.
     */
    int getHouses();

    void setHouses(int houses);

    Town getTown();

    boolean hasFullTown();

    /**
     * Get the price for numberOfHouses at the street
     * 5 is a hotel
     */
    double getPrice(int numberOfHouses);

    @Override
    default StreetType getStreetType() {
        return StreetType.NORMAL;
    }
}
