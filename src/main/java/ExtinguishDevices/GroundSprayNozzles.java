package ExtinguishDevices;

import com.google.common.eventbus.Subscribe;
import task_02_SOA.GroundSprayNozzlesEvent;
import task_09_visitor.Cannon;
import task_09_visitor.ITestApplication;

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

    @Subscribe
    public void recieve(GroundSprayNozzlesEvent event) {
        setCannonState(CannonState.throwingExtinguishMedium);
        this.pumpOut();
        setCannonState(CannonState.inactive);
    }

    @Override
    public boolean acceptTest(ITestApplication visitor) {
        return visitor.routine(this,waterTank);
    }
}
