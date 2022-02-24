package ExtinguishDevices;

public abstract class Cannon {



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
