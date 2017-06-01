package nl.UnderKoen.monopoly.common.interfaces;

import java.io.Serializable;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface Rentable extends Serializable {
    double getBuyPrice();

    double getRentPrice();

    boolean isOnMortgage();

    void setMortgage(Boolean mortgage);
}