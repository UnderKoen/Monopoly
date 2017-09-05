package nl.UnderKoen.monopoly.client.view.scenes;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import nl.UnderKoen.monopoly.client.Client;
import nl.UnderKoen.monopoly.client.controller.Controller;
import nl.UnderKoen.monopoly.client.controller.LoginController;
import nl.UnderKoen.monopoly.client.utils.TranslationManager;
import nl.UnderKoen.monopoly.client.view.ExceptionDialog;
import nl.UnderKoen.monopoly.client.view.elements.MenuCheckBox;
import nl.UnderKoen.monopoly.client.view.elements.MenuFilterdInputField;
import nl.UnderKoen.monopoly.client.view.elements.MenuMatchInputField;
import nl.UnderKoen.monopoly.common.MonopolyStatics;

import java.net.InetAddress;

/**
 * Created by Under_Koen on 09-06-17.
 */
public class SceneLogin implements SceneHolder {
    private static Pane form;

    private Text ipLabel;
    private Text portLabel;
    private Text usernameLabel;
    private Text confirmLabel;
    private Button joinButton;
    private TextField ipInput;
    private TextField portInput;
    private TextField usernameInput;
    private CheckBox confirmInput;

    private LoginController controller;

    @Override
    public void registerController(Controller controller) {
        this.controller = (LoginController) controller;
    }

    @Override
    public Scene getScene() {
        Pane layers = new StackPane();
        try {
            layers.getChildren().addAll(//TODO background,
                    buildFrom());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Scene(layers, Client.GAME_WIDHT, Client.GAME_HEIGHT);
    }

    private Node buildFrom() throws Exception {
        if (form != null) return form;
        form = new Pane();
        form.setMaxSize(500,260);

        ipLabel = new Text(30, 60, TranslationManager.translate("lobby.label.ip"));
        ipInput = new MenuMatchInputField(180, 35, InetAddress.getLocalHost().getHostAddress(),
                MonopolyStatics.REGEX_IP);
        portLabel = new Text(30, 90, TranslationManager.translate("lobby.label.port"));
        portInput = new MenuFilterdInputField(180, 65, "", MonopolyStatics.NUMERIC);
        usernameLabel = new Text(30, 120, TranslationManager.translate("lobby.label.username"));
        usernameInput = new MenuMatchInputField(180, 95, "", MonopolyStatics.USERNAME);
        confirmLabel = new Text(30, 150, TranslationManager.translate("lobby.label.confirm"));
        confirmInput = new MenuCheckBox(180, 135, false);
        joinButton = new Button(TranslationManager.translate("lobby.button.join"));
        joinButton.setLayoutX(30);
        joinButton.setLayoutY(170);

        ipLabel.setFont(Client.FONT);
        ipInput.setFont(Client.FONT);
        portLabel.setFont(Client.FONT);
        portInput.setFont(Client.FONT);
        portInput.setText("1099");
        usernameLabel.setFont(Client.FONT);
        usernameInput.setFont(Client.FONT);
        confirmLabel.setFont(Client.FONT);
        joinButton.setFont(Client.FONT);

        joinButton.onMouseClickedProperty().set(event -> {
            if (confirmInput.isSelected()) {
                onConnectClick();
            } else {
                ExceptionDialog.warning("lobby.error.shouldConfirm");
            }
        });

        form.getChildren().addAll(ipLabel, ipInput, portLabel, portInput, usernameLabel, usernameInput,
                confirmLabel, confirmInput, joinButton);
        return form;
    }

    public void onConnectClick() {
        controller.connect();
    }

    public String getIpInput() {
        return ipInput.getText();
    }

    public int getPortInput() throws NumberFormatException {
        return Integer.parseInt(portInput.getText());
    }

    public String getUsernameInput() {
        return usernameInput.getText();
    }
}
