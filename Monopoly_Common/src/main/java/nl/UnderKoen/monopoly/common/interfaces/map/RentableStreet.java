package nl.UnderKoen.monopoly.common.interfaces.map;

/**
 * Created by Under_Koen on 31-05-17.
 */
public interface RentableStreet extends Street {
    double getBuyPrice();

    double getRentPrice();

    default double getMortgagePrice() {
        return  getBuyPrice()/2;
    }

    boolean isOnMortgage();

    void setMortgage(Boolean mortgage);
}