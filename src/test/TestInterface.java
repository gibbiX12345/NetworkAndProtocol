package test;

import network.Message;
import network.client.ClientApplicationInterface;
import protocol.serverToClient.Error;

/**
 * Created by vmadmin on 22.11.2016.
 */
public class TestInterface implements ClientApplicationInterface {
    @Override
    public void handleMessage(Message message) {
        Error error = (Error) message;
        System.out.println(error.getMessage());
    }
}
