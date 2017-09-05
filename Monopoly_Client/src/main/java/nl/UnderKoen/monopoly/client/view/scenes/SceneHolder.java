package nl.UnderKoen.monopoly.client.view.scenes;

import javafx.scene.Scene;
import nl.UnderKoen.monopoly.client.controller.Controller;

/**
 * Created by Under_Koen on 01-06-17.
 */
public interface SceneHolder {
    void registerController(Controller controller);

    Scene getScene();
}
