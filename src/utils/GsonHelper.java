package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import gson.MessageAdapter;
import network.Message;

/**
 * Created by vmadmin on 21.11.2016.
 */
public class GsonHelper {

    public static Message deserializeFromJson(String in){
        Gson gsonExt;
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Message.class   , new MessageAdapter());
        gsonExt = builder.create();
        return gsonExt.fromJson(in, Message.class);
    }
}
