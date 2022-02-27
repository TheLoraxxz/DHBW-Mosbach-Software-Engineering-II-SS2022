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
    }
    /*
    @Override
    public void on() {
        for (GroundSprayNozzles groundSprayNozzles : sprayNozzles) {
            groundSprayNozzles.setCannonState(CannonState.throwingExtinguishMedium);
            groundSprayNozzles.pumpOut();
        }
        this.on = true;
        
    }

    @Override
    public void off() {
        this.on = false;
        for (GroundSprayNozzles groundSprayNozzles : sprayNozzles) {
            groundSprayNozzles.setCannonState(CannonState.inactive);
        }
    }*/
    
}
