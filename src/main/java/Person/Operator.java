package Person;

import ExtinguishDevices.FrontWaterStepsType;
import ExtinguishDevices.KnopRoofStepsType;
import Operator.OperatorSection;
import Operator.SwitchType;

public class Operator extends FLFOperator {
    public Operator() {
        this.id_card = new ID_Card("Sam",6072);
    }

    public OperatorSection getOperatorSection() {
        return operatorSection;
    }

    private OperatorSection operatorSection;

    @Override
    public void pressJoystickRight() {
        if (this.operatorSection != null) {
            this.operatorSection.getJoystick().getPressureButtons()[1].press();
        }

    }

    @Override
    public void pressJoystickLeft() {
        if (this.operatorSection != null) {
            this.operatorSection.getJoystick().getPressureButtons()[0].press();
        }

    }

    @Override
    public void pressFeeler() {
        if (this.operatorSection != null) {
            this.operatorSection.getJoystick().getFeeler().press();
        }
    }

    @Override
    public void tiltJoystick(int[] axis) {
        // The_Loraxxz komplex aufgabe :D :O
    }

    public void pressSwitch(SwitchType switchType) {
        if (this.operatorSection != null) {
            if (switchType == SwitchType.electroMotor) {
                if (this.operatorSection.getPanel().getMotorSwitch().isOn()) {
                    this.operatorSection.getPanel().getMotorSwitch().off();
                } else {
                    this.operatorSection.getPanel().getMotorSwitch().on();
                }
            } else if (switchType == SwitchType.groundSprayNozzles) {
                if(this.operatorSection.getPanel().getNozzleSwitch().isOn()) {
                    this.operatorSection.getPanel().getNozzleSwitch().on();
                } else {
                    this.operatorSection.getPanel().getNozzleSwitch().off();
                }
                
            } else {
                if (this.operatorSection.getPanel().getLightSwitches()[switchType.getValue()].isOn()) {
                    this.operatorSection.getPanel().getLightSwitches()[switchType.getValue()].off();
                } else {
                    this.operatorSection.getPanel().getLightSwitches()[switchType.getValue()].on();
                }

            }
        }
    }

    public void changeHeadKnobToType(KnopRoofStepsType type) {
        if (this.operatorSection != null) {
            this.operatorSection.getPanel().getKnobRoof().changeStep(type);
        }
    }

    public void changeFrontKnobToType(FrontWaterStepsType type) {
        if (operatorSection != null) {
            this.operatorSection.getPanel().getKnobFront().changeStep(type);
        }

    }

    public void sitDown(OperatorSection section) {
        this.operatorSection = section;
    }
}
