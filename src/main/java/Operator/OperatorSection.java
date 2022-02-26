package Operator;

import ExtinguishDevices.FrontCannon;
import ExtinguishDevices.HeadCannon;
import FLF.CentralUnit;
import FLF.PositionType;
import Joystick.GeneralJoystick;
import Joystick.Joystick;
import Person.Operator;

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

    public OperatorSection(FrontCannon front, HeadCannon head, Joystick joystick, CentralUnit unit) {
        this.panel = new ControlPanel(front,head,unit);
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
