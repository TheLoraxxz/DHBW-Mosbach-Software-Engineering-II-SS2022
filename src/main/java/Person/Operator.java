package Person;

import ExtinguishDevices.FrontWaterStepsType;
import ExtinguishDevices.KnopRoofStepsType;
import Operator.OperatorSection;
import task_06_State.SwitchType;

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
                this.operatorSection.getPanel().getMotorSwitch().press();
            } else if (switchType == SwitchType.groundSprayNozzles) {
               this.operatorSection.getPanel().getNozzleSwitch().press();
            } else {
                this.operatorSection.getPanel().getLightSwitches()[switchType.getValue()].press();
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
