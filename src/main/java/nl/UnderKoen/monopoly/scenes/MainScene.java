package nl.UnderKoen.monopoly.scenes;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Paint;

/**
 * Created by Under_Koen on 22-05-17.
 */
public class MainScene extends Scene {
    public MainScene(Parent root) {
        super(root);
        setup();
    }

    public MainScene(Parent root, double width, double height) {
        super(root, width, height);
        setup();
    }

    public MainScene(Parent root, Paint fill) {
        super(root, fill);
        setup();
    }

    public MainScene(Parent root, double width, double height, Paint fill) {
        super(root, width, height, fill);
        setup();
    }

    public MainScene(Parent root, double width, double height, boolean depthBuffer) {
        super(root, width, height, depthBuffer);
        setup();
    }

    public MainScene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing) {
        super(root, width, height, depthBuffer, antiAliasing);
        setup();
    }

    private void setup() {
        System.out.println("Setting up.");
    }
}
