package task_07_Command;

import task_06_State.SwitchType;

public interface ICommands {
    void execute(SwitchType type);
}
