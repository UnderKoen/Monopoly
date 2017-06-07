package nl.UnderKoen.monopoly.common.interfaces.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.map.Corner;

/**
 * Created by Under_Koen on 06-06-17.
 */
public interface FreeParkingCorner extends Corner {
    double getJackpot();

    void setJackpot(double jackpot);

    double getStandardJackpot();

    void resetJackpot();

    @Override
    default StreetType getStreetType() {
        return StreetType.PARKING;
    }
}
