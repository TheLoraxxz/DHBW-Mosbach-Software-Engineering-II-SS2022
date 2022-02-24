package Joystick;

import main.java.ExtinguishDevices.Cannon;
import main.java.ExtinguishDevices.CannonState;

public class JoyStickFeeler implements IFeeler{

    protected Cannon canon;

    public JoyStickFeeler(Cannon canon) {
        this.canon = canon;
    }
    @Override
    public void press() {
        if(canon.getCannonState()==CannonState.active) {
            canon.pumpOut();
        }
    }
}
