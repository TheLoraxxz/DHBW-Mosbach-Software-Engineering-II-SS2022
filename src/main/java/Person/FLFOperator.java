package Person;


public abstract class FLFOperator extends Person{
    public ID_Card getId_card() {
        return id_card;
    }

    protected ID_Card id_card;
    public abstract void pressJoystickRight();
    public abstract void pressJoystickLeft();
    public abstract void pressFeeler();
    public abstract void tiltJoystick(byte[] axis);
}
