package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sun.corba.se.impl.presentation.rmi.ExceptionHandlerImpl;
import gson.MessageAdapter;
import json.JSONObject;
import network.Message;

/**
 * Created by vmadmin on 21.11.2016.
 */
public class GsonHelper {

    public static Message deserializeFromJson(String in){
        JSONObject object = new JSONObject(in);
        String className = object.getString("className");
        try {
            Class mClass = Class.forName(className);
            Message message = (Message) mClass.newInstance();
            return message.deserializeFromJson(in);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
