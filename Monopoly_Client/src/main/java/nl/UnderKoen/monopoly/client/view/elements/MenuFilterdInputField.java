package nl.UnderKoen.monopoly.client.view.elements;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

/**
 * Created by Under_Koen on 09-06-17.
 */
public class MenuFilterdInputField extends MenuInputField {
    public MenuFilterdInputField(String regex) {
        super();
        registerCheck(regex);
    }

    public MenuFilterdInputField(int xPos, int yPos, String text, String regex) {
        super(xPos, yPos, text);
        registerCheck(regex);
    }

    private void registerCheck(String regex) {
        setOnKeyPressed(key -> {
            if (key.getCode() == KeyCode.V && key.isControlDown()
                    || key.getCode() == KeyCode.INSERT && key.isShiftDown()) {
                key.consume();
            }
        });
        setOnKeyTyped(key -> {
            if (!key.getCharacter().trim().equals("") && !key.getCharacter().matches(regex)) {
                key.consume();
                setBorderColor(Color.RED);
            } else {
                setBorderColor(Color.BLACK);
            }
        });
    }
}
