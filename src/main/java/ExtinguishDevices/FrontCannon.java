package ExtinguishDevices;

import task_01_Components.MixDevice;
import task_01_Components.MixDeviceCommunicator;
import task_09_visitor.Cannon;
import task_09_visitor.ITestApplication;

public class FrontCannon extends Cannon {
    private FrontWaterStepsType steps;

    private float tiltDegree;
    private MixDeviceCommunicator mixDevice;
    public FrontCannon(MixDeviceCommunicator mixer) {
        this.tiltDegree = 0;
        this.steps = FrontWaterStepsType.one;
        this.mixDevice = mixer;
    }

    @Override
    public void pumpOut() {
        this.mixDevice.defill(steps.getValue());
    }
    public MixDeviceCommunicator getMixDevice() {
        return mixDevice;
    }

    @Override
    public void setCannonState(CannonState cannonState) {
        if (cannonState==CannonState.active) {
            this.tiltDegree = 90;
        } else {
            this.tiltDegree =0;
        }
        this.cannonState = cannonState;
    }


    public void setSteps(FrontWaterStepsType steps) {
        this.steps = steps;
    }

    public FrontWaterStepsType getSteps() {
        return steps;
    }

    public float getTiltDegree() {
        return tiltDegree;
    }

    @Override
    public boolean acceptTest(ITestApplication visitor) {
        return visitor.routine(this,this.mixDevice);
    }
}
