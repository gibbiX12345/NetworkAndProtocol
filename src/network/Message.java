package network;

/**
 * Alle Klassen f�r Nachrichten, welche zwischen dem Bomberman-Server und den Bomberman-Clients
 * ausgetauscht werden, m�ssen dieses Interface implementieren.
 * 
 * @author Andres Scheidegger
 *
 */
public interface Message {

    public abstract String serializeToGson();
}
