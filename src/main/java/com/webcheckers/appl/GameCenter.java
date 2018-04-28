package com.webcheckers.appl;

import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.model.WebCheckerGame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.Session;

import static com.webcheckers.model.Strings.USER_SESSION_ATTRIBUTE;

public class GameCenter {

    private AllPlayers allPlayers = new AllPlayers();
	private final ArrayList<WebCheckerGame> allGames = new ArrayList<>();


    /**
     *  To add player in the all players list
     * @param session : The browser session of the player.
     * @param username : The name of the user.
     */
    public void login(Session session, String username){
        allPlayers.login(session, username);
    }

    /**
     *  To remove the player in the all players list.
     * @param session to remove the attribute
     */
    public void logout(Session session){
        allPlayers.logout(session);
    }

    /**
     * To check if the username already exists.
     * @param username the username to check.
     * @return returns true if the username exist.
     */
    public boolean userAlreadyExists(String username){
        return allPlayers.userAlreadyExists(username);
    }

    /**
     * To check if the user is currently in a game.
     * @param username the username to check.
     * @return returns true if its free.
     */
    public boolean userIsFree(String username){
        return allPlayers.userIsFree(username);
    }

    /**
     * gets the player
     * @param username current session.
     * @return {@link OnlinePlayers} object of the player.
     */
    OnlinePlayers getPlayer(String username){
        return allPlayers.getPlayer(username);
    }

    /**
     * To give out all available players.
     * @return an {@link ArrayList} of all the players.
     */
    public ArrayList<String> getAllAvailablePlayers(){
        return allPlayers.getAllAvailablePlayers();
    }

    /**
     * Creates a new {@link WebCheckerGame} for the two players.
     * @param player1 player.
     * @param player2 opponent.
     * @return {@link WebCheckerGame} for the newly created game.
     */
    public WebCheckerGame addGame(String player1, String player2){
        WebCheckerGame game = new WebCheckerGame(player1, player2);
        allPlayers.getPlayer(player1).setFree(false);
        allPlayers.getPlayer(player2).setFree(false);
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

    /**
     * Remove game functions removes the game and sets the players free to play another game.
     * @param user the user who wants to remove the game.
     */
    public void removeGame(String user) {
        WebCheckerGame game = this.getGame(user);
        String opponent = game.getOpponent(user);
        allGames.remove(allGames.indexOf(game));
        allPlayers.getPlayer(user).setFree(true);
        allPlayers.getPlayer(opponent).setFree(true);
    }
}
