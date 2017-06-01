package nl.UnderKoen.monopoly.client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.UnderKoen.monopoly.client.view.scenes.GamePane;
import nl.UnderKoen.monopoly.client.view.scenes.MainPane;
import nl.UnderKoen.monopoly.client.view.scenes.SetupPane;
import nl.UnderKoen.monopoly.common.enumeration.GameStage;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Under_Koen on 22-05-17.
 */
public class Client extends Application {
    public static Scene current;

    public static GameStage lastGameStage;

    public static GameStage gameStage;

    public static Stage stage;

    public static final String OPTION_DIR = getAppDataDirectory() + "/.Monopoly";

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
            gameStage = GameStage.SETUP;
            nextScene();
            return;
        }
        gotoScene(GameStage.SETUP);
    }

    public static void nextScene() {
        lastGameStage = gameStage;
        switch (gameStage) {
            case SETUP:
                gotoScene(GameStage.MAIN_SCREEN);
                break;
            case MAIN_SCREEN:
                gotoScene(GameStage.GAME);
                break;
        }
    }

    public static void goBackScene() {
        gotoScene(lastGameStage);
    }

    public static void gotoScene(GameStage gameStage) {
        switch (gameStage) {
            case SETUP:
                stage.close();
                stage = new Stage();
                stage.setTitle("Setup");
                stage.setResizable(false);
                current = new Scene(new SetupPane(), 300, 400);
                stage.setScene(current);
                stage.show();
                break;
            case MAIN_SCREEN:
                stage.close();
                stage = new Stage();
                stage.setTitle("Monopoly");
                stage.setResizable(false);
                current = new Scene(new MainPane(), GAME_WIDHT, GAME_HEIGHT);
                stage.setScene(current);
                stage.show();
                break;
            case GAME:
                stage.close();
                stage = new Stage();
                stage.setTitle("Monopoly");
                stage.setResizable(true);
                current = new Scene(new GamePane(), GAME_WIDHT, GAME_HEIGHT);
                stage.setScene(current);
                stage.show();
                break;
        }
        Client.gameStage = gameStage;
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