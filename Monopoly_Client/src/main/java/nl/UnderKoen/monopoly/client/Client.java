package nl.UnderKoen.monopoly.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import nl.UnderKoen.monopoly.client.controller.LoginController;
import nl.UnderKoen.monopoly.client.view.scenes.SceneHolder;
import nl.UnderKoen.monopoly.client.view.scenes.SceneLogin;

/**
 * Created by Under_Koen on 22-05-17.
 */
public class Client extends Application {
    public static int GAME_WIDHT = 1024;
    public static int GAME_HEIGHT = 576;

    public static final Font FONT = Font.loadFont(
            Client.class.getResourceAsStream("/font/kabel.ttf"), 22);
    public static final Font TITLE_FONT = Font.loadFont(Client.class.getResourceAsStream(
            "/font/kabel.ttf"), 65);
    private static Stage stage;
    private static SceneHolder lastScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        SceneLogin view = new SceneLogin();
        view.registerController(new LoginController(view));
        setScene(view);
        primaryStage.setTitle("Monopoly: Online");
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(onClose -> {
            System.exit(0);
        });
        System.out.println("Showing LoginScreen");
        Rectangle2D screen = Screen.getPrimary().getBounds();

        primaryStage.setX(-2 + (screen.getMaxX() / 2) - (GAME_WIDHT / 2));
        primaryStage.setY((screen.getMaxY() / 2) - (GAME_HEIGHT / 2));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public static void setScene(SceneHolder scene) {
        Platform.runLater(() -> {
            setSceneSynced(scene);
        });
    }

    public static void setSceneSynced(SceneHolder scene) {
        Scene theScene = scene.getScene();
        lastScene = scene;
        stage.setScene(theScene);
    }

    public static SceneHolder getLastScene() {
        return lastScene;
    }
}