package ExtinguishDevices;

//step x500 to get the actual Value

public enum FrontWaterStepsType {
    one(500),
    two(1000),
    three(1500),
    four(2000),
    five(2500),
    six(3000),
    seven(3500);
    private final int value;
    FrontWaterStepsType(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
}
