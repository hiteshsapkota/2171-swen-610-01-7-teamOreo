package com.webcheckers.model;


public class GameMovementVerificationnum_piece {
	private int numOfPiecesPlayer1;
	private int numOfPiecesPlayer2;

	public int getNumOfPiecesPlayer1() {
		return numOfPiecesPlayer1;
	}

	public void setNumOfPiecesPlayer1(int numOfPiecesPlayer1) {
		this.numOfPiecesPlayer1 = numOfPiecesPlayer1;
	}

	public int getNumOfPiecesPlayer2() {
		return numOfPiecesPlayer2;
	}

	public void setNumOfPiecesPlayer2(int numOfPiecesPlayer2) {
		this.numOfPiecesPlayer2 = numOfPiecesPlayer2;
	}

	/**
	* Check if the there are pieces left for a player or opponent.
	* @return    true if there are no pieces left for a player, else false.
	*/
	public boolean checkIfPiecesLeftIsNone() {
		return numOfPiecesPlayer2 == 0 || numOfPiecesPlayer1 == 0;
	}
}