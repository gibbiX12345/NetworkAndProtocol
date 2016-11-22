package protocol.serverToClient;

import com.google.gson.Gson;
import network.Message;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class BombDropped implements Message {

    private Integer id;
    private Integer positionX;
    private Integer positionY;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public BombDropped(Integer id, Integer positionX, Integer positionY) {
        this.id = id;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public String serializeToGson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
