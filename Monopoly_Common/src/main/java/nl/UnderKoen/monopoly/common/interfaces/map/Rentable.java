package nl.UnderKoen.monopoly.common.interfaces.map;

import java.io.Serializable;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface Rentable extends Serializable {
    double getBuyPrice();

    double getRentPrice();

    default double getMortgagePrice() {
        return  getBuyPrice()/2;
    }

    boolean isOnMortgage();

    void setMortgage(Boolean mortgage);
}