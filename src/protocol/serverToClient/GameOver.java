package protocol.serverToClient;

import com.google.gson.Gson;
import json.JSONObject;
import network.Message;

import java.util.Map;

/**
 * Created by vmadmin on 31.10.2016.
 */
public class GameOver implements Message {

    private String winnerName;
    private Map<String, Integer> highscoreList; //{"playerOne" : 1 ; "playerTwo" : 2}

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public Map<String, Integer> getHighscoreList() {
        return highscoreList;
    }

    public void setHighscoreList(Map<String, Integer> highscoreList) {
        this.highscoreList = highscoreList;
    }

    public GameOver(String winnerName, Map<String, Integer> highscoreList) {
        this.winnerName = winnerName;
        this.highscoreList = highscoreList;
    }


    @Override
    public JSONObject serializeToGson() {
        JSONObject message = new JSONObject();
        message.put("winnerName", winnerName);
        message.put("highscoreList", highscoreList);
        message.put("className", this.getClass());
        return message;
    }

    @Override
    public Message deserializeFromJson(String in) {
        JSONObject jsonObject = new JSONObject(in);
        this.winnerName = jsonObject.getString("winnerName");
        this.highscoreList = (Map<String, Integer>) jsonObject.get("highscoreList");
        return this;
    }

}