package nl.UnderKoen.monopoly.client.view.elements;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Created by Under_Koen on 09-06-17.
 */
public class MenuInputField extends TextField {
    public MenuInputField() {
        setBorderColor(Color.BLACK);
    }

    public MenuInputField(int xPos, int yPos, String text) {
        this();
        if (text == null) {
            text = "";
        }
        this.setLayoutX(xPos);
        this.setLayoutY(yPos);
        this.setText(text);
    }

    public void setBorderColor(Color color) {
        setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(null, null, color, null,
                null, null, BorderStrokeStyle.DASHED, null, null,
                null, null)));
        setPadding(Insets.EMPTY);
    }
}
