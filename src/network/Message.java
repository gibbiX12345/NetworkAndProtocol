package network;

import json.JSONObject;

import java.io.Serializable;

/**
 * Alle Klassen f�r Nachrichten, welche zwischen dem Bomberman-Server und den Bomberman-Clients
 * ausgetauscht werden, m�ssen dieses Interface implementieren.
 * 
 * @author Andres Scheidegger
 *
 */
public interface Message extends Serializable {

    public abstract JSONObject serializeToGson();
    public abstract Message deserializeFromJson(String in);
}
