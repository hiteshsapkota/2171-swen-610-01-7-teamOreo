package com.webcheckers.model;
import com.webcheckers.model.Board.Piece.colorEnum;


import java.util.Objects;

public class WebCheckerGameProduct {
	private WebCheckerGameTurnPlayer webCheckerGameTurnPlayer = new WebCheckerGameTurnPlayer();
	private WebCheckerGameColor webCheckerGameColor;
	private final String player1;
	private final String player2;
	public WebCheckerGameProduct(String player1, String player2) {
		this.webCheckerGameColor = new WebCheckerGameColor();
		this.player1 = player1;
		this.player2 = player2;
	}

	public String getPlayer1() {
		return player1;
	}

	public boolean getIsPlayer1Turn() {
		return webCheckerGameTurnPlayer.getIsPlayer1Turn();
	}

	public void setIsPlayer1Turn(boolean isPlayer1Turn) {
		webCheckerGameTurnPlayer.setIsPlayer1Turn(isPlayer1Turn);
	}

	public boolean getIsPlayer2Turn() {
		return webCheckerGameTurnPlayer.getIsPlayer2Turn();
	}

	public void setIsPlayer2Turn(boolean isPlayer2Turn) {
		webCheckerGameTurnPlayer.setIsPlayer2Turn(isPlayer2Turn);
	}

	/**
	* Returns the current player
	* @param username  the name of the current player from the session.
	* @return  name of the user.
	*/
	public String getPlayer(String username) {
		return Objects.equals(player1, username) ? player1 : player2;
	}

	/**
	* Returns the opponent of the current player
	* @param username  current player
	* @return  opponent name
	*/
	public String getOpponent(String username) {
		return Objects.equals(this.player1, username) ? player2 : player1;
	}

	/**
	* check if the game has the player.
	* @param username  name of the current user.
	* @return  true if the player is in the game.
	*/
	public boolean hasPlayer(String username) {
		return (Objects.equals(player1, username) || Objects.equals(player2, username));
	}

	/**
	* gets the color of the player.
	* @param username  current player
	* @return  @colorEnum of the player's piece
	*/
	public colorEnum getPlayerColor(String username) {
		return webCheckerGameColor.getPlayerColor(username, this.player1);
	}

	/**
	* gets the color of the opponent.
	* @param username  the name of the current user.
	* @return  @colorEnum of the opponent.
	*/
	public colorEnum getOpponentColor(String username) {
		return webCheckerGameColor.getOpponentColor(username, this.player1);
	}

	/**
	* isMyTurn checks if its the current user's turn.
	* @param username  name of the player asking for the turn.
	* @return  returns true if its his/her turn else returns false.
	*/
	public boolean isMyTurn(String username) {
		return webCheckerGameTurnPlayer.isMyTurn(username, this.player1);
	}

	public void switchPlayerMove() {
		webCheckerGameTurnPlayer.switchPlayerMove(this);
	}
}