package Operator;

import main.java.Engine.ElectricMotor;
import main.java.ExtinguishDevices.FrontCannon;
import main.java.ExtinguishDevices.GroundSprayNozzles;
import main.java.ExtinguishDevices.HeadCannon;
import main.java.Lights.Lights;

import java.util.HashMap;

public class ControlPanel {
    public LightSwitch[] getLightSwitches() {
        return switches;
    }

    public LightSwitch[] getSwitches() {
        return switches;
    }

    private LightSwitch[] switches;

    public ElectroMotorSwitch getMotorSwitch() {
        return motorSwitch;
    }

    private ElectroMotorSwitch motorSwitch;

    public KnobFrontWaterCanon getKnobFront() {
        return knobFront;
    }

    private GroundNozzleSwitch nozzleSwitch;

    public GroundNozzleSwitch getNozzleSwitch() {
        return nozzleSwitch;
    }

    private KnobFrontWaterCanon knobFront;

    public KnobRoofWaterCanon getKnobRoof() {
        return knobRoof;
    }

    private KnobRoofWaterCanon knobRoof;

    ControlPanel(FrontCannon front, HeadCannon head, HashMap<SwitchType, Lights[]> lights, ElectricMotor[] motor,GroundSprayNozzles[] nozzles) {
        this.knobFront = new KnobFrontWaterCanon(front);
        this.knobRoof = new KnobRoofWaterCanon(head);
        this.motorSwitch = new ElectroMotorSwitch(motor);
        this.nozzleSwitch = new GroundNozzleSwitch(SwitchType.groundSprayNozzles,nozzles);
        this.switches = new LightSwitch[5];
        for (byte i=0;i<5;i++) {
            switch (i) {
                case 0->this.switches[i] = new LightSwitch(SwitchType.BlueLights,lights);
                case 1->this.switches[i] = new LightSwitch(SwitchType.SideLights,lights);
                case 2->this.switches[i] = new LightSwitch(SwitchType.warningLights,lights);
                case 3->this.switches[i] = new LightSwitch(SwitchType.headLightsFront,lights);
                case 4->this.switches[i] = new LightSwitch(SwitchType.headLightsRoof,lights);
            }
        }
    }
}
