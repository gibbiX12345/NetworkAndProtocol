package protocol;

import json.JSONObject;
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

    @Override
    public JSONObject serializeToGson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("playerName", playerName);
        return jsonObject;
    }

    @Override
    public Message deserializeFromJson(String in) {
        JSONObject jsonObject = new JSONObject(in);
        SuperPlayerMessage returnVal = new SuperPlayerMessage(jsonObject.getString("playerName"));
        return returnVal;
    }
}
