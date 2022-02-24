package ExtinguishDevices;

public enum KnopRoofStepsType {
    a(500),
    b(1000),
    c(2500);
    private int value;
    private KnopRoofStepsType(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
}
