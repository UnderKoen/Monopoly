package nl.UnderKoen.monopoly.common.interfaces.map;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.Ownable;
import nl.UnderKoen.monopoly.common.interfaces.Rentable;

import java.io.Serializable;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface NormalStreet extends Street, Ownable, Rentable, Serializable {

    String getName();

    /**
     * Times 5 for hotel price.
     */
    double getHousePrice();

    /**
     * When 5 it is a hotel.
     */
    int getHouses();

    @Override
    default StreetType getStreetType() {
        return StreetType.NORMAL;
    }
}
