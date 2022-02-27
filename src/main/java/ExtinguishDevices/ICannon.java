package ExtinguishDevices;

import task_01_Components.MixType;

public interface ICannon {
    public void pumpOut(MixType mixType);
    public void setCannonState(CannonState cannonState);
}
