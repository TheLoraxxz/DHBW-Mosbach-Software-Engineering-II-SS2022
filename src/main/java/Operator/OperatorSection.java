package Operator;

import Engine.ElectricMotor;
import ExtinguishDevices.FrontCannon;
import ExtinguishDevices.GroundSprayNozzles;
import ExtinguishDevices.HeadCannon;
import ExtinguishDevices.MixDevice;
import FLF.PositionType;
import Joystick.GeneralJoystick;
import Joystick.Joystick;
import Lights.Lights;
import Person.Operator;

import java.util.HashMap;

public class OperatorSection {

    final PositionType positionRelativeToControlPanel =PositionType.right;

    public Joystick getJoystick() {
        if(joystick!=null) {
            return joystick;
        } else {
            return gJoystick;
        }
    }

    private ControlPanel panel;
    private JoystickHeadCanon joystick;
    private GeneralJoystick gJoystick;
    private Operator operator;

    public OperatorSection(FrontCannon front, HeadCannon head, HashMap<SwitchType, Lights[]> lights, ElectricMotor[] motor, MixDevice mixing,Joystick joystick,GroundSprayNozzles[] nozzle) {
        this.panel = new ControlPanel(front,head,lights,motor,nozzle);
        if(this.joystick==null) {
            this.joystick = new JoystickHeadCanon(head);
        } else {
            this.gJoystick = (GeneralJoystick) joystick;
        }
        
    }


    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public PositionType getPositionRelativeToControlPanel() {
        return positionRelativeToControlPanel;
    }

    public ControlPanel getPanel() {
        return panel;
    }

    public Operator getOperator() {
        return operator;
    }
}
