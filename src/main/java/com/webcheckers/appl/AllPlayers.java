package com.webcheckers.appl;


import java.util.Map;
import com.webcheckers.model.OnlinePlayers;
import java.util.HashMap;
import spark.Session;
import java.util.ArrayList;
import com.webcheckers.model.Strings;

public class AllPlayers {
	private final Map<String, OnlinePlayers> allPlayers = new HashMap<>();

	/**
	* To add player in the all players list
	* @param session  : The browser session of the player.
	* @param username  : The name of the user.
	*/
	public void login(Session session, String username) {
		OnlinePlayers player = new OnlinePlayers(username);
		session.attribute(Strings.USER_SESSION_ATTRIBUTE, player);
		this.allPlayers.put(username, player);
	}

	/**
	* To check if the username already exists.
	* @param username  the username to check.
	* @return  returns true if the username exist.
	*/
	public boolean userAlreadyExists(String username) {
		return this.allPlayers.keySet().contains(username);
	}

	/**
	* gets the player
	* @param username  current session.
	* @return   {@link OnlinePlayers}  object of the player.
	*/
	public OnlinePlayers getPlayer(String username) {
		return this.allPlayers.get(username);
	}

	/**
	* To remove the player in the all players list.
	* @param session  to remove the attribute
	*/
	public void logout(Session session) {
		String username = ((OnlinePlayers) session.attribute(Strings.USER_SESSION_ATTRIBUTE)).getName();
		session.removeAttribute(Strings.USER_SESSION_ATTRIBUTE);
		this.allPlayers.remove(username);
	}

	/**
	* To give out all available players.
	* @return  an  {@link ArrayList}  of all the players.
	*/
	public ArrayList<String> getAllAvailablePlayers() {
		ArrayList<String> players = new ArrayList<>();
		for (OnlinePlayers player : allPlayers.values()) {
			if (player.isFree()) {
				players.add(player.getName());
			}
		}
		return players;
	}

	/**
	* To check if the user is currently in a game.
	* @param username  the username to check.
	* @return  returns true if its free.
	*/
	public boolean userIsFree(String username) {
		return allPlayers.get(username).isFree();
	}
}