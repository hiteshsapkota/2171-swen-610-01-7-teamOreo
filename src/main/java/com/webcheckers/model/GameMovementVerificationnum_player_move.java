package com.webcheckers.model;


public class GameMovementVerificationnum_player_move {
	private int numOfPossMovePlayer1;
	private int numOfPossMovePlayer2;

	public int getNumOfPossMovePlayer1() {
		return numOfPossMovePlayer1;
	}

	public void setNumOfPossMovePlayer1(int numOfPossMovePlayer1) {
		this.numOfPossMovePlayer1 = numOfPossMovePlayer1;
	}

	public int getNumOfPossMovePlayer2() {
		return numOfPossMovePlayer2;
	}

	public void setNumOfPossMovePlayer2(int numOfPossMovePlayer2) {
		this.numOfPossMovePlayer2 = numOfPossMovePlayer2;
	}

	/**
	* Checks if the number of possible moves is 0
	* @return    true if it is 0, else false.
	*/
	public boolean checkIfNoMovesLeft() {
		return numOfPossMovePlayer1 == 0 || numOfPossMovePlayer2 == 0;
	}
}