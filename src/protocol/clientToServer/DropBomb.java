package protocol.clientToServer;

import com.google.gson.Gson;
import json.JSONObject;
import network.Message;
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
    public DropBomb(){}

    @Override
    public JSONObject serializeToGson() {
        JSONObject superPlayerMessage = super.serializeToGson();
        superPlayerMessage.put("positionX", positionX);
        superPlayerMessage.put("positionY", positionY);
        superPlayerMessage.put("className", this.getClass().getName());
        return superPlayerMessage;
    }

    @Override
    public Message deserializeFromJson(String in) {
        JSONObject jsonObject = new JSONObject(in);
        SuperPlayerMessage superPlayerMessage = (SuperPlayerMessage) super.deserializeFromJson(in);
        this.setPlayerName(superPlayerMessage.getPlayerName());
        this.positionX = jsonObject.getInt("positionX");
        this.positionY = jsonObject.getInt("positionY");
        return this;
    }
}
