package Operator;

import main.java.Engine.ElectricMotor;
import main.java.ExtinguishDevices.FrontCannon;
import main.java.ExtinguishDevices.GroundSprayNozzles;
import main.java.ExtinguishDevices.HeadCannon;
import main.java.ExtinguishDevices.MixDevice;
import main.java.FLF.PositionType;
import main.java.Joystick.GeneralJoystick;
import main.java.Joystick.Joystick;
import main.java.Lights.Lights;
import main.java.Person.Operator;

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
