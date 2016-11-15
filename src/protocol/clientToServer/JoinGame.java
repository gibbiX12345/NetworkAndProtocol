package protocol.clientToServer;

import com.google.gson.Gson;
import network.Message;
import protocol.SuperPlayerMessage;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class JoinGame extends SuperPlayerMessage {
    public JoinGame(String playerName) {
        super(playerName);
    }

    @Override
    public Message deserializeFromJson(String in) {
        Gson gson = new Gson();
        return gson.fromJson(in, JoinGame.class);
    }
}
