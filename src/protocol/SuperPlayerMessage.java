package protocol;

import network.Message;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class SuperPlayerMessage implements Message {

    public String playerName;

    public SuperPlayerMessage(String playerName) {
        this.playerName = playerName;
    }

}
