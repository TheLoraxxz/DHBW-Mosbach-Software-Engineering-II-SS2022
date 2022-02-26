package Lights;

import FLF.PositionType;
import com.google.common.eventbus.Subscribe;
import task_02_SOA.SideLightsEvent;

public class SideLight extends Lights{

    public SideLight(PositionType pos) {
        super();
        this.position = pos;
    }

    @Subscribe
    public void recieve(SideLightsEvent event) {
        if (this.isOn()) {
            off();
        } else {
            on();
        }
    }
}
