package protocol.serverToClient;

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
}
