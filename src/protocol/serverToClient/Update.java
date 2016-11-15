package protocol.serverToClient;

import com.google.gson.Gson;
import network.Message;
import protocol.SuperPlayerMessage;

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


    @Override
    public String serializeToGson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public Message deserializeFromJson(String in) {
        Gson gson = new Gson();
        return gson.fromJson(in, Update.class);
    }
}
