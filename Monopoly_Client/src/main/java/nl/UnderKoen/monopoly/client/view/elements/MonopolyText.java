package nl.UnderKoen.monopoly.client.view.elements;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import nl.UnderKoen.monopoly.client.Client;

/**
 * Created by Under_Koen on 09-06-17.
 */
public class MonopolyText extends Text {
    public MonopolyText() {
        setFont(Client.FONT);
        setFill(Color.WHITE);
        setStroke(Color.BLACK);
    }

    public MonopolyText(String text) {
        this();
        setText(text);
    }

    public MonopolyText(int x, int y, String text) {
        this(text);
        setLayoutX(x);
        setLayoutY(y);
    }

    public MonopolyText addShadow() {
        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(3);
        shadow.setOffsetY(3);
        shadow.setColor(Color.BLACK);
        setEffect(shadow);
        return this;
    }
}
