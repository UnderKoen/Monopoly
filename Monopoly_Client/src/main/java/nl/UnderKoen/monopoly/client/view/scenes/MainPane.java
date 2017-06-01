package nl.UnderKoen.monopoly.client.view.scenes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import nl.UnderKoen.monopoly.client.Client;

/**
 * Created by Under_Koen on 22-05-17.
 */
public class MainPane extends StackPane {
    public MainPane() {
        setup();
    }

    private void setup() {
        String url = Client.class.getResource("/background.png").toString();
        setBackground(new Background(new BackgroundImage(new Image(url),
                null, null, null,
                new BackgroundSize(100, 100, true, true, true, true))));

        VBox menu = new VBox(30);
        menu.setAlignment(Pos.CENTER);
        //menu.setTranslateY(100);
        getChildren().add(menu);

        url = Client.class.getResource("/logo.png").toString();
        ImageView image = new ImageView(new Image(url));
        image.setFitWidth(2000*0.2);
        image.setFitHeight(687*0.2);
        menu.getChildren().add(image);

        Button startNew = new Button("Start new game");
        startNew.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Client.nextScene();
        });
        startNew.setPrefSize(400,40);
        menu.getChildren().add(startNew);

        Button startOld = new Button("Start old game");
        startOld.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Client.nextScene();
        });
        startOld.setPrefSize(400,40);
        menu.getChildren().add(startOld);

        Button options = new Button("Options");
        options.setPrefSize(400,40);
        menu.getChildren().add(options);

        Button quit = new Button("Quit");
        quit.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.exit(0);
        });
        quit.setPrefSize(400,40);
        menu.getChildren().add(quit);
    }
}
