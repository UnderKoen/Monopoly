package nl.UnderKoen.monopoly.common.enumeration;

import java.io.Serializable;

/**
 * Created by Under_Koen on 31-05-17.
 */
public enum StreetType implements Serializable {
    //Corners
    START, JAIL, VISIT, PARKING,

    //Ownable streets
    NORMAL, STATION, SUPPLY,

    //GetCard
    CHANCE, COMMUNITY_CHEST,

    //Tax
    INCOME_TAX, LUXURY_TAX
}
