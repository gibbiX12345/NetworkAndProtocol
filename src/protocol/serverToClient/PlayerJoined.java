package protocol.serverToClient;

import com.google.gson.Gson;
import json.JSONObject;
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

    public PlayerJoined(){}

    @Override
    public JSONObject serializeToGson() {
        JSONObject superPlayerMessage = super.serializeToGson();
        superPlayerMessage.put("initialX", initialX);
        superPlayerMessage.put("initialY", initialY);
        superPlayerMessage.put("className", this.getClass().getName());
        return superPlayerMessage;
    }

    @Override
    public Message deserializeFromJson(String in) {
        JSONObject jsonObject = new JSONObject(in);
        SuperPlayerMessage superPlayerMessage = (SuperPlayerMessage) super.deserializeFromJson(in);
        this.setPlayerName(superPlayerMessage.getPlayerName());
        this.initialX = jsonObject.getInt("initialX");
        this.initialY = jsonObject.getInt("initialY");
        return this;
    }
}
