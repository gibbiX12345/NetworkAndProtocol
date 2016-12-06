package protocol.serverToClient;

import com.google.gson.Gson;
import json.JSONObject;
import network.Message;

import java.util.Map;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class Update implements Message {

    private Object labyrinth;

    public Object getLabyrinth() {
        return labyrinth;
    }

    public void setLabyrinth(Object labyrinth) {
        this.labyrinth = labyrinth;
    }

    public Update(Object labyrinth) {
        this.labyrinth = labyrinth;
    }

    public Update(){}

    @Override
    public JSONObject serializeToGson() {
        JSONObject message = new JSONObject();
        message.put("labyrinth", labyrinth);
        message.put("className", this.getClass().getName());
        return message;
    }

    @Override
    public Message deserializeFromJson(String in) {
        JSONObject jsonObject = new JSONObject(in);
        this.labyrinth = jsonObject.getString("labyrinth");
        return this;
    }

}
