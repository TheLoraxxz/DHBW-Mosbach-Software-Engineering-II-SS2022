package task_01_Components;

public enum MixType {
    three(3),
    five(5),
    ten(10),
    zero(0);
    private final int value;
    MixType(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
}
