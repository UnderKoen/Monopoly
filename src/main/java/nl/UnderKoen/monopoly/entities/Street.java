package nl.UnderKoen.monopoly.entities;

/**
 * Created by Under_Koen on 22-05-17.
 */
public interface Street {

    Boolean isCorner();

    String getName();

    Town getTown();

    Category getCategory();

    double getPrice();

    enum Category {
        START,
        JAIL,
        VISIT,
        PARKING,
        NORMAL,
        STATION,
        WATER_WORKS,
        ELECTRICITY,
        CHANCE,
        COMMUNITY_CHEST,
        INCOME_TAX,
        LUXURY_TAX
    }
}