package task_07_Command;

import FLF.CentralUnit;
import task_06_State.SwitchType;

public class SwitchOff implements ICommands {
    private final CentralUnit centralUnit;

    public SwitchOff(CentralUnit centralUnit) {
        this.centralUnit = centralUnit;
    }

    @Override
    public void execute(SwitchType type) {
        centralUnit.switchOff(type);
    }
}
