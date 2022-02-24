package Joystick;

import ExtinguishDevices.Cannon;
import ExtinguishDevices.CannonState;

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
