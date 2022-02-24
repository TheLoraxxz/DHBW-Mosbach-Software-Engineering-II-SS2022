package Operator;

import main.java.ExtinguishDevices.HeadCannon;
import main.java.ExtinguishDevices.KnopRoofStepsType;

public class KnobRoofWaterCanon {

    private HeadCannon canon;

    KnobRoofWaterCanon(HeadCannon canon) {
        this.canon = canon;
    }

    public void changeStep(KnopRoofStepsType step) {
        this.canon.setSteps(step);
    }
}
