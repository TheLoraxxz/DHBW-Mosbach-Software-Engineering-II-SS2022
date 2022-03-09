package ExtinguishDevices;

import task_01_Components.MixDevice;
import task_01_Components.MixDeviceCommunicator;
import task_09_visitor.Cannon;
import task_09_visitor.ITestApplication;

public class HeadCannon extends Cannon {

    private KnopRoofStepsType steps;
    private final Segments[] segments;

    public boolean isMovedOut() {
        return isMovedOut;
    }

    private boolean isMovedOut;
    private final MixDeviceCommunicator mixDevice;

    public HeadCannon(MixDeviceCommunicator mixing) {
        super();
        this.steps = KnopRoofStepsType.a;
        segments = new Segments[]{
                new Segments(true),
                new Segments(false)};
        this.mixDevice =mixing;
        isMovedOut = false;
    }

    public KnopRoofStepsType getSteps() {
        return steps;
    }

    public MixDeviceCommunicator getMixDevice() {
        return mixDevice;
    }

    public void setSteps(KnopRoofStepsType steps) {
        this.steps = steps;
    }

    @Override
    public void pumpOut() {
        this.mixDevice.defill(this.steps.getValue());
    }

    @Override
    public void setCannonState(CannonState cannonState) {
        if (cannonState==CannonState.active) {
            this.segments[0].setTiltDegree(90);
            for (PartSegments segment:this.segments[1].getPartSegments()) {
                segment.moveOut();
            }
            isMovedOut = true;
        } else {
            for (PartSegments segment:this.segments[1].getPartSegments()) {
                segment.moveIn();
            }
            isMovedOut = false;
            this.segments[0].setTiltDegree(0);
        }
        this.cannonState = cannonState;
    }

    @Override
    public boolean acceptTest(ITestApplication visitor) {
        return visitor.routine(this,mixDevice);
    }
}
