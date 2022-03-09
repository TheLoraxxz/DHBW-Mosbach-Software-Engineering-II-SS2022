package Engine;

import com.google.common.eventbus.Subscribe;
import task_02_SOA.MotorEvent;
import task_02_SOA.Subscriber;
import task_05_Adapter.Box;
import FLF.Status;

public class ElectricMotor extends Subscriber {
    private final Box box;
    
    public ElectricMotor(Box box) {
        this.box = box;
    }

    public void changeSpeed(double speed) {
        if(box.getStatus() == Status.use) {
            box.takeOut(speed*12.5);
        }
    }

    public void setOn(boolean on) {
        if(on) {
            box.turnOn();
        } else {
            box.turnOf();
        }
        
    }

    public boolean isOn() {
        return box.getStatus()==Status.use;
    }

    @Subscribe
    public void recieve(MotorEvent event) {
        setOn(!isOn());
    }
}
