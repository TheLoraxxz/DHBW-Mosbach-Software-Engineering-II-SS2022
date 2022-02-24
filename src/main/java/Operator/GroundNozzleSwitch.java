package Operator;

import ExtinguishDevices.CannonState;
import ExtinguishDevices.GroundSprayNozzles;

public class GroundNozzleSwitch extends Switch  {
    private GroundSprayNozzles[] sprayNozzles;

    GroundNozzleSwitch(SwitchType type,GroundSprayNozzles[] nozzles) {
        super(type);
        this.sprayNozzles = nozzles;
    }

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
    }
    
}
