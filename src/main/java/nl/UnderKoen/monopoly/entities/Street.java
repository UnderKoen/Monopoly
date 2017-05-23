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
        NORMAL,
        START,
        JAIL,
        VISIT,
        PARKING,
        CHANCE,
        TAXES,
        COMMUNITY_CHEST,
        STATION,
        WATER_WORKS,
        ELECTRICITY;
    }



}