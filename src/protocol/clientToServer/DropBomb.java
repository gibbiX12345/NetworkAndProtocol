package protocol.clientToServer;

import protocol.SuperPlayerMessage;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class DropBomb extends SuperPlayerMessage {

    private Integer positionX;
    private Integer positionY;

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public DropBomb(String playerName, Integer positionX, Integer positionY) {
        super(playerName);
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
