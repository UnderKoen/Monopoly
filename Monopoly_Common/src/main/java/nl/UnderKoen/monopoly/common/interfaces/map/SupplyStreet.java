package nl.UnderKoen.monopoly.common.interfaces.map;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.enumeration.SupplyType;
import nl.UnderKoen.monopoly.common.interfaces.Ownable;
import nl.UnderKoen.monopoly.common.interfaces.Rentable;

import java.io.Serializable;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface SupplyStreet extends Street, Ownable, Rentable, Serializable {
    SupplyType getSupplyType();

    @Override
    default StreetType getStreetType() {
        return StreetType.SUPPLY;
    }
}
