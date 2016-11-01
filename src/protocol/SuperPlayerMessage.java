package protocol;

import network.Message;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class SuperPlayerMessage implements Message {

    private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public SuperPlayerMessage(String playerName) {
        this.playerName = playerName;
    }

}
