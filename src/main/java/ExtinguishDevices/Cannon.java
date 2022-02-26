package ExtinguishDevices;

import task_02_SOA.Subscriber;

public abstract class Cannon extends Subscriber {



    protected CannonState cannonState;

    Cannon() {
        this.cannonState = CannonState.inactive;
    }

    public abstract void pumpOut();
    public abstract void setCannonState(CannonState cannonState);

    public CannonState getCannonState() {
        return cannonState;
    }
}
