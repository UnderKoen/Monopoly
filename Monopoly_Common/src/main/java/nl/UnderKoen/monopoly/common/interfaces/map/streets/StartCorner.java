package nl.UnderKoen.monopoly.common.interfaces.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.map.Corner;

/**
 * Created by Under_Koen on 06-06-17.
 */
public interface StartCorner extends Corner {

    double getOnPassReward();

    /**
     * @return the amount of money you get when you come on it
     */
    double getOnHitReward();

    @Override
    default StreetType getStreetType() {
        return StreetType.START;
    }
}
