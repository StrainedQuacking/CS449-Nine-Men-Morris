package main.java.projectmanagers.logic;

import main.java.projectmanagers.logic.GameStatuses.ColorStatus;

import static main.java.projectmanagers.logic.GameStatuses.ColorStatus.EMPTY;
import static main.java.projectmanagers.logic.GameStatuses.ColorStatus.INVALID;

public class Position {
    private ColorStatus colorStatus;
    private MillConditions millConditionsX;
    private MillConditions millConditionsY;

    public Position() {
        this.colorStatus = INVALID;
    }

    public boolean determineMills() {
        boolean millY = millConditionsY.determineMill();
        boolean millX = millConditionsX.determineMill();

        return (millX || millY);
    }

    public void removePiece() {
        colorStatus = EMPTY;
        millConditionsX.unsetMillStatus();
        millConditionsY.unsetMillStatus();
    }
    public ColorStatus getStatus() {
        return colorStatus;
    }

    public void initialize(MillConditions millConditionsX, MillConditions millConditionsY){
        this.colorStatus = EMPTY;
        this.millConditionsX = millConditionsX;
        this.millConditionsY = millConditionsY;
    }

    public void setStatus(ColorStatus colorStatus) {
        this.colorStatus = colorStatus;
    }

    public boolean isMilled() {
        if (colorStatus == INVALID) {
            return false;
        }

        boolean mill1 = millConditionsX.isMilled();
        boolean mill2 = millConditionsY.isMilled();
        return (mill1 || mill2);
    }
}
