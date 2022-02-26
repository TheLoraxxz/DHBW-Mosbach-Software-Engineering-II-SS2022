package task_09_visitor;

import ExtinguishDevices.FrontCannon;
import ExtinguishDevices.GroundSprayNozzles;
import ExtinguishDevices.HeadCannon;
import ExtinguishDevices.WaterTank;
import task_01_Components.MixDevice;

public interface ITestApplication {
    public boolean routine(GroundSprayNozzles type, WaterTank tank);
    public boolean routine(FrontCannon type, MixDevice device);
    public boolean routine(HeadCannon type,MixDevice device);
}
