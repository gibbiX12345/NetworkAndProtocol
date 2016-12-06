package protocol.serverToClient;

import com.google.gson.*;
import gson.MessageAdapter;
import json.JSONObject;
import network.Message;

/**
 * Created by vmadmin on 31.10.2016.
         */
public class Error implements Message {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Error(String message) {
        this.message = message;
    }

    public Error(){}


    @Override
    public JSONObject serializeToGson() {
        JSONObject message = new JSONObject();
        message.put("message", this.message);
        message.putOpt("className", this.getClass().getName());
        return message;
    }

    @Override
    public Message deserializeFromJson(String in) {
        JSONObject jsonObject = new JSONObject(in);
        this.message = jsonObject.getString("message");
        return this;
    }
}
