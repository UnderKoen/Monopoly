package nl.UnderKoen.monopoly.client.utils;

/**
 * Created by Under_Koen on 12-06-17.
 */
import jdk.nashorn.api.scripting.URLReader;
import nl.UnderKoen.monopoly.client.view.ExceptionDialog;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TranslationManager {

    public static final String[] LANGUAGES;
    private static String current;
    private static final List<String> CURRENT_LANGUAGES = new ArrayList<>();

    static {
        LANGUAGES = new String[] { "en-EN", "nl-NL"};
        setLanguage(LANGUAGES[0]);
    }

    public static void setLanguage(String languageKey) {
        current = languageKey;
        CURRENT_LANGUAGES.clear();
        try {
            BufferedReader fileReader = new BufferedReader(
                    new URLReader(TranslationManager.class.getResource("/lang/" + languageKey + ".yml")));

            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty() || line.startsWith("#") || !line.contains(":")) {
                    continue;
                }
                CURRENT_LANGUAGES.add(line);
            }
            scanner.close();
        } catch (Exception ex) {
            ExceptionDialog.warning("error.translation.notfound");
        }
    }

    public static String getCurrentLanguage() {
        return current;
    }


    public static String translate(String key, Object... args) {
        for (String translation : CURRENT_LANGUAGES) {
            String[] translationSplit = translation.split(":", 2);
            if (translationSplit[0].equals(key)) {
                return String.format(translationSplit[1], args);
            }
        }
        System.err.println(key);
        return key;
    }
}