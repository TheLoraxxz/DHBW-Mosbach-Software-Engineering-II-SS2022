package Joystick;

import main.java.ExtinguishDevices.Cannon;
import main.java.ExtinguishDevices.CannonState;
import main.java.ExtinguishDevices.FrontCannon;
import main.java.ExtinguishDevices.HeadCannon;
import main.java.FLF.PositionType;

public class PressureButton implements IFeeler {

    private PositionType position;

    protected Cannon cannon;

    public PressureButton(PositionType pos, Cannon cannon) {
        position = pos;
        this.cannon = cannon;
    }

    @Override
    public void press() {
        if (this.cannon instanceof FrontCannon) {
            FrontCannon canon = (FrontCannon) this.cannon;
            if (this.position == PositionType.left) {
                switch (canon.getCannonState()) {
                case active -> canon.setCannonState(CannonState.inactive);
                case inactive -> canon.setCannonState(CannonState.active);
                default -> canon.setCannonState(CannonState.inactive);
                }
            } else {
                if (cannon.getCannonState() == CannonState.active) {
                    canon.getMixDevice().setToNextMix();
                }
            }
        } else {
            HeadCannon canon = (HeadCannon) this.cannon;
            if (this.position == PositionType.left) {
                switch (cannon.getCannonState()) {
                case active -> canon.setCannonState(CannonState.inactive);
                case inactive -> canon.setCannonState(CannonState.active);
                default -> canon.setCannonState(CannonState.inactive);
                }
            } else {
                if (cannon.getCannonState() == CannonState.active) {
                    canon.getMixDevice().setToNextMix();
                }
            }
        }
    }

    public PositionType getPosition() {
        return position;
    }

    public Cannon getCannon() {
        return cannon;
    }
}
