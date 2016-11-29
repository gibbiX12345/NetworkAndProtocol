package protocol.serverToClient;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import gson.MessageAdapter;
import gson.RuntimeTypeAdapterFactory;
import network.Message;
import sun.util.resources.cldr.as.LocaleNames_as;
import utils.GsonHelper;

import java.lang.reflect.Type;

/**
 * Created by vmadmin on 31.10.2016.
         */
public class Error implements Message {

    private String message;
    private Class $type = Error.class;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Error(String message) {
        this.message = message;
    }

    @Override
    public String serializeToGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Message.class, new MessageAdapter());
        Gson gsonExt = builder.create();
        return gsonExt.toJson(this, Message.class);
    }
}
