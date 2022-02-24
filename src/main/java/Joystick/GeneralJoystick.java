package Joystick;

import main.java.ExtinguishDevices.CannonState;
import main.java.ExtinguishDevices.FrontCannon;
import main.java.ExtinguishDevices.HeadCannon;

public class GeneralJoystick extends Joystick {
    private JoystickStateClass state;
    private FrontCannon front;
    private HeadCannon head;
    public GeneralJoystick(FrontCannon front, HeadCannon head) {
        this.state = new JoystickStateClass();
        this.buttons = new PressureButton[] { new GeneralPressureButton(head, front, this.state) };
        this.feeler = new GeneralJoystickFeeler(head, front, state);
    }

    public void tilt(byte[] tiltDirection) { // [0] --> x if greater than zero --> right / [1] --> y if greater than zero up (like kartesian system)
        if (this.state.setTiltDirection(tiltDirection)) {
            if (this.state.getState() == JoystickState.selecting) {
                byte x = tiltDirection[0];
                byte y = tiltDirection[1];
                if(y==0) {
                    if(x>0) {
                        this.head.setCannonState(CannonState.inactive);
                    } else {
                        this.front.setCannonState(CannonState.inactive);
                    }
                } else if(x==0) {
                    if(y>0) {
                        this.front.setCannonState(CannonState.active);
                        this.state.setState(JoystickState.frontCanon);
                    } else {
                        this.head.setCannonState(CannonState.active);
                        this.state.setState(JoystickState.headCannon);
                    }
                }
            }
        }

    }

    @Override
    public GeneralJoystickFeeler getFeeler() {
        GeneralJoystickFeeler t = (GeneralJoystickFeeler) this.feeler;
        return t;
    }

    @Override
    public GeneralPressureButton[] getPressureButtons() {
        GeneralPressureButton[] t = new GeneralPressureButton[] { (GeneralPressureButton) this.buttons[0] };
        return t;
    }
}
