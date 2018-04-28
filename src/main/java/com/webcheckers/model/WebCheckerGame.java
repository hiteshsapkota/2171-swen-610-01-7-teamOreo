package com.webcheckers.model;

import com.webcheckers.model.Board.Board;
import com.webcheckers.model.Board.Piece;
import com.webcheckers.model.Board.Piece.colorEnum;

/**
 * This is the class of the game and its functions. It holds the boards, the players and some of the validations.
 */
public class WebCheckerGame
{
    private WebCheckerGameProduct2 webCheckerGameProduct2 = new WebCheckerGameProduct2();
	//
    // Attributes
    //
    private final Board board;
    /**
   * Checks if the user entered won or lost.
   * @param user the user who wants to check
   * @return true if the user won, else false.
   */
  public boolean didIWin(String user) {
    return webCheckerGameProduct2.getGameMovementVerification().didIWin(user);
  }

  /**
   * All possible states for movement.
   */
  public enum moveStatCode{
        NO_MOVEMENT,
        MOVEMENT_MADE,
        CAPTURE_MODE
    }

  /**
   * All possible states for conversion.
   */
  public enum conversionState{
        IN_CONVERSION,
        NO_CONVERSION
    }
    /**
     * Constructor to create a new game.
     * @param player1 players name
     * @param player2 opponent's name
     */
    public WebCheckerGame(String player1,String player2)
    {
        webCheckerGameProduct2.getGameMovementVerification().setWebCheckerGameProduct(new WebCheckerGameProduct(player1, player2));
		this.board = new Board();
        webCheckerGameProduct2.getGameMovementVerification().getWebCheckerGameProduct().setIsPlayer1Turn(true);
        webCheckerGameProduct2.getGameMovementVerification().getWebCheckerGameProduct().setIsPlayer2Turn(false);
        webCheckerGameProduct2.getGameMovementVerification().setMoveState(moveStatCode.NO_MOVEMENT);
        webCheckerGameProduct2.getGameMovementVerification().setConversion(conversionState.NO_CONVERSION);
        webCheckerGameProduct2.getGameMovementVerification().setNumOfPiecesPlayer2(12);
        webCheckerGameProduct2.getGameMovementVerification().setNumOfPiecesPlayer1(12);
        webCheckerGameProduct2.getGameMovementVerification().checkAllPieceForMovements(this);
    }

    /**
     * isMyTurn checks if its the current user's turn.
     * @param username name of the player asking for the turn.
     * @return returns true if its his/her turn else returns false.
     */
    public boolean isMyTurn(String username){
        return webCheckerGameProduct2.isMyTurn(username);
    }

  /**
   * This function checks for all possible movements and stores it in a Hash Map.
   */
  public void checkAllPieceForMovements(){
        webCheckerGameProduct2.getGameMovementVerification().checkAllPieceForMovements(this);
    }

  /**
   * Checks if the game is ended or not.
   * @return true if the game has ended, else false.
   */
  public boolean isGameEnded(){
      return webCheckerGameProduct2.getGameMovementVerification().isGameEnded();
    }

  /**
     * Returns the board of the game.
     * @return {@link Board}
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Returns the current player
     * @param username the name of the current player from the session.
     * @return name of the user.
     */
    public String getPlayer(String username) {
      return webCheckerGameProduct2.getPlayer(username);
    }

    /**
     * Returns the opponent of the current player
     * @param username current player
     * @return opponent name
     */
    public String getOpponent(String username){
      return webCheckerGameProduct2.getOpponent(username);
    }

    /**
     * gets the color of the player.
     * @param username current player
     * @return @colorEnum of the player's piece
     */
    public colorEnum getPlayerColor(String username){
      return webCheckerGameProduct2.getPlayerColor(username);
    }

    /**
     * gets the color of the opponent.
     * @param username the name of the current user.
     * @return @colorEnum of the opponent.
     */
    public colorEnum getOpponentColor(String username) {
      return webCheckerGameProduct2.getOpponentColor(username);
    }

    /**
     * check if the game has the player.
     * @param username name of the current user.
     * @return true if the player is in the game.
     */
    public boolean hasPlayer(String username) {
        return webCheckerGameProduct2.hasPlayer(username);
    }

    /**
     * Checks if the movement is a valid one or not and returns the appropriate method.
     * @param startRow row position of the start.
     * @param startCell cell position of the start.
     * @param endRow row position of the end.
     * @param endCell cell position of the end.
     * @return the appropriate message.
     */
    public Message isValidTurn(int startRow, int startCell, int endRow, int endCell) {
        return webCheckerGameProduct2.getGameMovementVerification().isValidTurn(startRow, startCell, endRow, endCell, this);
    }

    /**
     * Check if the undo is possible
     * @return if successful, returns true else false.
     */
    public boolean popMove(){
        return webCheckerGameProduct2.getGameMovementVerification().popMove(this);
    }

    /**
     * This function moves the piece and commits and switch of the current players' turn.
     */
    public void makeMove() {
        webCheckerGameProduct2.getGameMovementVerification().makeMove(this);

    }

    /**
     * Helper method to get the piece from the position.
     * @param x row
     * @param y cell
     * @return {@link Piece}
     */
    public Piece getPiece(int x, int y){
        return this.getBoard().getRow(x).getSpace(y).getPiece();
    }

    /**
     * Helper method to set the piece of the position.
     * @param x row
     * @param y cell
     * @param piece the piece to be set.
     */
    public void setPiece(int x, int y, Piece piece){
        this.getBoard().getRow(x).getSpace(y).setPiece(piece);
    }
}
