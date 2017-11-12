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
     * @param session to remove the attribute
     */
    public void logout(Session session){
        String username = ((OnlinePlayers) session.attribute(USER_SESSION_ATTRIBUTE)).getName();
        session.removeAttribute(USER_SESSION_ATTRIBUTE);
        this.allPlayers.remove(username);
    }

    /**
     * To check if the username already exists.
     * @param username the username to check.
     * @return returns true if the username exist.
     */
    public boolean userAlreadyExists(String username){
        return this.allPlayers.keySet().contains(username);
    }

    /**
     * To check if the user is currently in a game.
     * @param username the username to check.
     * @return returns true if its free.
     */
    public boolean userIsFree(String username){
        return allPlayers.get(username).isFree();
    }

    /**
     * gets the player
     * @param username current session.
     * @return {@link OnlinePlayers} object of the player.
     */
    public OnlinePlayers getPlayer(String username){
        return this.allPlayers.get(username);
    }

    /**
     * To give out all available players.
     * @return an {@link ArrayList} of all the players.
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

    /**
     * Creates a new {@link WebCheckerGame} for the two players.
     * @param player1 player.
     * @param player2 opponent.
     * @return {@link WebCheckerGame} for the newly created game.
     */
    public WebCheckerGame addGame(String player1, String player2){
        WebCheckerGame game = new WebCheckerGame(player1, player2);
        getPlayer(player1).setFree(false);
        getPlayer(player2).setFree(false);
        allGames.add(game);
        return game;
    }

    /**
     * gets the current game of the current user.
     * @param username current user.
     * @return {@link WebCheckerGame}
     */
    public WebCheckerGame getGame(String username){
        for(WebCheckerGame game: allGames){
            if(game.hasPlayer(username)){
                return game;
            }
        }
        return null;
    }

    public void removeGame(String user) {
        WebCheckerGame game = this.getGame(user);
        String opponent = game.getOpponent(user);
        allGames.remove(allGames.indexOf(game));
        this.getPlayer(user).setFree(true);
        this.getPlayer(opponent).setFree(true);
    }
}
