package nl.UnderKoen.monopoly.entities;


/**
 * Created by Under_Koen on 22-05-17.
 */
public interface Street {

    String getName();

    int getColor();

    Category getCategory();

    int getPrice();

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
        TAXES
    }
}