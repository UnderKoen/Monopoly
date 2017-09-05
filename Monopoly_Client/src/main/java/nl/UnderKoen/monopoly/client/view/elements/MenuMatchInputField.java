package nl.UnderKoen.monopoly.client.view.elements;

import javafx.scene.paint.Color;

/**
 * Created by Under_Koen on 09-06-17.
 */
public class MenuMatchInputField extends MenuInputField {

    private String regex;

    public MenuMatchInputField(String regex) {
        super();
        this.regex = regex;
        registerCheck();
    }

    public MenuMatchInputField(int xPos, int yPos, String text, String regex) {
        super(xPos, yPos, text);
        this.regex = regex;
        registerCheck();
    }

    public String getRegex() {
        return this.regex;
    }

    private void registerCheck() {
        focusedProperty().addListener(change -> {
            if (!isFocused() && !getText().matches(getRegex()) && !getText().isEmpty()) {
                requestFocus();
                setBorderColor(Color.RED);
            } else {
                setBorderColor(Color.BLACK);
            }
        });
    }


}
