package com.webcheckers.model;


import java.util.Objects;

public class GameMovementVerificationnum_player {
	private GameMovementVerificationnum_piece gameMovementVerificationnum_piece = new GameMovementVerificationnum_piece();
	private GameMovementVerificationnum_player_move gameMovementVerificationnum_player_move = new GameMovementVerificationnum_player_move();
	public int getNumOfPiecesPlayer1() {
		return gameMovementVerificationnum_piece.getNumOfPiecesPlayer1();
	}

	public void setNumOfPiecesPlayer1(int numOfPiecesPlayer1) {
		gameMovementVerificationnum_piece.setNumOfPiecesPlayer1(numOfPiecesPlayer1);
	}

	public int getNumOfPiecesPlayer2() {
		return gameMovementVerificationnum_piece.getNumOfPiecesPlayer2();
	}

	public void setNumOfPiecesPlayer2(int numOfPiecesPlayer2) {
		gameMovementVerificationnum_piece.setNumOfPiecesPlayer2(numOfPiecesPlayer2);
	}

	public int getNumOfPossMovePlayer1() {
		return gameMovementVerificationnum_player_move.getNumOfPossMovePlayer1();
	}

	public void setNumOfPossMovePlayer1(int numOfPossMovePlayer1) {
		gameMovementVerificationnum_player_move.setNumOfPossMovePlayer1(numOfPossMovePlayer1);
	}

	public int getNumOfPossMovePlayer2() {
		return gameMovementVerificationnum_player_move.getNumOfPossMovePlayer2();
	}

	public void setNumOfPossMovePlayer2(int numOfPossMovePlayer2) {
		gameMovementVerificationnum_player_move.setNumOfPossMovePlayer2(numOfPossMovePlayer2);
	}

	/**
	* Check if the there are pieces left for a player or opponent.
	* @return   true if there are no pieces left for a player, else false.
	*/
	public boolean checkIfPiecesLeftIsNone() {
		return gameMovementVerificationnum_piece.checkIfPiecesLeftIsNone();
	}

	/**
	* Checks if the user entered won or lost.
	* @param user   the user who wants to check
	* @return   true if the user won, else false.
	*/
	public boolean didIWin(String user, WebCheckerGameProduct thisWebCheckerGameProduct) {
		return Objects.equals(user, thisWebCheckerGameProduct.getPlayer1())
				? gameMovementVerificationnum_piece.getNumOfPiecesPlayer1() != 0 && gameMovementVerificationnum_player_move.getNumOfPossMovePlayer1() != 0
				: gameMovementVerificationnum_piece.getNumOfPiecesPlayer2() != 0 && gameMovementVerificationnum_player_move.getNumOfPossMovePlayer2() != 0;
	}

	/**
	* Checks if the number of possible moves is 0
	* @return   true if it is 0, else false.
	*/
	public boolean checkIfNoMovesLeft() {
		return gameMovementVerificationnum_player_move.checkIfNoMovesLeft();
	}
}