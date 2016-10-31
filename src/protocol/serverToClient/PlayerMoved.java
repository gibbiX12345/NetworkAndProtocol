package protocol.serverToClient;

import protocol.SuperPlayerMessage;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class PlayerMoved extends SuperPlayerMessage {

    private String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public PlayerMoved(String playerName, String direction) {
        super(playerName);
        this.direction = direction;
    }
}