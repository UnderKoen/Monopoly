package nl.UnderKoen.monopoly.client.view.elements;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import nl.UnderKoen.monopoly.client.builders.TownBuilder;
import nl.UnderKoen.monopoly.client.entities.Street;
import nl.UnderKoen.monopoly.client.entities.Town;
import nl.UnderKoen.monopoly.client.entities.impl.StreetImpl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Under_Koen on 28-05-17.
 */
public class MapElement extends StackPane {
    private List<Street> streets;

    public MapElement() {
        setup();
        int x = 250;
        int y = 305-40;
        int rot = 0;
        int time = 0;
        for (Street street : streets) {
            switch (time) {
                case 0:
                    if (street.isCorner()) {
                        rot += 90;
                        x -= 65;
                        break;
                    }
                    x -= 50;
                    break;
                case 1:
                    if (street.isCorner()) {
                        rot += 90;
                        y -= 65;
                        break;
                    }
                    y -= 50;
                    break;
                case 2:
                    if (street.isCorner()) {
                        rot += 90;
                        x += 65;
                        break;
                    }
                    x += 50;
                    break;
                case 3:
                    if (street.isCorner()) {
                        rot += 90;
                        y += 65;
                        break;
                    }
                    y += 50;
                    break;
            }
            StreetElement streetElement = new StreetElement(street);
            getChildren().add(streetElement);
            streetElement.setRotate(rot);
            streetElement.setTranslateX(x);
            streetElement.setTranslateY(y);
            setAlignment(streetElement, Pos.CENTER);
            switch (time) {
                case 0:
                    if (street.isCorner()) {
                        time++;
                        y -= 15;
                        break;
                    }
                    break;
                case 1:
                    if (street.isCorner()) {
                        time++;
                        x += 15;
                        break;
                    }
                    break;
                case 2:
                    if (street.isCorner()) {
                        time++;
                        y += 15;
                        break;
                    }
                    break;
            }
        }
        //setMinSize(610, 610);
        maxHeightProperty().bind(scaleYProperty().multiply(610));
        maxWidthProperty().bind(scaleXProperty().multiply(610));
        //setMaxSize(510, 510);
    }

