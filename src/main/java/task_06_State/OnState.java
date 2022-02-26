package task_06_State;

public class OnState implements IButtonState{
    @Override
    public void switchState(Switch toSwitch) {
        toSwitch.setState(new OffState());
    }
}
