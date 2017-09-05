package nl.UnderKoen.monopoly.common.utils;

import java.io.Serializable;

/**
 * Created by Under_Koen on 07-06-17.
 */
public class Color implements Serializable {
    public static final Color BLUE = new Color(0, 0, 255);
    public static final Color BROWN = new Color(106, 60, 1);
    public static final Color GREEN = new Color(38, 127, 0);
    public static final Color ORANGE = new Color(255, 85, 0);
    public static final Color RED = new Color(255, 0, 0);
    public static final Color WHITE = new Color(255, 255, 255);

    private double red;
    private double blue;
    private double green;

    public Color(double red, double green, double blue) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public Color(String hash) {
        javafx.scene.paint.Color color = javafx.scene.paint.Color.web(hash);
        red = color.getRed();
        blue = color.getBlue();
        green = color.getGreen();
    }

    public javafx.scene.paint.Color getColor() {
        return new javafx.scene.paint.Color(red / 255D, green / 255D, blue / 255D, 1);
    }

}
