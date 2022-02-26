package task_06_State;

import FLF.CentralUnit;
import Lights.Lights;

import java.util.HashMap;

public class LightSwitch extends Switch {


    public LightSwitch(SwitchType type, CentralUnit unit) {
        super(type,unit);
    }


    @Override
    public void press() {
        this.state.switchState(this);
        if (this.state instanceof OnState) {
            this.on.execute(this.switchTypeOperation);
        } else {
            this.off.execute(this.switchTypeOperation);
        }

    }
}
