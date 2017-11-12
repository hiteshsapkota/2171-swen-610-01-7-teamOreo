package com.webcheckers.model;

import com.webcheckers.model.Board.Board;
import com.webcheckers.model.Board.Piece;
import com.webcheckers.model.Board.Piece.colorEnum;
import com.webcheckers.model.Board.Piece.typeEnum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.webcheckers.model.Strings.*;

/**
 * This is the class of the game and its functions. It holds the boards, the players and some of the validations.
 */
public class WebCheckerGame
{
  //
  // Attributes
  //
  private Board board;
  private String player1;
  private colorEnum player1Color;
  private boolean     isPlayer1Turn;
  private String player2;
  private colorEnum player2Color;
  private boolean isPlayer2Turn;
  private moveStatCode moveState;
  private HashMap<String, ArrayList<Position>> possibleMovements = new HashMap<>();
  private enum moveStatCode{
    NO_MOVEMENT,
    MOVEMENT_MADE,
    CAPTURE_MODE
  }
  private enum conversionState{
    IN_CONVERSION,
    NO_CONVERSION
  }
  private conversionState conversion;
  private Movement movements = null;

  private boolean gameEnded;
  private int turn;

  /**
   * Constructor to create a new game.
   * @param player1 players name
   * @param player2 opponent's name
   */
  public WebCheckerGame(String player1,String player2)
  {
    this.board = new Board();
    this.player1 = player1;
    this.player1Color = colorEnum.RED;
    this.isPlayer1Turn = true;
    this.player2 = player2;
    this.player2Color = colorEnum.WHITE;
    this.isPlayer2Turn = false;
    this.gameEnded = false;
    this.turn = 0;
    this.moveState = moveStatCode.NO_MOVEMENT;
    conversion = conversionState.NO_CONVERSION;
  }

  /**
   * isMyTurn checks if its the current user's turn.
   * @param username name of the player asking for the turn.
   * @return returns true if its his/her turn else returns false.
   */
  public boolean isMyTurn(String username){
    if(Objects.equals(player1, username)){
      return isPlayer1Turn;
    }
    else{
      return isPlayer2Turn;
    }
  }

