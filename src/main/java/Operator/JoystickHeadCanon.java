package Operator;

import main.java.ExtinguishDevices.HeadCannon;
import main.java.FLF.PositionType;
import main.java.Joystick.JoyStickFeeler;
import main.java.Joystick.Joystick;
import main.java.Joystick.PressureButton;

public class JoystickHeadCanon extends Joystick {
    
    
    public JoystickHeadCanon(HeadCannon canon) {
        feeler = new JoyStickFeeler(canon);
        buttons = new PressureButton[]{new PressureButton(PositionType.left,canon), new PressureButton(PositionType.right,canon)};
    }   
}
