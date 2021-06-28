package de.dracoon.model;

/**
 * @author priyatham.bolli
 */
public class EncryptionInfo {

    private String userKeyState;
    private String roomKeyState;
    private String dataSpaceKeyState;

    public String getUserKeyState() {
        return userKeyState;
    }

    public void setUserKeyState(String userKeyState) {
        this.userKeyState = userKeyState;
    }

    public String getRoomKeyState() {
        return roomKeyState;
    }

    public void setRoomKeyState(String roomKeyState) {
        this.roomKeyState = roomKeyState;
    }

    public String getDataSpaceKeyState() {
        return dataSpaceKeyState;
    }

    public void setDataSpaceKeyState(String dataSpaceKeyState) {
        this.dataSpaceKeyState = dataSpaceKeyState;
    }
}
