package protocol.serverToClient;

import com.google.gson.Gson;
import json.JSONObject;
import network.Message;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class BombExploded implements Message {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BombExploded(Integer id) {
        this.id = id;
    }


    public BombExploded(){}
    @Override
    public JSONObject serializeToGson() {
        JSONObject message = new JSONObject();
        message.put("id", id);
        message.put("className", this.getClass().getName());
        return message;
    }

    @Override
    public Message deserializeFromJson(String in) {
        JSONObject jsonObject = new JSONObject(in);
        this.id = jsonObject.getInt("id");
        return this;
    }
}
