package mochi;

import mochi.commands.CommandEnum;
import mochi.common.DialogMessages;
import mochi.parsers.InputProcessor;
import mochi.tasks.TaskList;

public class Mochi {
    public static final String NAME = "Mochi";
    private final TaskList taskList;
    private final InputProcessor inputProcessor;

    public Mochi() {
        this.taskList = new TaskList();
        this.inputProcessor = new InputProcessor(taskList);
    }

    /**
     * Generates a response for the user's chat message.
     * Links to MainWindow controller
     */
    public String getResponse(String input) {
        try {
            inputProcessor.processInput(input);
            if (input.toUpperCase().equals(CommandEnum.BYE.toString())) {
                return DialogMessages.BYE.getValue();
            }
            return "Mochi : " + input;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}

