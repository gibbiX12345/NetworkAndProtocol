package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.RuntimeTypeAdapterFactory;
import network.Message;
import protocol.clientToServer.DropBomb;
import protocol.clientToServer.JoinGame;
import protocol.clientToServer.MovePlayer;
import protocol.serverToClient.*;
import protocol.serverToClient.Error;

/**
 * Created by vmadmin on 21.11.2016.
 */
public class GsonHelper {

    public static Message deserializeFromJson(String in){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(Message.class, "$type").registerSubtype(DropBomb.class));
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(Message.class, "$type").registerSubtype(JoinGame.class));
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(Message.class, "$type").registerSubtype(MovePlayer.class));
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(Message.class, "$type").registerSubtype(BombDropped.class));
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(Message.class, "$type").registerSubtype(BombExploded.class));
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(Message.class, "$type").registerSubtype(Error.class));
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(Message.class, "$type").registerSubtype(GameOver.class));
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(Message.class, "$type").registerSubtype(PlayerHit.class));
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(Message.class, "$type").registerSubtype(PlayerJoined.class));
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(Message.class, "$type").registerSubtype(PlayerMoved.class));
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(Message.class, "$type").registerSubtype(StartGame.class));
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(Message.class, "$type").registerSubtype(Update.class));
        Gson gson = builder.create();
        return gson.fromJson(in, Message.class);

    }
}
