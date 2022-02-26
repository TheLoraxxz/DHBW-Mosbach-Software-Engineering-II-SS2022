package Lights;

import FLF.PositionType;
import com.google.common.eventbus.Subscribe;

public class TurnSignalLight extends Lights{

    public TurnSignalLight(PositionType pos) {
        super();
        this.position = pos;
    }
}
