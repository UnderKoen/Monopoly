package nl.UnderKoen.monopoly;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import nl.UnderKoen.monopoly.entities.Street;
import nl.UnderKoen.monopoly.view.elements.SpriteAnimation;
import nl.UnderKoen.monopoly.view.scenes.MainPane;
import nl.UnderKoen.monopoly.view.scenes.SetupPane;

import java.io.File;

/**
 * Created by Under_Koen on 22-05-17.
 */
public class Main extends Application {
    public static Scene current;

    public static GameStage gameStage;

    public static Stage stage;

    public static int GAME_WIDHT = 1280;
    public static int GAME_HEIGHT = 720;

    //Skips the setup screen
    public final boolean TESTING = true;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        current = new Scene(new SetupPane(), 300, 400);
        if (TESTING) {
            gameStage = GameStage.Setup;
            nextScene();
            return;
        }
        stage.setTitle("Setup");
        stage.setResizable(false);
        stage.setScene(current);
        stage.show();
        gameStage = GameStage.Setup;
    }

    public static void nextScene() {
        switch (gameStage) {
            case Setup:
                current = new Scene(new MainPane(), GAME_WIDHT, GAME_HEIGHT);
                stage.close();
                stage = new Stage();
                stage.setTitle("Monopoly");
                stage.setResizable(true);
                stage.setScene(current);
                stage.show();
                gameStage = GameStage.MainScreen;
                break;
            case MainScreen:
                break;
            case Game:
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static String getDefaultWorkingDirectory() {
        String workingDirectory;
        String OS = (System.getProperty("os.name")).toUpperCase();
        if (OS.contains("WIN")) {
            workingDirectory = System.getenv("AppData");
        } else {
            workingDirectory = System.getProperty("user.home");
            workingDirectory += "/Library/Application Support";
        }
        workingDirectory += "/Monopoly";
        File dir = new File(workingDirectory);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return workingDirectory;
    }
}

enum GameStage {
    Setup, MainScreen, Game
}