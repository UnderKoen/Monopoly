package nl.UnderKoen.monopoly.client.view.elements;

import javafx.scene.control.CheckBox;

/**
 * Created by Under_Koen on 09-06-17.
 */
public class MenuCheckBox extends CheckBox {

    public MenuCheckBox() {
        super();
    }

    public MenuCheckBox(int xPos, int yPos) {
        this();
        setLayoutX(xPos);
        setLayoutY(yPos);
    }

    public MenuCheckBox(int xPos, int yPos, boolean defaultSelected) {
        this(xPos, yPos);
        setSelected(defaultSelected);
    }

}
