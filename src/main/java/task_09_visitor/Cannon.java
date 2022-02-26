package task_09_visitor;

import ExtinguishDevices.CannonState;
import task_02_SOA.Subscriber;

public abstract class Cannon extends Subscriber implements IControlRoutine {



    protected CannonState cannonState;

    protected Cannon() {
        this.cannonState = CannonState.inactive;
    }


    public abstract void pumpOut();
    public abstract void setCannonState(CannonState cannonState);

    public CannonState getCannonState() {
        return cannonState;
    }
}