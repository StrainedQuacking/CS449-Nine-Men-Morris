package main.java.projectmanagers.logic;

import main.java.projectmanagers.logic.GameStatuses.ColorStatus;

import static main.java.projectmanagers.logic.GameStatuses.ColorStatus.INVALID;

public class Position {
    private ColorStatus colorStatus;
    private boolean millStatus;
    Position() {
        this.colorStatus = INVALID;
        this.millStatus = false;
    }

    Position(ColorStatus colorStatus) {
        this.colorStatus = colorStatus;
        this.millStatus = false;
    }

    ColorStatus getStatus() {
        return colorStatus;
    }

    void setStatus(ColorStatus colorStatus) {
        this.colorStatus = colorStatus;
    }

    boolean isMilled() {
        return millStatus;
    }
}
