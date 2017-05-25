package nl.UnderKoen.monopoly.view.scenes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import nl.UnderKoen.monopoly.Main;
import nl.UnderKoen.monopoly.builders.TownBuilder;
import nl.UnderKoen.monopoly.entities.Street;
import nl.UnderKoen.monopoly.entities.Town;
import nl.UnderKoen.monopoly.entities.impl.StreetImpl;
import nl.UnderKoen.monopoly.entities.impl.TownImpl;
import nl.UnderKoen.monopoly.view.elements.StreetElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Under_Koen on 22-05-17.
 */
public class MainPane extends StackPane {
    public MainPane() {
        setup();
    }

    private void setup() {
        StackPane menu = new StackPane();
        getChildren().add(menu);
        menu.setAlignment(Pos.TOP_CENTER);
        menu.getChildren().add(new Button("Start"));
        String url = Main.class.getResource("/background.png").toString();
        setBackground(new Background(new BackgroundImage(new Image(url),
                null, null, null,
                new BackgroundSize(100, 100, true, true, true, true))));


        //Test side
        Town haarlem = new TownBuilder().setName("HAARLEM").setColor(Color.PURPLE)
                .addStreet("BARTELJORIS-\nSTRAAT", 140)
                .addStreet("ZIJWEG", 140)
                .addStreet("HOUTSTRAAT", 160)
                .build();

        Town utrecht = new TownBuilder().setName("UTRECHT").setColor(Color.ORANGE)
                .addStreet("NEUDE", 180)
                .addStreet("BILTSTRAAT", 180)
                .addStreet("VREEBURG", 200)
                .build();

        List<Street> streets = new ArrayList<>();

        streets.add(haarlem.getStreet("BARTELJORIS-\nSTRAAT"));

        StreetImpl Elec = new StreetImpl();
        Elec.setCategory(Street.Category.ELECTRICITY);
        Elec.setName("ELECTRICITY");
        Elec.setPrice(150);
        streets.add(Elec);

        streets.add(haarlem.getStreet("ZIJWEG"));
        streets.add(haarlem.getStreet("HOUTSTRAAT"));

        StreetImpl StationW = new StreetImpl();
        StationW.setCategory(Street.Category.STATION);
        StationW.setName("STATION\nWEST");
        StationW.setPrice(200);
        streets.add(StationW);

        streets.add(utrecht.getStreet("NEUDE"));

        StreetImpl CommunityChest = new StreetImpl();
        CommunityChest.setCategory(Street.Category.COMMUNITY_CHEST);
        CommunityChest.setName("COMMUNITY\nCHEST");
        streets.add(CommunityChest);

        streets.add(utrecht.getStreet("BILTSTRAAT"));
        streets.add(utrecht.getStreet("VREEBURG"));

        StreetImpl park = new StreetImpl();
        park.setCategory(Street.Category.PARKING);
        park.setCorner(true);
        streets.add(park);

        streets.addAll(streets);
        streets.addAll(streets);

        int x = 200;
        int y = 200;
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
                case 3:
                    if (street.isCorner()) {
                        time++;
                        break;
                    }
                    break;
            }
        }
    }

}
