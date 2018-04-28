package com.webcheckers.model;


import java.util.Objects;

public class WebCheckerGameTurnPlayer {
	private boolean isPlayer1Turn;
	private boolean isPlayer2Turn;

	public boolean getIsPlayer1Turn() {
		return isPlayer1Turn;
	}

	public void setIsPlayer1Turn(boolean isPlayer1Turn) {
		this.isPlayer1Turn = isPlayer1Turn;
	}

	public boolean getIsPlayer2Turn() {
		return isPlayer2Turn;
	}

	public void setIsPlayer2Turn(boolean isPlayer2Turn) {
		this.isPlayer2Turn = isPlayer2Turn;
	}

	public void switchPlayerMove(WebCheckerGameProduct webCheckerGameProduct) {
		if (isPlayer1Turn) {
			webCheckerGameProduct.setIsPlayer1Turn(false);
			webCheckerGameProduct.setIsPlayer2Turn(true);
		} else {
			webCheckerGameProduct.setIsPlayer2Turn(false);
			webCheckerGameProduct.setIsPlayer1Turn(true);
		}
	}

	/**
	* isMyTurn checks if its the current user's turn.
	* @param username   name of the player asking for the turn.
	* @return   returns true if its his/her turn else returns false.
	*/
	public boolean isMyTurn(String username, String thisPlayer1) {
		if (Objects.equals(thisPlayer1, username)) {
			return isPlayer1Turn;
		} else {
			return isPlayer2Turn;
		}
	}
}