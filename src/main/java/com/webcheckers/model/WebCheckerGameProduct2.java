package com.webcheckers.model;


import com.webcheckers.model.Board.Piece.colorEnum;


public class WebCheckerGameProduct2 {
	private GameMovementVerification gameMovementVerification = new GameMovementVerification();

	public GameMovementVerification getGameMovementVerification() {
		return gameMovementVerification;
	}

	/**
	* isMyTurn checks if its the current user's turn.
	* @param username  name of the player asking for the turn.
	* @return  returns true if its his/her turn else returns false.
	*/
	public boolean isMyTurn(String username) {
		return gameMovementVerification.getWebCheckerGameProduct().isMyTurn(username);
	}

	/**
	* Returns the current player
	* @param username  the name of the current player from the session.
	* @return  name of the user.
	*/
	public String getPlayer(String username) {
		return gameMovementVerification.getWebCheckerGameProduct().getPlayer(username);
	}

	/**
	* Returns the opponent of the current player
	* @param username  current player
	* @return  opponent name
	*/
	public String getOpponent(String username) {
		return gameMovementVerification.getWebCheckerGameProduct().getOpponent(username);
	}

	/**
	* gets the color of the player.
	* @param username  current player
	* @return  @colorEnum of the player's piece
	*/
	public colorEnum getPlayerColor(String username) {
		return gameMovementVerification.getWebCheckerGameProduct().getPlayerColor(username);
	}

	/**
	* gets the color of the opponent.
	* @param username  the name of the current user.
	* @return  @colorEnum of the opponent.
	*/
	public colorEnum getOpponentColor(String username) {
		return gameMovementVerification.getWebCheckerGameProduct().getOpponentColor(username);
	}

	/**
	* check if the game has the player.
	* @param username  name of the current user.
	* @return  true if the player is in the game.
	*/
	public boolean hasPlayer(String username) {
		return gameMovementVerification.getWebCheckerGameProduct().hasPlayer(username);
	}
}