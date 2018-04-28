package com.webcheckers.model;


import java.util.Objects;
import com.webcheckers.model.Board.Piece.colorEnum;


public class WebCheckerGameColor {
	private final colorEnum player1Color;
	private final colorEnum player2Color;

	public WebCheckerGameColor() {
		this.player1Color = colorEnum.RED;
		this.player2Color = colorEnum.WHITE;
	}

	/**
	* gets the color of the player.
	* @param username   current player
	* @return   @colorEnum of the player's piece
	*/
	public colorEnum getPlayerColor(String username, String thisPlayer1) {
		return Objects.equals(thisPlayer1, username) ? player1Color : player2Color;
	}

	/**
	* gets the color of the opponent.
	* @param username   the name of the current user.
	* @return   @colorEnum of the opponent.
	*/
	public colorEnum getOpponentColor(String username, String thisPlayer1) {
		return Objects.equals(thisPlayer1, username) ? player2Color : player1Color;
	}
}