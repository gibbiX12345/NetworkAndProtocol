package protocol.serverToClient;

import com.google.gson.Gson;
import network.Message;
import protocol.SuperPlayerMessage;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class PlayerJoined extends SuperPlayerMessage {

    private Integer initialX;
    private Integer initialY;

    public Integer getInitialX() {
        return initialX;
    }

    public void setInitialX(Integer initialX) {
        this.initialX = initialX;
    }

    public Integer getInitialY() {
        return initialY;
    }

    public void setInitialY(Integer initialY) {
        this.initialY = initialY;
    }

    public PlayerJoined(String playerName, Integer initialX, Integer initialY) {
        super(playerName);
        this.initialX = initialX;
        this.initialY = initialY;
    }

    @Override
    public Message deserializeFromJson(String in) {
        Gson gson = new Gson();
        return gson.fromJson(in, PlayerJoined.class);
    }
}
