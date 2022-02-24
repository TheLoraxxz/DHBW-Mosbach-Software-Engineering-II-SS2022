package ExtinguishDevices;

public class GroundSprayNozzles extends Cannon {
    private WaterTank waterTank;
    public GroundSprayNozzles(WaterTank tank) {
        super();
        this.waterTank = tank;
    }
    @Override
    public void pumpOut() {
        if(this.cannonState == CannonState.throwingExtinguishMedium) {
            this.waterTank.takeOut(100);
        }
        
    }

    @Override
    public void setCannonState(CannonState cannonState) {
        if(cannonState==CannonState.inactive) {
            this.cannonState =CannonState.inactive;
        } else {
            this.cannonState = CannonState.throwingExtinguishMedium;
        }
    }
}
