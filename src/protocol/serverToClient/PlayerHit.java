package protocol.serverToClient;

import protocol.SuperPlayerMessage;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class PlayerHit extends SuperPlayerMessage {
    public PlayerHit(String playerName) {
        super(playerName);
    }
}
