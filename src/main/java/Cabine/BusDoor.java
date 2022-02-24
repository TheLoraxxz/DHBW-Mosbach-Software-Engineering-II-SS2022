package Cabine;

import FLF.CentralUnit;
import FLF.PositionType;
import Person.FLFOperator;

public class BusDoor {
    private boolean isOpen,isUnlocked;
    private PositionType position;
    private DoorFeeler[] doorFeelers;
    private ReceiverModule receiverModule;

    public BusDoor(PositionType position, Seat[] seats, CentralUnit cUnit) {
        this.position = position;
        isUnlocked = true;
        isOpen = false;
        doorFeelers = new DoorFeeler[]{new DoorFeeler(this,true,seats),new DoorFeeler(this,false,seats)};
        receiverModule = new ReceiverModule(cUnit);
    }

    public DoorFeeler[] getDoorFeelers() {
        return doorFeelers;
    }
    public PositionType getPositionType() {
        return position;
    }
    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    public boolean isOpen() {
        return isOpen;
    }

    public void UseReceiverModule(FLFOperator flfOperator)
    {
        if(receiverModule.TransferIDCode(flfOperator.getId_card().getIDCode()))
            isUnlocked = !isUnlocked;
    }
}
