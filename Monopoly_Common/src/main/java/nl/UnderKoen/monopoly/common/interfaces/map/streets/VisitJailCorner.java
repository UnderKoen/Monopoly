package nl.UnderKoen.monopoly.common.interfaces.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.map.Corner;

/**
 * Created by Under_Koen on 06-06-17.
 */
public interface VisitJailCorner extends Corner {
    @Override
    default StreetType getStreetType() {
        return StreetType.VISIT;
    }
}
