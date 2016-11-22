package protocol.serverToClient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import network.Message;
import protocol.SuperPlayerMessage;

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

    @Override
    public String serializeToGson() {
        Gson gson = new Gson();
        return gson.toJson(this, new TypeToken<Error>(){}.getType());
    }

}
