package Lights;

import FLF.PositionType;
import com.google.common.eventbus.Subscribe;

public class BreakLight extends Lights{

    public BreakLight(PositionType pos) {
        super();
        this.position = pos;
    }
}
