package Driver;

import Engine.PivotTurnable;
import FLF.PositionType;
import Lights.TurnSignalLight;

public class SteeringWheel {
    private final TurnSignalLight[] lights;

    public PivotTurnable[] getTurnables() {
        return turnables;
    }

    private final PivotTurnable [] turnables;
    public SteeringWheel(TurnSignalLight[] lights,PivotTurnable[] turnables) {
        this.lights = lights;
        this.turnables = turnables;
    }
    public void turn(float turnDegree) {
        for(PivotTurnable pivot:turnables) {
            pivot.setTurningValue(turnDegree);
        }
        if(turnDegree>0) {
            for (TurnSignalLight turnSignalLight : lights) {
                if(turnSignalLight.getPosition()==PositionType.frontrightbottom||turnSignalLight.getPosition()==PositionType.backrightbottom) {
                    turnSignalLight.on();
                } else {
                    turnSignalLight.off();
                }
            }
        } else {
            for (TurnSignalLight turnSignalLight : lights) {
                if(turnSignalLight.getPosition()==PositionType.frontrightbottom||turnSignalLight.getPosition()==PositionType.backrightbottom) {
                    turnSignalLight.off();
                } else {
                    turnSignalLight.on();
                }
            }
        }
    }
}
