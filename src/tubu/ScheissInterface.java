package tubu;

import network.Message;
import network.client.ClientApplicationInterface;

/**
 * Created by vmadmin on 22.11.2016.
 */
public class ScheissInterface implements ClientApplicationInterface {
    @Override
    public void handleMessage(Message message) {
        System.out.println("wow e nachricht lol xdxd");
    }
}
