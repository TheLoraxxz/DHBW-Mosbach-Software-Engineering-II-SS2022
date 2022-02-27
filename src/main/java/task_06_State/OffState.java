package task_06_State;

public class OffState implements IButtonState{
    @Override
    public void switchState(Switch toSwitch) {
        toSwitch.setState(new OnState());

    }
}
