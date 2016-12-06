package protocol.clientToServer;

import com.google.gson.Gson;
import json.JSONObject;
import network.Message;
import protocol.SuperPlayerMessage;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class MovePlayer extends SuperPlayerMessage {

    private String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public MovePlayer(String playerName, String direction) {
        super(playerName);
        this.direction = direction;
    }


    @Override
    public JSONObject serializeToGson() {
        JSONObject superPlayerMessage = super.serializeToGson();
        superPlayerMessage.put("direction", direction);
        superPlayerMessage.put("className", this.getClass());
        return superPlayerMessage;
    }

    @Override
    public Message deserializeFromJson(String in) {
        JSONObject jsonObject = new JSONObject(in);
        SuperPlayerMessage superPlayerMessage = (SuperPlayerMessage) super.deserializeFromJson(in);
        this.setPlayerName(superPlayerMessage.getPlayerName());
        this.direction = jsonObject.getString("direction");
        return this;
    }

}
