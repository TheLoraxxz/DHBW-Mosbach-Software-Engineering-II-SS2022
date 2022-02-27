package task_06_State;

import FLF.CentralUnit;
import task_07_Command.SwitchOff;
import task_07_Command.SwitchOn;

public abstract class Switch {

    protected SwitchType switchTypeOperation;
    protected IButtonState state;
    protected SwitchOn on;
    protected SwitchOff off;

    Switch(SwitchType type, CentralUnit unit) {
        this.switchTypeOperation = type;
        this.state = new OffState();
        this.on = new SwitchOn(unit);
        this.off = new SwitchOff(unit);

    }

    public abstract void press();

    public SwitchType getSwitchTypeOperation() {
        return switchTypeOperation;
    }

    public void setState(IButtonState state) {
        this.state = state;
    }
    public boolean getState() {
        if (this.state instanceof OffState) {
            return false;
        } else {
            return true;
        }
    }

}
