package Operator;

public abstract class Switch {

    protected SwitchType switchTypeOperation;
    protected boolean on;


    Switch(SwitchType type) {
        this.switchTypeOperation = type;
        this.on = false;
    }

    public abstract void on();

    public abstract void off();


    public SwitchType getSwitchTypeOperation() {
        return switchTypeOperation;
    }
    public boolean isOn() {
        return on;
    }
}
