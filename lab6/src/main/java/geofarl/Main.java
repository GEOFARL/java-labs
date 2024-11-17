package geofarl;

import app.TranslatorApplication;
import console.ConsoleHandler;
import dictionary.EnglishToUkrainianDictionary;

public class Main {
    public static void main(String[] args) {
        EnglishToUkrainianDictionary dictionary = new EnglishToUkrainianDictionary();
        ConsoleHandler consoleHandler = new ConsoleHandler();
        TranslatorApplication app = new TranslatorApplication(dictionary, consoleHandler);

        app.start();
        consoleHandler.close();
    }
}