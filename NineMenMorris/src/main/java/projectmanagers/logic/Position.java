package main.java.projectmanagers.logic;

import main.java.projectmanagers.logic.GameStatuses.ColorStatus;

import static main.java.projectmanagers.logic.GameStatuses.ColorStatus.EMPTY;
import static main.java.projectmanagers.logic.GameStatuses.ColorStatus.INVALID;

public class Position {
    private ColorStatus colorStatus;
    private boolean millStatus;
    private MillConditions millConditionsX;
    private MillConditions millConditionsY;

    public Position() {
        this.colorStatus = INVALID;
        this.millStatus = false;
    }

    public Position(ColorStatus colorStatus) {
        this.colorStatus = colorStatus;
        this.millStatus = false;
    }

    public boolean determineMills() {
        if (millConditionsX.isMilled()) {
            return millConditionsY.determineMill();
        } else {
            return millConditionsX.determineMill();
        }
    }

    public void removePiece() {
        colorStatus = EMPTY;
        millConditionsX.unsetMillStatus();
        millConditionsY.unsetMillStatus();
    }
    public ColorStatus getStatus() {
        return colorStatus;
    }

    public void initialize(ColorStatus colorStatus, MillConditions millConditionsX, MillConditions millConditionsY){
        this.colorStatus = colorStatus;
        this.millConditionsX = millConditionsX;
        this.millConditionsY = millConditionsY;
    }

    public void setStatus(ColorStatus colorStatus) {
        this.colorStatus = colorStatus;
    }

    public void setMill(boolean millStatus) {
        this.millStatus = millStatus;
    }

    public boolean isMilled() {
        return millStatus;
    }
}
