package protocol.clientToServer;

import com.google.gson.Gson;
import json.JSONObject;
import network.Message;
import protocol.SuperPlayerMessage;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class JoinGame extends SuperPlayerMessage {
    public JoinGame(String playerName) {
        super(playerName);
    }

    public JoinGame(){}

    @Override
    public JSONObject serializeToGson() {
        JSONObject superPlayerMessage = super.serializeToGson();
        superPlayerMessage.put("className", this.getClass().getName());
        return superPlayerMessage;
    }

    @Override
    public Message deserializeFromJson(String in) {
        SuperPlayerMessage superPlayerMessage = (SuperPlayerMessage) super.deserializeFromJson(in);
        this.setPlayerName(superPlayerMessage.getPlayerName());
        return this;
    }
}
