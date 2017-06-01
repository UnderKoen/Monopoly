package nl.UnderKoen.monopoly.client.view.scenes;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import nl.UnderKoen.monopoly.client.Client;
import nl.UnderKoen.monopoly.client.view.elements.MapElement;

/**
 * Created by Under_Koen on 29-05-17.
 */
public class GamePane extends StackPane {
    public GamePane() {
        setup();
    }

    private void setup() {
        MapElement map = new MapElement();
        map.scaleYProperty().bind(Client.stage.heightProperty().divide(610).multiply(0.75));
        map.scaleXProperty().bind(Client.stage.heightProperty().divide(610).multiply(0.75));
        getChildren().add(map);
        setAlignment(map, Pos.TOP_CENTER);
    }
}