package task_06_State;

import FLF.CentralUnit;

public class ElectroMotorSwitch extends Switch{

    public ElectroMotorSwitch(CentralUnit unit) {
        super(SwitchType.electroMotor,unit);
    }

    @Override
    public void press() {
        this.state.switchState(this);
    }
}
