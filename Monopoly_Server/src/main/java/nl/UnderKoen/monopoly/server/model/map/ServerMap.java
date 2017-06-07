package nl.UnderKoen.monopoly.server.model.map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import nl.UnderKoen.monopoly.common.enumeration.*;
import nl.UnderKoen.monopoly.common.interfaces.map.Corner;
import nl.UnderKoen.monopoly.common.interfaces.map.Map;
import nl.UnderKoen.monopoly.common.interfaces.map.Street;
import nl.UnderKoen.monopoly.common.interfaces.map.Town;
import nl.UnderKoen.monopoly.common.interfaces.map.streets.*;
import nl.UnderKoen.monopoly.server.Server;
import nl.UnderKoen.monopoly.server.model.map.streets.*;

import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.*;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class ServerMap implements Map {
    private static String getMapInfo() {

        StringBuilder result = new StringBuilder("");

        //Get file from resources folder
        ClassLoader classLoader = Server.class.getClassLoader();
        InputStream file = classLoader.getResourceAsStream("default/map.json");

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();

    }

    private static String getMapOrder() {

        StringBuilder result = new StringBuilder("");

        //Get file from resources folder
        ClassLoader classLoader = Server.class.getClassLoader();
        InputStream file = classLoader.getResourceAsStream("default/mapOrder.json");

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();

    }

    private List<Town> towns;
    private List<SpecialCardStreet> specialCardStreets;
    private List<TaxStreet> taxStreets;
    private List<SupplyStreet> supplyStreets;
    private List<StationStreet> stationStreets;
    private List<Corner> corners;
    private List<Street> ordered;

    @Override
    public List<Town> getTowns() {
        return towns;
    }

    @Override
    public List<SpecialCardStreet> getSpecialCardStreets() {
        return specialCardStreets;
    }

    @Override
    public List<TaxStreet> getTaxStreets() {
        return taxStreets;
    }

    @Override
    public List<SupplyStreet> getSupplyStreets() {
        return supplyStreets;
    }

    @Override
    public List<StationStreet> getStationStreets() {
        return stationStreets;
    }

    @Override
    public List<Corner> getCorners() {
        return corners;
    }

    @Override
    public List<Street> getOrderdStreets() {
        return ordered;
    }

    @Override
    public List<Street> getStreets(StreetType streetType) throws RemoteException {
        List<Street> streets = new ArrayList<>(getOrderdStreets());
        streets.removeIf(street -> street.getStreetType() != streetType);
        return streets;
    }

    @Override
    public void createMap() {
        ordered = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonObject mapInfo = parser.parse(getMapInfo()).getAsJsonObject();
        JsonObject mapOrder = parser.parse(getMapOrder()).getAsJsonObject();

        //Towns
        towns = new ArrayList<>();

        for (JsonElement t : mapInfo.getAsJsonArray("towns")) {
            JsonObject town = t.getAsJsonObject();
            //TODO
        }

        //Stations
        stationStreets = new ArrayList<>();

        JsonObject stationsInfo = mapInfo.getAsJsonObject("stations");
        for (StationType stationType : StationType.values()) {
            ServerStationStreet stationStreet = new ServerStationStreet();
            stationStreet.setMortgage(false);
            stationStreet.setStationType(stationType);
            stationStreet.setBuyPrice(stationsInfo.getAsJsonObject(stationType.name()).get("price").getAsDouble());
            java.util.Map<Integer, Double> prices = new HashMap<>();
            prices.put(1, stationsInfo.getAsJsonObject("rent").get("1").getAsDouble());
            prices.put(2, stationsInfo.getAsJsonObject("rent").get("2").getAsDouble());
            prices.put(3, stationsInfo.getAsJsonObject("rent").get("3").getAsDouble());
            prices.put(4, stationsInfo.getAsJsonObject("rent").get("4").getAsDouble());
            stationStreet.setPrices(prices);
            stationStreets.add(stationStreet);
        }

        //Taxes
        taxStreets = new ArrayList<>();

        JsonObject taxesInfo = mapInfo.getAsJsonObject("taxes");
        for (TaxType taxType : TaxType.values()) {
            ServerTaxStreet taxStreet = new ServerTaxStreet();
            taxStreet.setTaxType(taxType);
            taxStreet.setTaxPrice(taxesInfo.getAsJsonObject(taxType.name()).get("price").getAsDouble());
            taxStreets.add(taxStreet);
        }

        //Supplies
        supplyStreets = new ArrayList<>();

        JsonObject suppliesInfo = mapInfo.getAsJsonObject("supplies");
        for (SupplyType supplyType : SupplyType.values()) {
            ServerSupplyStreet supplyStreet = new ServerSupplyStreet();
            supplyStreet.setMortgage(false);
            supplyStreet.setSupplyType(supplyType);
            supplyStreet.setBuyPrice(suppliesInfo.getAsJsonObject(supplyType.name()).get("price").getAsDouble());
            java.util.Map<Integer, Double> prices = new HashMap<>();
            prices.put(1, suppliesInfo.getAsJsonObject("rent").get("1").getAsDouble());
            prices.put(2, suppliesInfo.getAsJsonObject("rent").get("2").getAsDouble());
            supplyStreet.setPrices(prices);
            supplyStreets.add(supplyStreet);
        }

        //SpecialCardStreets
        specialCardStreets = new ArrayList<>();

        JsonObject specialCardsInfo = mapInfo.getAsJsonObject("special");
        for (SpecialCardType specialCardType : SpecialCardType.values()) {
            ServerSpecialCardStreet specialCardStreet = new ServerSpecialCardStreet();
            specialCardStreet.setSpecialCardType(specialCardType);
            //TODO specialCardStreet.setCards();
            specialCardStreets.add(specialCardStreet);
        }

        //Corners
        corners = new ArrayList<>();
        JsonObject CornerInfo = mapInfo.getAsJsonObject("corners");

        //  StartCorner
        JsonObject StartInfo = CornerInfo.getAsJsonObject("START");
        ServerStartCorner startCorner = new ServerStartCorner();
        startCorner.setPassReward(StartInfo.get("pass").getAsDouble());
        startCorner.setHitReward(StartInfo.get("hit").getAsDouble());
        corners.add(startCorner);

        //  JailCorner
        JsonObject jailCornerInfo = CornerInfo.getAsJsonObject("JAIL");
        ServerJailCorner jailCorner = new ServerJailCorner();
        jailCorner.setPrisonLeavePrice(jailCornerInfo.get("leave").getAsDouble());
        corners.add(jailCorner);

        //  FreeParkingCorner
        JsonObject parkingInfo = CornerInfo.getAsJsonObject("PARKING");
        ServerFreeParkingCorner freeParkingCorner = new ServerFreeParkingCorner();
        freeParkingCorner.setStandardJackpot(parkingInfo.get("standardJackpot").getAsDouble());
        corners.add(freeParkingCorner);

        //  VisitJailCorner
        ServerVisitJailCorner visitJailCorner = new ServerVisitJailCorner();
        corners.add(visitJailCorner);

        //Street order
        Iterator<Town> townsIT = towns.iterator();
        Iterator<NormalStreet> remainingIT = new ArrayList<NormalStreet>().iterator();

        for (int i = 0; i < mapOrder.get("size").getAsInt(); i++) {
            switch (mapOrder.get(Integer.toString(i)).getAsString()) {
                case "START":
                    List<Corner> corners2 = new ArrayList<>(corners);
                    corners2.removeIf(street -> street.getStreetType() != StreetType.START);
                    Street street1 = corners2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "JAIL":
                    corners2 = new ArrayList<>(corners);
                    corners2.removeIf(street -> street.getStreetType() != StreetType.JAIL);
                    street1 = corners2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "PARKING":
                    corners2 = new ArrayList<>(corners);
                    corners2.removeIf(street -> street.getStreetType() != StreetType.PARKING);
                    street1 = corners2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "VISIT":
                    corners2 = new ArrayList<>(corners);
                    corners2.removeIf(street -> street.getStreetType() != StreetType.VISIT);
                    street1 = corners2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "STREET":
                    if (!remainingIT.hasNext()) {
                        remainingIT = townsIT.next().getStreets().iterator();
                    }
                    street1 = remainingIT.next();
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "STATION_NORTH":
                    List<StationStreet> stationStreets2 = new ArrayList<>(stationStreets);
                    stationStreets2.removeIf(street -> street.getStationType() != StationType.NORTH);
                    street1 = stationStreets2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "STATION_EAST":
                    stationStreets2 = new ArrayList<>(stationStreets);
                    stationStreets2.removeIf(street -> street.getStationType() != StationType.EAST);
                    street1 = stationStreets2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "STATION_SOUTH":
                    stationStreets2 = new ArrayList<>(stationStreets);
                    stationStreets2.removeIf(street -> street.getStationType() != StationType.SOUTH);
                    street1 = stationStreets2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "STATION_WEST":
                    stationStreets2 = new ArrayList<>(stationStreets);
                    stationStreets2.removeIf(street -> street.getStationType() != StationType.WEST);
                    street1 = stationStreets2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "WATER":
                    List<SupplyStreet> supplyStreets2 = new ArrayList<>(supplyStreets);
                    supplyStreets2.removeIf(street -> street.getSupplyType() != SupplyType.WATER);
                    street1 = supplyStreets2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "ELECTRICITY":
                    supplyStreets2 = new ArrayList<>(supplyStreets);
                    supplyStreets2.removeIf(street -> street.getSupplyType() != SupplyType.ELECTRICITY);
                    street1 = supplyStreets2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "CHANCE":
                    List<SpecialCardStreet> specialCardStreets2 = new ArrayList<>(specialCardStreets);
                    specialCardStreets2.removeIf(street -> street.getSpecialCardType() != SpecialCardType.CHANCE);
                    street1 = specialCardStreets2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "COMMUNITY_CHEST":
                    specialCardStreets2 = new ArrayList<>(specialCardStreets);
                    specialCardStreets2.removeIf(street -> street.getSpecialCardType() != SpecialCardType.COMMUNITY_CHEST);
                    street1 = specialCardStreets2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "INCOME_TAX":
                    List<TaxStreet> taxStreets2 = new ArrayList<>(taxStreets);
                    taxStreets2.removeIf(street -> street.getTaxType() != TaxType.INCOME);
                    street1 = taxStreets2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
                case "LUXURY_TAX":
                    taxStreets2 = new ArrayList<>(taxStreets);
                    taxStreets2.removeIf(street -> street.getTaxType() != TaxType.LUXURY);
                    street1 = taxStreets2.get(0);
                    street1.setId(i);
                    ordered.add(street1);
                    break;
            }
        }
    }
}
