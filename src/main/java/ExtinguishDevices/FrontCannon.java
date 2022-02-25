package ExtinguishDevices;

import task_01_Components.MixDevice;

public class FrontCannon extends Cannon {
    private FrontWaterStepsType steps;

    private float tiltDegree;
    private MixDevice mixDevice;
    public FrontCannon(MixDevice mixer) {
        this.tiltDegree = 0;
        this.steps = FrontWaterStepsType.one;
        this.mixDevice = mixer;
    }

    @Override
    public void pumpOut() {
        this.mixDevice.defill(steps.getValue());
    }
    public MixDevice getMixDevice() {
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
}
