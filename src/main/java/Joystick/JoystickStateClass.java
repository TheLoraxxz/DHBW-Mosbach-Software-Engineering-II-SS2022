package Joystick;

public class JoystickStateClass {
    private JoystickState state;
    private byte[] tiltDirection;
    JoystickStateClass() {
        this.state = JoystickState.idle;
        this.tiltDirection = new byte[2];
    }

    public void setState(JoystickState state) {
        this.state = state;
    }
    public JoystickState getState() {
        return state;
    }
    public boolean setTiltDirection(byte[] tiltDirection) {
        if(tiltDirection.length==2) {
            this.tiltDirection = tiltDirection;
            return true;
        }
        return false;
    }
    public byte[] getTiltDirection() {
        return tiltDirection;
    }

}