    private String getMapInfo() {

        StringBuilder result = new StringBuilder("");

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream file = classLoader.getResourceAsStream("assets/map.json");

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

    private void setup() {
        streets = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonObject mapInfo = parser.parse(getMapInfo()).getAsJsonObject();

        //Towns
        List<Town> towns = new ArrayList<>();

        for (JsonElement t : mapInfo.getAsJsonArray("towns")) {
            JsonObject town = t.getAsJsonObject();
            TownBuilder townBuilder = new TownBuilder();
            townBuilder.setName(town.get("name").getAsString());
            townBuilder.setColor(Color.web(town.get("color").getAsString()));
            for (JsonElement s : town.get("map").getAsJsonArray()) {
                JsonObject street = s.getAsJsonObject();
                townBuilder.addStreet(street.get("name").getAsString(), street.get("price").getAsDouble());
            }
            towns.add(townBuilder.build());
        }

        //Stations
        List<Street> stations = new ArrayList<>();
        String[] sides = {"SOUTH", "WEST", "NORTH", "EAST"};

        JsonObject stationsInfo = mapInfo.getAsJsonObject("stations");
        for (String side : sides) {
            JsonObject stationInfo = stationsInfo.getAsJsonObject(side);
            StreetImpl station = new StreetImpl();
            station.setCategory(Street.Category.STATION);
            station.setName(stationInfo.get("name").getAsString());
            station.setPrice(stationInfo.get("price").getAsDouble());
            stations.add(station);
        }

        //Taxes
        List<Street> taxes = new ArrayList<>();
        String[] taxesType = {"INCOME_TAX", "LUXURY_TAX"};

        JsonObject taxesInfo = mapInfo.getAsJsonObject("taxes");
        for (String taxType : taxesType) {
            JsonObject taxInfo = taxesInfo.getAsJsonObject(taxType);
            StreetImpl tax = new StreetImpl();
            if (taxType.contentEquals("INCOME_TAX")) {
                tax.setCategory(Street.Category.INCOME_TAX);
            } else {
                tax.setCategory(Street.Category.LUXURY_TAX);
            }
            tax.setName(taxInfo.get("name").getAsString());
            tax.setPrice(taxInfo.get("price").getAsDouble());
            taxes.add(tax);
        }

        //Supplies
        List<Street> supplies = new ArrayList<>();
        String[] suppliesType = {"ELECTRICITY", "WATER_WORKS"};

        JsonObject suppliesInfo = mapInfo.getAsJsonObject("supplies");
        for (String supplyType : suppliesType) {
            JsonObject supplyInfo = suppliesInfo.getAsJsonObject(supplyType);
            StreetImpl supply = new StreetImpl();
            if (supplyType.contentEquals("ELECTRICITY")) {
                supply.setCategory(Street.Category.ELECTRICITY);
            } else {
                supply.setCategory(Street.Category.WATER_WORKS);
            }
            supply.setName(supplyInfo.get("name").getAsString());
            supply.setPrice(supplyInfo.get("price").getAsDouble());
            supplies.add(supply);
        }

        //Specials
        List<Street> specials = new ArrayList<>();
        String[] specialsType = {"CHANCE", "COMMUNITY_CHEST"};

        JsonObject specialsInfo = mapInfo.getAsJsonObject("special");
        for (String specialType : specialsType) {
            JsonObject specialInfo = specialsInfo.getAsJsonObject(specialType);
            StreetImpl special = new StreetImpl();
            if (specialType.contentEquals("CHANCE")) {
                special.setCategory(Street.Category.CHANCE);
            } else {
                special.setCategory(Street.Category.COMMUNITY_CHEST);
            }
            special.setName(specialInfo.get("name").getAsString());
            specials.add(special);
        }

        //Corners
        List<Street> corners = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            StreetImpl corner = new StreetImpl();
            corner.setCorner(true);
            switch (i) {
                case 0:
                    corner.setCategory(Street.Category.JAIL);
                    break;
                case 1:
                    corner.setCategory(Street.Category.PARKING);
                    break;
                case 2:
                    corner.setCategory(Street.Category.VISIT);
                    break;
                case 3:
                    corner.setCategory(Street.Category.START);
                    JsonObject startInfo = mapInfo.get("corners").getAsJsonObject().getAsJsonObject("START");
                    corner.setPrice(startInfo.get("pass").getAsDouble());
                    break;
            }
            corners.add(corner);
        }

        //Street order
        JsonObject orderInfo = mapInfo.getAsJsonObject("order");
        for (int i = 0; i < 40; i++) {
            switch (orderInfo.get(Integer.toString(i)).getAsString()) {
                case "START":
                    streets.add(corners.get(3));
                    break;
                case "JAIL":
                    streets.add(corners.get(0));
                    break;
                case "PARKING":
                    streets.add(corners.get(1));
                    break;
                case "VISIT":
                    streets.add(corners.get(2));
                    break;
                case "STREET":
                    if (towns.get(0).getStreets().size() == 0) {
                        towns.remove(0);
                    }
                    streets.add(towns.get(0).getStreets().remove(0));
                    break;
                case "STATION":
                    streets.add(stations.remove(0));
                    break;
                case "WATER_WORKS":
                    streets.add(supplies.get(1));
                    break;
                case "ELECTRICITY":
                    streets.add(supplies.get(0));
                    break;
                case "CHANCE":
                    streets.add(specials.get(0));
                    break;
                case "COMMUNITY_CHEST":
                    streets.add(specials.get(1));
                    break;
                case "INCOME_TAX":
                    streets.add(taxes.get(0));
                    break;
                case "LUXURY_TAX":
                    streets.add(taxes.get(1));
                    break;
            }
        }
    }
}
