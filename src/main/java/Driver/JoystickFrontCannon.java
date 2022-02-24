package Driver;

import ExtinguishDevices.FrontCannon;
import FLF.PositionType;
import Joystick.JoyStickFeeler;
import Joystick.Joystick;
import Joystick.PressureButton;

public class JoystickFrontCannon extends Joystick{

    public JoystickFrontCannon(FrontCannon canon) {
        super();

        feeler = new JoyStickFeeler(canon);
        buttons = new PressureButton[]{new PressureButton(PositionType.left,canon), new PressureButton(PositionType.right,canon)};
    }   
}
