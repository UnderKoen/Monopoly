package nl.UnderKoen.monopoly;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import java.util.Scanner;

/**
 * Created by Under_Koen on 22-05-17.
 */
public class Main extends Application {
    public static Scene current;

    public static GameStage lastGameStage;

    public static GameStage gameStage;

    public static Stage stage;

    public static final String OPTION_DIR = Main.getAppDataDirectory() + "/.Monopoly";

    public static int GAME_WIDHT = 1024;
    public static int GAME_HEIGHT = 576;

    //Skips the setup screen
    public final boolean TESTING = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        File optionDir = new File(OPTION_DIR);
        if (!optionDir.exists()) {
            optionDir.mkdirs();
        }
        stage = primaryStage;
        if (TESTING) {
            gameStage = GameStage.Setup;
            nextScene();
            return;
        }
        gotoScene(GameStage.Setup);
    }

    public static void nextScene() {
        lastGameStage = gameStage;
        switch (gameStage) {
            case Setup:
                gotoScene(GameStage.MainScreen);
                break;
            case MainScreen:
                gotoScene(GameStage.Game);
                break;
            case Game:
                break;
        }
    }

    public static void goBackScene() {
        gotoScene(lastGameStage);
    }

    public static void gotoScene(GameStage gameStage) {
        switch (gameStage) {
            case Setup:
                current = new Scene(new SetupPane(), 300, 400);
                stage.close();
                stage = new Stage();
                stage.setTitle("Setup");
                stage.setResizable(false);
                stage.setScene(current);
                stage.show();
                break;
            case MainScreen:
                current = new Scene(new MainPane(), GAME_WIDHT, GAME_HEIGHT);
                stage.close();
                stage = new Stage();
                stage.setTitle("Monopoly");
                stage.setResizable(false);
                stage.setScene(current);
                stage.show();
                break;
            case Game:
                current = new Scene(new MainPane(), GAME_WIDHT, GAME_HEIGHT);
                stage.close();
                stage = new Stage();
                stage.setTitle("Monopoly");
                stage.setResizable(false);
                stage.setScene(current);
                stage.show();
                break;
        }
        Main.gameStage = gameStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static String getAppDataDirectory() {
        String workingDirectory;
        String OS = (System.getProperty("os.name")).toUpperCase();
        if (OS.contains("WIN")) {
            workingDirectory = System.getenv("AppData");
        } else {
            workingDirectory = System.getProperty("user.home");
            workingDirectory += "/Library/Application Support";
        }
        return workingDirectory;
    }

    public static String getDefaultWorkingDirectory() {
        return getAppDataDirectory() + "/Monopoly";
    }

    public static String getWorkingDirectory() {
        File optionDir = new File(OPTION_DIR + ".options.json");
        if (optionDir.exists()) {
            try (Scanner scanner = new Scanner(optionDir)) {
                String json = scanner.nextLine();
                JsonParser parser = new JsonParser();
                JsonObject options = parser.parse(json).getAsJsonObject();
                return options.get("location").getAsString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return getDefaultWorkingDirectory();
        }
        return null;
    }
}

enum GameStage {
    Setup, MainScreen, CreateGame, SelectGame, Options, Game
}