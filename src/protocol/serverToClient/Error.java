package protocol.serverToClient;

import network.Message;

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
}
