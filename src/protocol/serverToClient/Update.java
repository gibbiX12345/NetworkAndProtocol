package protocol.serverToClient;

import network.Message;

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
}
