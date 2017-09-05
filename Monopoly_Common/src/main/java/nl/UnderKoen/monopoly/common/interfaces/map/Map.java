package nl.UnderKoen.monopoly.common.interfaces.map;

import nl.UnderKoen.monopoly.common.enumeration.StreetType;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.SpecialCardStreet;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.StationStreet;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.SupplyStreet;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.TaxStreet;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Under_Koen on 07-06-17.
 */
public interface Map extends Serializable {
    List<Town> getTowns();

    List<SpecialCardStreet> getSpecialCardStreets();

    List<TaxStreet> getTaxStreets();

    List<SupplyStreet> getSupplyStreets();

    List<StationStreet> getStationStreets();

    List<Corner> getCorners();

    List<Street> getOrderdStreets();

    List<Street> getStreets(StreetType streetType) throws RemoteException;

    Street getStreet(int id);

    void createMap();
}
