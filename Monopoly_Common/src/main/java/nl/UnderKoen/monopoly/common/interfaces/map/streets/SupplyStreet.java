package nl.UnderKoen.monopoly.common.interfaces.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.enumeration.SupplyType;
import nl.UnderKoen.monopoly.common.interfaces.map.OwnableStreet;
import nl.UnderKoen.monopoly.common.interfaces.map.Rentable;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface SupplyStreet extends OwnableStreet, Rentable {
    SupplyType getSupplyType();

    @Override
    default StreetType getStreetType() {
        return StreetType.SUPPLY;
    }
}
