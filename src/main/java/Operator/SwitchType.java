package Operator;


public enum SwitchType {
    electroMotor(-1),
    groundSprayNozzles(-2),
    headLightsFront(3),
    warningLights(2),
    headLightsRoof(4),
    SideLights(1),
    BlueLights(0);
    private int value;
    private SwitchType(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
}
