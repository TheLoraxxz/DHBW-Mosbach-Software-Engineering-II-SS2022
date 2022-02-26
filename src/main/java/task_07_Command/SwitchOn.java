package task_07_Command;

import FLF.CentralUnit;
import task_06_State.SwitchType;

public class SwitchOn implements ICommands{
    private final CentralUnit unit;

    public SwitchOn(CentralUnit unit) {
        this.unit = unit;
    }
    //TODO: make the type distinction here and give the functions directly to the central unit
    @Override
    public void execute(SwitchType type) {
        switch (type) {
            case electroMotor -> unit.changeMotorState();
            case groundSprayNozzles -> unit.changeGroundNozzleSpraysState();
            default -> unit.changeLightState(type);
        }
    }
}
