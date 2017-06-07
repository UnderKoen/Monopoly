package nl.UnderKoen.monopoly.common.enumeration;

/**
 * Created by Under_Koen on 07-06-17.
 */
public enum  Color {
    BLUE(0, 0, 255), BROWN(106, 60, 1), GREEN(38, 127, 0), ORANGE(255, 85, 0), RED(255, 0, 0), WHITE(255, 255, 255);

    private int red;
    private int blue;
    private int green;

    Color(int red, int green, int blue) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public javafx.scene.paint.Color getColor() {
        return new javafx.scene.paint.Color(red / 255D, green / 255D, blue / 255D, 1);
    }

}
