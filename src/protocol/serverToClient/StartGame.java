package protocol.serverToClient;

import com.google.gson.Gson;
import json.JSONObject;
import network.Message;
import protocol.SuperPlayerMessage;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class StartGame implements Message {

    private int[][] labyrinth;
    //0 - Luft
    //1 - Erde
    //2 - Fels

    public int[][] getLabyrinth() {
        return labyrinth;
    }

    public void setLabyrinth(int[][] labyrinth) {
        this.labyrinth = labyrinth;
    }

    public StartGame(int[][] labyrinth) {
        this.labyrinth = labyrinth;
    }

    public StartGame(){}
    @Override
    public JSONObject serializeToGson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("labyrinth", labyrinth);
        return jsonObject;
    }

    @Override
    public Message deserializeFromJson(String in) {
        JSONObject jsonObject = new JSONObject(in);
        StartGame returnVal = new StartGame((int[][]) jsonObject.get("labyrinth"));
        return returnVal;
    }
}