  // FIXME: let it not throw an exception for out of bounds.
  public void checkAllPieceForMovements(){
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if(getPiece(i, j) == null){
          System.out.println("No piece");
          continue;
        }
        try{
          String positionKey = String.valueOf(i) + String.valueOf(j);
          possibleMovements.put(positionKey, new ArrayList<>());
          if(getPiece(i, j).getType() == typeEnum.KING){
            if(i + 1 <= 7){
              if(j + 1 <= 7){
                if(getPiece(i + 1, j + 1) == null){
                  possibleMovements.get(positionKey).add(new Position(i + 1, j + 1));
                }

                if(i + 2 <= 7 && j + 2 <= 7){
                  if(getPiece(i + 1, j + 1) != null && getPiece(i + 1, j + 1).getColor() != getPiece(i, j).getColor() && getPiece(i + 2, j + 2) == null){
                    possibleMovements.get(positionKey).add(new Position(i + 2, j + 2));
                  }
                }
              }

              if(j - 1 >= 0){
                if(getPiece(i + 1, j - 1) == null){
                  possibleMovements.get(positionKey).add(new Position(i + 1, j - 1));
                }

                if(i + 2 <= 7 && j - 2 >= 0){
                  if(getPiece(i + 1, j - 1) != null && getPiece(i + 1, j - 1).getColor() != getPiece(i, j).getColor() && getPiece(i + 2, j - 2) == null){
                    possibleMovements.get(positionKey).add(new Position(i + 2, j - 2));
                  }
                }
              }
            }

            if(i - 1 >= 0){
              if(j + 1 <= 7){
                if(getPiece(i - 1, j + 1) == null){
                  possibleMovements.get(positionKey).add(new Position(i - 1, j + 1));
                }
                if(i - 2 >= 0 && j + 2 <= 7){
                  if(getPiece(i - 1, j + 1) != null && getPiece(i - 1, j + 1).getColor() != getPiece(i, j).getColor() && getPiece(i - 2, j + 2) == null){
                    possibleMovements.get(positionKey).add(new Position(i - 2, j + 2));
                  }
                }
              }

              if(j - 1 >= 0){
                if(getPiece(i - 1, j - 1) == null){
                  possibleMovements.get(positionKey).add(new Position(i - 1, j - 1));
                }

                if(i - 2 >= 0 && j - 2 >= 0){
                  if(getPiece(i - 1, j - 1) != null && getPiece(i - 1, j - 1).getColor() != getPiece(i, j).getColor() && getPiece(i - 2, j - 2) == null){
                    possibleMovements.get(positionKey).add(new Position(i - 2, j - 2));
                  }
                }
              }

            }

          }
          else if(getPiece(i, j).getColor() == colorEnum.RED){
            if(i + 1 <= 7){
              if(j + 1 <= 7){
                if(getPiece(i + 1, j + 1) == null){
                  possibleMovements.get(positionKey).add(new Position(i + 1, j + 1));
                }
                if(i + 2 <= 7 && j + 2 <= 7){
                  if(getPiece(i + 1, j + 1) != null && getPiece(i + 1, j + 1).getColor() != colorEnum.RED && getPiece(i + 2, j + 2) == null){
                    possibleMovements.get(positionKey).add(new Position(i + 2, j + 2));
                  }
                }
              }

              if(j - 1 >= 0){
                if(getPiece(i + 1, j - 1) == null){
                  possibleMovements.get(positionKey).add(new Position(i + 1, j - 1));
                }

                if(i + 2 <= 7 && j - 2 >=0){
                  if(getPiece(i + 1, j - 1) != null && getPiece(i + 1, j - 1).getColor() != colorEnum.RED && getPiece(i + 2, j - 2) == null){
                    possibleMovements.get(positionKey).add(new Position(i + 2, j - 2));
                  }
                }
              }
            }
          }
          else if(getPiece(i, j).getColor() == colorEnum.WHITE){
            if(getPiece(i - 1, j + 1) == null){
              possibleMovements.get(positionKey).add(new Position(i - 1, j + 1));
            }
            if(getPiece(i - 1, j - 1) == null){
              possibleMovements.get(positionKey).add(new Position(i - 1, j - 1));
            }
            if(getPiece(i - 1, j + 1) != null && getPiece(i - 1, j + 1).getColor() != colorEnum.RED && getPiece(i - 2, j + 2) == null){
              possibleMovements.get(positionKey).add(new Position(i - 2, j + 2));
            }
            if(getPiece(i - 1, j - 1) != null && getPiece(i - 1, j - 1).getColor() != colorEnum.RED && getPiece(i - 2, j - 2) == null){
              possibleMovements.get(positionKey).add(new Position(i - 2, j - 2));
            }
          }
        }
        catch (Exception e){
          System.out.println("out of bounds");
        }
      }
    }
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
    if(Objects.equals(player1, username)){
      return player1;
    }
    else{
      return player2;
    }
  }

  /**
   * Returns the opponent of the current player
   * @param username current player
   * @return opponent name
   */
  public String getOpponent(String username){
    if(Objects.equals(this.player1, username)){
      return player2;
    }
    else {
      return player1;
    }
  }

  /**
   * gets the color of the player.
   * @param username current player
   * @return @colorEnum of the player's piece
   */
  public colorEnum getPlayerColor(String username){
    if(Objects.equals(this.player1, username)){
      return player1Color;
    }
    else{
      return player2Color;
    }
  }

  /**
   * gets the color of the opponent.
   * @param username the name of the current user.
   * @return @colorEnum of the opponent.
   */
  public colorEnum getOpponentColor(String username) {
    if(Objects.equals(this.player1, username)){
      return player2Color;
    }
    else{
      return player1Color;
    }
  }

  /**
   * check if the game has the player.
   * @param username name of the current user.
   * @return true if the player is in the game.
   */
  public boolean hasPlayer(String username) {
    return (Objects.equals(player1, username) || Objects.equals(player2, username));
  }

  /**
   * Checks if the movement is a valid one or not and returns the appropriate method.
   * @param startRow row position of the start.
   * @param startCell cell position of the start.
   * @param endRow row position of the end.
   * @param endCell cell position of the end.
   * @param user current username.
   * @return the appropriate message.
   */
  public Message isValidTurn(int startRow, int startCell, int endRow, int endCell, String user) {
    Message message = new Message();
    if(moveState == moveStatCode.MOVEMENT_MADE || moveState == moveStatCode.CAPTURE_MODE){
      message.text = INVALID_ALREADY_MADE;
      message.type = MESSAGE_ERROR;
      return message;
    }
    String pieceKey = String.valueOf(startRow) + String.valueOf(startCell);
    ArrayList<Position> possibleMoves = possibleMovements.get(pieceKey);
    Position endPosition = new Position(endRow, endCell);
    if(possibleMoves.contains(endPosition)){
      // VALID
      if(Math.abs(endRow - startRow) == 2){
        moveState = moveStatCode.CAPTURE_MODE;
        message.text = "Valid move";
        message.type = "info";
      }
      else{
        moveState = moveStatCode.MOVEMENT_MADE;
        message.text = "Valid move";
        message.type = "info";
      }
    }
    else{
      moveState = moveStatCode.NO_MOVEMENT;
      message.text = "Invalid move";
      message.type = "error";
      //INVALID
    }
    if(moveState == moveStatCode.MOVEMENT_MADE || moveState == moveStatCode.CAPTURE_MODE){
      movements = new Movement(startRow, startCell, endRow, endCell);
      Piece piece = getPiece(startRow, startCell);
      setPiece(startRow, startCell, null);
      setPiece(endRow, endCell, piece);
    }
    if(endRow == 7 || endRow == 0){
      conversion = conversionState.IN_CONVERSION;
    }
    return message;
  }

  /**
   * Check if the undo is possible
   * @return if successful, returns true else false.
   */
  public boolean popMove(){
    boolean undoSuccessful = false;
    if(moveState != moveStatCode.CAPTURE_MODE){
      Movement latestMovement = movements;
      Piece piece = getPiece(latestMovement.getEndRow(), latestMovement.getEndCell());
      setPiece(latestMovement.getEndRow(), movements.getEndCell(), null);
      setPiece(latestMovement.getStartRow(), latestMovement.getStartCell(), piece);
      movements = null;
      moveState = moveStatCode.NO_MOVEMENT;
      undoSuccessful = true;
    }
    return  undoSuccessful;
  }

  /**
   * This function moves the piece and commits and switch of the current players' turn.
   */
  public void makeMove() {
    if (moveState == moveStatCode.CAPTURE_MODE){
      if(isPlayer1Turn){
        if(movements.getEndCell() > movements.getStartCell()){
          setPiece(movements.getStartRow() + 1, movements.getStartCell() + 1, null);
        }
        else{
          setPiece(movements.getStartRow() + 1, movements.getStartCell() - 1, null);
        }
        isPlayer2Turn = true;
        isPlayer1Turn = false;
      }
      else{
        if (movements.getStartCell() > movements.getEndCell()){
          setPiece(movements.getStartRow() - 1, movements.getStartCell() - 1, null);
        }
        else{
          setPiece(movements.getStartRow() - 1, movements.getStartCell() + 1, null);
        }
        isPlayer2Turn = false;
        isPlayer1Turn = true;
      }
    }
    else{
      if(isPlayer1Turn){
        isPlayer2Turn = true;
        isPlayer1Turn = false;
      }
      else {
        isPlayer2Turn = false;
        isPlayer1Turn = true;
      }
    }
    if(conversion == conversionState.IN_CONVERSION){
      getPiece(movements.getEndRow(), movements.getEndCell()).setType(typeEnum.KING);
    }
    movements = null;
    moveState = moveStatCode.NO_MOVEMENT;
    conversion = conversionState.NO_CONVERSION;
    possibleMovements.clear();
  }

  /**
   * Helper method to get the piece from the position.
   * @param x row
   * @param y cell
   * @return {@link Piece}
   */
  private Piece getPiece(int x, int y){
    return this.getBoard().getRow(x).getSpace(y).getPiece();
  }

  /**
   * Helper method to set the piece of the position.
   * @param x row
   * @param y cell
   * @param piece the piece to be set.
   */
  private void setPiece(int x, int y, Piece piece){
    this.getBoard().getRow(x).getSpace(y).setPiece(piece);
  }
}

class Position{
  int x;
  int y;

  Position(int x, int y){
    this.x = x;
    this.y = y;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Position position = (Position) o;

    if (x != position.x) {
      return false;
    }
    return y == position.y;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
  }
}