package network;

import com.google.gson.Gson;
import protocol.SuperPlayerMessage;

/**
 * Created by vmadmin on 31.10.2016.
 */
public interface Message {

    public abstract String serializeToGson();

    public abstract Message deserializeFromJson(String in);
}
