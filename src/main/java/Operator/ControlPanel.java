package Operator;

import Engine.ElectricMotor;
import ExtinguishDevices.FrontCannon;
import ExtinguishDevices.GroundSprayNozzles;
import ExtinguishDevices.HeadCannon;
import FLF.CentralUnit;
import Lights.Lights;
import task_06_State.ElectroMotorSwitch;
import task_06_State.GroundNozzleSwitch;
import task_06_State.LightSwitch;
import task_06_State.SwitchType;
import task_08_Observer.ColourLEDFoam;
import task_08_Observer.ColourLEDWater;

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
    private ColourLEDFoam ledFoam;
    private ColourLEDWater ledWater;

    ControlPanel(FrontCannon front, HeadCannon head, CentralUnit unit, ColourLEDFoam foam, ColourLEDWater water) {
        this.ledFoam = foam;
        this.ledWater = water;
        this.knobFront = new KnobFrontWaterCanon(front);
        this.knobRoof = new KnobRoofWaterCanon(head);
        this.motorSwitch = new ElectroMotorSwitch(unit);
        this.nozzleSwitch = new GroundNozzleSwitch(SwitchType.groundSprayNozzles,unit);
        this.switches = new LightSwitch[5];
        for (byte i=0;i<5;i++) {
            switch (i) {
                case 0->this.switches[i] = new LightSwitch(SwitchType.BlueLights,unit);
                case 1->this.switches[i] = new LightSwitch(SwitchType.SideLights,unit);
                case 2->this.switches[i] = new LightSwitch(SwitchType.warningLights,unit);
                case 3->this.switches[i] = new LightSwitch(SwitchType.headLightsFront,unit);
                case 4->this.switches[i] = new LightSwitch(SwitchType.headLightsRoof,unit);
            }
        }
    }

    public ColourLEDFoam getLedFoam() {
        return ledFoam;
    }

    public ColourLEDWater getLedWater() {
        return ledWater;
    }
}
