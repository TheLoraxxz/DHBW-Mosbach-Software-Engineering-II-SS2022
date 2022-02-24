package Operator;

import ExtinguishDevices.HeadCannon;
import ExtinguishDevices.KnopRoofStepsType;

public class KnobRoofWaterCanon {

    private HeadCannon canon;

    KnobRoofWaterCanon(HeadCannon canon) {
        this.canon = canon;
    }

    public void changeStep(KnopRoofStepsType step) {
        this.canon.setSteps(step);
    }
}
