package Operator;

import ExtinguishDevices.HeadCannon;
import FLF.PositionType;
import Joystick.JoyStickFeeler;
import Joystick.Joystick;
import Joystick.PressureButton;

public class JoystickHeadCanon extends Joystick {
    
    
    public JoystickHeadCanon(HeadCannon canon) {
        feeler = new JoyStickFeeler(canon);
        buttons = new PressureButton[]{new PressureButton(PositionType.left,canon), new PressureButton(PositionType.right,canon)};
    }   
}
