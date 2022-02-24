package Joystick;

import main.java.ExtinguishDevices.FrontCannon;
import main.java.ExtinguishDevices.HeadCannon;

public class GeneralJoystickFeeler extends JoyStickFeeler {
    JoystickStateClass state;
    FrontCannon front;
    public GeneralJoystickFeeler(HeadCannon head,FrontCannon front,JoystickStateClass state) {
        super(head);
        this.front = front;
        this.state = state;
    }

    @Override
    public void press() {
        if(this.state.getState()==JoystickState.frontCanon) {
            this.front.pumpOut();
        }
        if(this.state.getState()==JoystickState.headCannon) {
            canon.pumpOut();
        }
    }
    
}
