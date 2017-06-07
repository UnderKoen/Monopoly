package nl.UnderKoen.monopoly.common.interfaces.map.streets;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.enumeration.TaxType;
import nl.UnderKoen.monopoly.common.interfaces.map.Street;

/**
 * Created by Under_Koen on 07-06-17.
 */
public interface TaxStreet extends Street {
    TaxType getTaxType();

    double getTaxPrice();

    @Override
    default StreetType getStreetType() {
        return StreetType.TAX;
    }
}
