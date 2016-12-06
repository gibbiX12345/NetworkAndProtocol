package protocol.serverToClient;

import com.google.gson.Gson;
import json.JSONObject;
import network.Message;
import protocol.SuperPlayerMessage;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class StartGame implements Message {

    private Object labyrinth;

    public Object getLabyrinth() {
        return labyrinth;
    }

    public void setLabyrinth(Object labyrinth) {
        this.labyrinth = labyrinth;
    }

    public StartGame(Object labyrinth) {
        this.labyrinth = labyrinth;
    }

    @Override
    public JSONObject serializeToGson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("labyrinth", labyrinth);
        return jsonObject;
    }

    @Override
    public Message deserializeFromJson(String in) {
        JSONObject jsonObject = new JSONObject(in);
        StartGame returnVal = new StartGame(jsonObject.getString("labyrinth"));
        return returnVal;
    }
}
