package Joystick;

import ExtinguishDevices.FrontCannon;
import ExtinguishDevices.HeadCannon;
import FLF.PositionType;

public class GeneralPressureButton extends PressureButton implements ISpecialFeeler {
    private FrontCannon front;
    private JoystickStateClass state;
    public GeneralPressureButton(HeadCannon head,FrontCannon front,JoystickStateClass state) {
        super(PositionType.frontop, head);
        this.front = front;
        this.state = state;
    }

    @Override
    public void release() {
        if(this.state.getState()==JoystickState.selecting) {
            this.state.setState(JoystickState.idle);
        }
    }

    @Override
    public void press() {
        if(this.state.getState()==JoystickState.idle) {
            this.state.setState(JoystickState.selecting);
        } else if(this.state.getState()==JoystickState.frontCanon||this.state.getState()==JoystickState.headCannon) {
            byte x = this.state.getTiltDirection()[0];
            byte y = this.state.getTiltDirection()[1];
            if(x!=0||y!=0) {
                if(this.state.getState()==JoystickState.frontCanon) {
                    front.getMixDevice().setToNextMix();
                } else {
                    HeadCannon head =(HeadCannon) this.cannon;
                    head.getMixDevice().setToNextMix();
                }
            } else {
                this.state.setState(JoystickState.selecting);
            }
        }
    }
    
}
