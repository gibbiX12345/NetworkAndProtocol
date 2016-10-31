package protocol.clientToServer;

import protocol.SuperPlayerMessage;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class DropBomb extends SuperPlayerMessage {

    private Integer positionX;
    private Integer positionY;



    public DropBomb(String playerName, Integer positionX, Integer positionY) {
        super(playerName);
        this.positionX = positionX;
        this.positionY = positionY;
    }
}
