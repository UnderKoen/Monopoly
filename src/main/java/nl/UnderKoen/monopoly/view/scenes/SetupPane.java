package nl.UnderKoen.monopoly.view.scenes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import nl.UnderKoen.monopoly.Main;

/**
 * Created by Under_Koen on 22-05-17.
 */
public class SetupPane extends StackPane {
    public SetupPane() {
        setup();
    }

    private void setup() {
        VBox vBox = new VBox(10);
        vBox.setTranslateX(10);
        vBox.setTranslateY(10);
        getChildren().add(vBox);

        HBox screenSize = new HBox(10);
        vBox.getChildren().add(screenSize);

        Text screen = new Text("Screen size:");
        screen.setFont(new Font(15));
        screen.setTranslateY(5);
        screenSize.getChildren().add(screen);

        ChoiceBox t = new ChoiceBox<>();
        t.getItems().add("896X504");
        t.getItems().add("1024X576");
        t.getItems().add("1280X720");
        t.getItems().add("1366X768");
        t.getItems().add("1920X1080");
        screenSize.getChildren().add(t);

        Button confirm = new Button("Confirm");
        getChildren().add(confirm);
        confirm.setTranslateY(-10);
        confirm.setTranslateX(-10);
        confirm.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (t.getValue() == null) {
                int depth = 20;
                DropShadow borderGlow= new DropShadow();
                borderGlow.setOffsetY(0f);
                borderGlow.setOffsetX(0f);
                borderGlow.setColor(Color.RED);
                borderGlow.setWidth(depth);
                borderGlow.setHeight(depth);

                confirm.setEffect(borderGlow);
            } else {
                confirm.setEffect(null);
                String[] size = t.getValue().toString().split("X");
                Main.GAME_WIDHT = Integer.parseInt(size[0]);
                Main.GAME_HEIGHT = Integer.parseInt(size[1]);
                Main.nextScene();
            }
        });
        setAlignment(confirm, Pos.BOTTOM_RIGHT);
    }
}
