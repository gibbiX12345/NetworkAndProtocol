package protocol.serverToClient;

import com.google.gson.Gson;
import network.Message;
import protocol.SuperPlayerMessage;

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
    public String serializeToGson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public Message deserializeFromJson(String in) {
        Gson gson = new Gson();
        return gson.fromJson(in, GameOver.class);
    }
}