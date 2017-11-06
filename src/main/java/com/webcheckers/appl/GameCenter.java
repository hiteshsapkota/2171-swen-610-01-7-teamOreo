package com.webcheckers.appl;

import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.model.WebCheckerGame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.Session;

import static com.webcheckers.model.Strings.USER_SESSION_ATTRIBUTE;

public class GameCenter {

    private Map<String, OnlinePlayers> allPlayers = new HashMap<>();
    private ArrayList<WebCheckerGame> allGames = new ArrayList();


    /**
     *  To add player in the all players list
     * @param session : The browser session of the player.
     * @param username : The name of the user.
     */
    public void login(Session session, String username){
        OnlinePlayers player = new OnlinePlayers(username);
        session.attribute("user", player);
        this.allPlayers.put(username, player);
    }

    /**
     *  To remove the player in the all players list.
     * @param session
     */
    public void logout(Session session){
        String username = ((OnlinePlayers) session.attribute(USER_SESSION_ATTRIBUTE)).getName();
        session.removeAttribute(USER_SESSION_ATTRIBUTE);
        this.allPlayers.remove(username);
    }

    /**
     * To check if the username already exists.
     * @param username
     * @return
     */
    public boolean userAlreadyExists(String username){
        return this.allPlayers.keySet().contains(username);
    }

    /**
     * To check if the user is currently in a game.
     * @param username
     * @return
     */
    public boolean userIsFree(String username){
        return allPlayers.get(username).isFree();
    }

    public OnlinePlayers getPlayer(String username){
        return this.allPlayers.get(username);
    }

    /**
     * To give out all available players.
     * @return
     */
    public ArrayList<String> getAllAvailablePlayers(){
        ArrayList<String> players = new ArrayList<>();
        for(OnlinePlayers player: allPlayers.values()){
            if(player.isFree()){
                players.add(player.getName());
            }
        }
        return players;
    }

    public WebCheckerGame addGame(String player1, String player2){
        WebCheckerGame game = new WebCheckerGame(player1, player2);
        getPlayer(player1).setFree(false);
        getPlayer(player2).setFree(false);
        allGames.add(game);
        return game;
    }

    public WebCheckerGame getGame(String username){
        for(WebCheckerGame game: allGames){
            if(game.hasPlayer(username)){
                return game;
            }
        }
        return null;
    }
}
