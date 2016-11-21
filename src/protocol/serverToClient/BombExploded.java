package protocol.serverToClient;

import com.google.gson.Gson;
import network.Message;
import protocol.SuperPlayerMessage;

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

    @Override
    public String serializeToGson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
