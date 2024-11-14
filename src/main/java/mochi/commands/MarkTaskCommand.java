package mochi.commands;

import mochi.common.*;
import mochi.ui.*;
import mochi.tasks.*;
public class MarkTaskCommand extends Command {

  private final int index;

  public MarkTaskCommand(TaskList taskList, String[] token) {
    super(taskList);
    this.index = Integer.parseInt(token[1]) - 1;
  }

  @Override
  public void execute() {
    try {
      taskList.markTask(this.index);
      Ui.response(DialogMessages.MARK_TASK.getValue() + System.lineSeparator() + taskList.getTaskById(this.index).toString());
    } catch (Exception e) {
      handleException(e);
    }
  }
}