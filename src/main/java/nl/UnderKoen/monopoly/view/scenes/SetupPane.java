package nl.UnderKoen.monopoly.view.scenes;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import nl.UnderKoen.monopoly.Main;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by Under_Koen on 22-05-17.
 */
public class SetupPane extends StackPane {
    private static String OPTION_DIR = Main.OPTION_DIR;

    public SetupPane() {
        setup();
    }

    private void setup() {
        VBox vBox = new VBox(5);
        vBox.setTranslateX(10);
        vBox.setTranslateY(10);
        getChildren().add(vBox);

        Text screen = new Text("Screen size:");
        screen.setFont(new Font(12));
        screen.setTranslateY(5);
        vBox.getChildren().add(screen);

        ChoiceBox t = new ChoiceBox<>();
        t.getItems().add("1024X576");
        t.getItems().add("1280X720");
        t.getItems().add("1366X768");
        t.getItems().add("1920X1080");
        vBox.getChildren().add(t);

        Text standard = new Text("Standard location:");
        standard.setFont(new Font(12));
        standard.setTranslateY(5);
        vBox.getChildren().add(standard);

        HBox standardLocation = new HBox(10);
        vBox.getChildren().add(standardLocation);

        TextField location = new TextField();
        location.setText(Main.getDefaultWorkingDirectory());
        location.setEditable(false);
        standardLocation.getChildren().add(location);

        Button button = new Button("Browse");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            DirectoryChooser chooser = new DirectoryChooser();
            chooser.setInitialDirectory(new File(Main.getAppDataDirectory()));
            chooser.setTitle("Standard Location");
            File selectedDirectory = chooser.showDialog(Main.stage);
            location.setText(selectedDirectory.getAbsolutePath());
        });
        standardLocation.getChildren().add(button);

        Button confirm = new Button("Confirm");
        getChildren().add(confirm);
        confirm.setTranslateY(-10);
        confirm.setTranslateX(-10);
        confirm.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (t.getValue() == null) {
                int depth = 20;
                DropShadow borderGlow = new DropShadow();
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

                //Setting up default location
                if (!new File(OPTION_DIR).exists()) new File(OPTION_DIR).mkdir();
                File dir = new File(OPTION_DIR + "/.options.json");
                try {
                    dir.createNewFile();
                    try (FileWriter writer = new FileWriter(dir)) {
                        JsonObject json = new JsonObject();
                        json.addProperty("location", location.getText());
                        json.addProperty("resolution", t.getValue().toString());
                        writer.write(json.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                File workingDir = new File(Main.getWorkingDirectory());
                if (!workingDir.exists()) {
                    workingDir.mkdir();
                }

                Main.nextScene();
            }
        });
        File dir = new File(OPTION_DIR + "/.options.json");

        if (dir.exists()) {
            try (Scanner scanner = new Scanner(dir)) {
                String json = scanner.nextLine();
                JsonParser parser = new JsonParser();
                JsonObject options = parser.parse(json).getAsJsonObject();
                location.setText(options.get("location").getAsString());
                t.setValue(options.get("resolution").getAsString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setAlignment(confirm, Pos.BOTTOM_RIGHT);
    }
}
