package nl.UnderKoen.monopoly.view.scenes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import nl.UnderKoen.monopoly.Main;

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
                null, null,null,
                new BackgroundSize(100, 100, true, true, true, true))));
    }

}
