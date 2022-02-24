package Operator;

import main.java.ExtinguishDevices.FrontCannon;
import main.java.ExtinguishDevices.FrontWaterStepsType;

public class KnobFrontWaterCanon{

    private FrontCannon canon;

    KnobFrontWaterCanon(FrontCannon frontCannon) {
            this.canon = frontCannon;
    }

    public void changeStep(FrontWaterStepsType step) {
        this.canon.setSteps(step);
    }
}
