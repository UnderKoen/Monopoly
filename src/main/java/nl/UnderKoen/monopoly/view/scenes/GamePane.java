package nl.UnderKoen.monopoly.view.scenes;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import nl.UnderKoen.monopoly.Main;
import nl.UnderKoen.monopoly.view.elements.MapElement;

/**
 * Created by Under_Koen on 29-05-17.
 */
public class GamePane extends StackPane {
    public GamePane() {
        setup();
    }

    private void setup() {
        MapElement map = new MapElement();
        map.scaleXProperty().bind(Main.stage.heightProperty().divide(610+25).multiply(0.85));
        map.scaleYProperty().bind(Main.stage.heightProperty().divide(610+25).multiply(0.85));
        getChildren().add(map);
        setAlignment(map, Pos.TOP_CENTER);
    }
}