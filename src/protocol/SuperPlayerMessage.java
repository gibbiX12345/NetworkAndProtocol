package protocol;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import gson.RuntimeTypeAdapterFactory;
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
    public String serializeToGson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
