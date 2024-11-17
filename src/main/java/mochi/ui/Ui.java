package mochi.ui;

import java.util.ArrayList;

public class Ui {

    private static MainWindow mainWindow;

    // Initialize Ui with the MainWindow controller
    public static void initialize(MainWindow controller) {
        mainWindow = controller;
        System.out.println("Ui initialized with MainWindow");
    }

    public static void printDivider() {
        response("____________________________________________________________");
    }

    public static void response(String input) {
        assert input != null && !input.trim().isEmpty() : "Response message cannot be null or empty";

        if (mainWindow == null) {
            System.err.println("MainWindow is not initialized yet. Response skipped: " + input);
            return;
            //throw new IllegalStateException("MainWindow is not set. Call Ui.initialize() first.");
        }

        mainWindow.displayResponse(input);
    }

    public static void responseFromArray(ArrayList<String> input) {
        mainWindow.displayResponse(String.join("\n", input));
    }
}
