package task_07_Command;

import FLF.CentralUnit;
import task_06_State.SwitchType;

public class SwitchOff implements ICommands {
    private final CentralUnit unit;

    public SwitchOff(CentralUnit centralUnit) {
        this.unit = centralUnit;
    }

    @Override
    public void execute(SwitchType type) {
        switch (type) {
            case electroMotor -> unit.changeMotorState();
            case groundSprayNozzles -> unit.changeGroundNozzleSpraysState();
            default -> unit.changeLightState(type);
        }
    }
}
