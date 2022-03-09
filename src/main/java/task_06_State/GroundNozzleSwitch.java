package task_06_State;

import ExtinguishDevices.CannonState;
import ExtinguishDevices.GroundSprayNozzles;
import FLF.CentralUnit;

public class GroundNozzleSwitch extends Switch  {

    public GroundNozzleSwitch(SwitchType type, CentralUnit unit) {
        super(type,unit);
    }


    @Override
    public void press() {
        this.state.switchState(this);
        if(this.state instanceof OnState) {
            this.on.execute(this.switchTypeOperation);
        } else {
            this.off.execute(this.switchTypeOperation);
        }
    }
    
}
