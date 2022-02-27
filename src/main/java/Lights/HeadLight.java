package Lights;

import FLF.PositionType;
import com.google.common.eventbus.Subscribe;
import task_02_SOA.HeadLightsFrontEvent;
import task_02_SOA.HeadLightsRoofEvent;

public class HeadLight extends Lights{

    public HeadLight(PositionType pos) {
        super();
        this.position = pos;
    }
    @Subscribe
    public void recieve(HeadLightsFrontEvent event) {
        if (this.position==PositionType.frontleftbottom || this.position==PositionType.frontrightbottom) {
            if (isOn()) {
                this.off();
            } else {
                this.on();
            }
        }
    }

    @Subscribe
    public void recieve(HeadLightsRoofEvent event) {
        if (this.position==PositionType.frontop) {
            if (isOn()) {
                this.off();
            } else {
                this.on();
            }
        }
    }
}
