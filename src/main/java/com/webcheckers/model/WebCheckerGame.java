package com.webcheckers.model;

import com.webcheckers.model.Board.Board;
import com.webcheckers.model.Board.Piece;
import com.webcheckers.model.Board.Piece.colorEnum;
import com.webcheckers.model.Board.Piece.typeEnum;
import java.util.ArrayList;
import java.util.HashMap;
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
    private boolean isPlayer1Turn;
    private String player2;
    private colorEnum player2Color;
    private boolean isPlayer2Turn;
    private moveStatCode moveState;
    private HashMap<String, ArrayList<Position>> possibleMovements = new HashMap<>();
    private int numOfPossMovePlayer1;
    private int numOfPossMovePlayer2;

    private int numOfPiecesPlayer1;
    private int numOfPiecesPlayer2;

  public boolean didIWin(String user) {
    return Objects.equals(user, player1) ? numOfPiecesPlayer1 != 0 && numOfPossMovePlayer1 != 0
        : numOfPiecesPlayer2 != 0 && numOfPossMovePlayer2 != 0;
  }

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
    private ArrayList<Movement> movements = new ArrayList<>();

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
        this.moveState = moveStatCode.NO_MOVEMENT;
        this.conversion = conversionState.NO_CONVERSION;
        this.numOfPiecesPlayer2 = 12;
        this.numOfPiecesPlayer1 = 12;
        this.checkAllPieceForMovements();
//        this.numOfPossMovePlayer1 =  0;
//        this.numOfPossMovePlayer2 = 0;
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

    public void checkAllPieceForMovements(){
        this.numOfPossMovePlayer1 = 0;
        this.numOfPossMovePlayer2 = 0;
        for (int i = 0; i < 8; i++)
          for (int j = 0; j < 8; j++) {
            if (getPiece(i, j) == null)
              continue;
            String positionKey = String.valueOf(i) + String.valueOf(j);
            possibleMovements.put(positionKey, new ArrayList<>());
            if (getPiece(i, j).getType() == typeEnum.KING) {
              if (i + 1 <= 7) {
                if (j + 1 <= 7) {
                  if (getPiece(i + 1, j + 1) == null) {
                    possibleMovements.get(positionKey).add(new Position(i + 1, j + 1));
                    numOfPossMovePlayer1 =
                        (getPiece(i, j).getColor() == colorEnum.RED) ? numOfPossMovePlayer1 + 1
                            : numOfPossMovePlayer1;
                    numOfPossMovePlayer2 =
                        (getPiece(i, j).getColor() == colorEnum.WHITE) ? numOfPossMovePlayer2 + 2
                            : numOfPossMovePlayer2;
                  }
                  if (i + 2 <= 7 && j + 2 <= 7 && getPiece(i + 1, j + 1) != null
                      && getPiece(i + 1, j + 1).getColor() != getPiece(i, j).getColor()
                      && getPiece(i + 2, j + 2) == null) {
                    possibleMovements.get(positionKey).add(new Position(i + 2, j + 2));
                    numOfPossMovePlayer1 =
                        (getPiece(i, j).getColor() == colorEnum.RED) ? numOfPossMovePlayer1 + 1
                            : numOfPossMovePlayer1;
                    numOfPossMovePlayer2 =
                        (getPiece(i, j).getColor() == colorEnum.WHITE) ? numOfPossMovePlayer2 + 2
                            : numOfPossMovePlayer2;
                  }
                }
                if (j - 1 >= 0) {
                  if (getPiece(i + 1, j - 1) == null) {
                    possibleMovements.get(positionKey).add(new Position(i + 1, j - 1));
                    numOfPossMovePlayer1 =
                        (getPiece(i, j).getColor() == colorEnum.RED) ? numOfPossMovePlayer1 + 1
                            : numOfPossMovePlayer1;
                    numOfPossMovePlayer2 =
                        (getPiece(i, j).getColor() == colorEnum.WHITE) ? numOfPossMovePlayer2 + 2
                            : numOfPossMovePlayer2;
                  }
                  if (i + 2 <= 7 && j - 2 >= 0 && getPiece(i + 1, j - 1) != null
                      && getPiece(i + 1, j - 1).getColor() != getPiece(i, j).getColor()
                      && getPiece(i + 2, j - 2) == null) {
                    possibleMovements.get(positionKey).add(new Position(i + 2, j - 2));
                    numOfPossMovePlayer1 =
                        (getPiece(i, j).getColor() == colorEnum.RED) ? numOfPossMovePlayer1 + 1
                            : numOfPossMovePlayer1;
                    numOfPossMovePlayer2 =
                        (getPiece(i, j).getColor() == colorEnum.WHITE) ? numOfPossMovePlayer2 + 2
                            : numOfPossMovePlayer2;
                  }
                }
              }
              if (i - 1 >= 0) {
                if (j + 1 <= 7) {
                  if (getPiece(i - 1, j + 1) == null) {
                    possibleMovements.get(positionKey).add(new Position(i - 1, j + 1));
                    numOfPossMovePlayer1 =
                        (getPiece(i, j).getColor() == colorEnum.RED) ? numOfPossMovePlayer1 + 1
                            : numOfPossMovePlayer1;
                    numOfPossMovePlayer2 =
                        (getPiece(i, j).getColor() == colorEnum.WHITE) ? numOfPossMovePlayer2 + 2
                            : numOfPossMovePlayer2;
                  }
                  if (i - 2 >= 0 && j + 2 <= 7 && getPiece(i - 1, j + 1) != null
                      && getPiece(i - 1, j + 1).getColor() != getPiece(i, j).getColor()
                      && getPiece(i - 2, j + 2) == null) {
                    possibleMovements.get(positionKey).add(new Position(i - 2, j + 2));
                    numOfPossMovePlayer1 =
                        (getPiece(i, j).getColor() == colorEnum.RED) ? numOfPossMovePlayer1 + 1
                            : numOfPossMovePlayer1;
                    numOfPossMovePlayer2 =
                        (getPiece(i, j).getColor() == colorEnum.WHITE) ? numOfPossMovePlayer2 + 2
                            : numOfPossMovePlayer2;
                  }
                }
                if (j - 1 >= 0) {
                  if (getPiece(i - 1, j - 1) == null) {
                    possibleMovements.get(positionKey).add(new Position(i - 1, j - 1));
                    numOfPossMovePlayer1 =
                        (getPiece(i, j).getColor() == colorEnum.RED) ? numOfPossMovePlayer1 + 1
                            : numOfPossMovePlayer1;
                    numOfPossMovePlayer2 =
                        (getPiece(i, j).getColor() == colorEnum.WHITE) ? numOfPossMovePlayer2 + 2
                            : numOfPossMovePlayer2;
                  }
                  if (i - 2 >= 0 && j - 2 >= 0 && getPiece(i - 1, j - 1) != null
                      && getPiece(i - 1, j - 1).getColor() != getPiece(i, j).getColor()
                      && getPiece(i - 2, j - 2) == null) {
                    possibleMovements.get(positionKey).add(new Position(i - 2, j - 2));
                    numOfPossMovePlayer1 =
                        (getPiece(i, j).getColor() == colorEnum.RED) ? numOfPossMovePlayer1 + 1
                            : numOfPossMovePlayer1;
                    numOfPossMovePlayer2 =
                        (getPiece(i, j).getColor() == colorEnum.WHITE) ? numOfPossMovePlayer2 + 2
                            : numOfPossMovePlayer2;
                  }
                }
              }
            } else if (getPiece(i, j).getColor() == colorEnum.RED) {
              if (i + 1 <= 7) {
                if (j + 1 <= 7) {
                  if (getPiece(i + 1, j + 1) == null) {
                    possibleMovements.get(positionKey).add(new Position(i + 1, j + 1));
                    numOfPossMovePlayer1++;
                  }
                  if (i + 2 <= 7 && j + 2 <= 7 && getPiece(i + 1, j + 1) != null
                      && getPiece(i + 1, j + 1).getColor() != colorEnum.RED
                      && getPiece(i + 2, j + 2) == null) {
                    possibleMovements.get(positionKey).add(new Position(i + 2, j + 2));
                    numOfPossMovePlayer1++;
                  }
                }
                if (j - 1 >= 0) {
                  if (getPiece(i + 1, j - 1) == null) {
                    possibleMovements.get(positionKey).add(new Position(i + 1, j - 1));
                    numOfPossMovePlayer1++;
                  }

                  if (i + 2 <= 7 && j - 2 >= 0 && getPiece(i + 1, j - 1) != null
                      && getPiece(i + 1, j - 1).getColor() != colorEnum.RED
                      && getPiece(i + 2, j - 2) == null) {
                    possibleMovements.get(positionKey).add(new Position(i + 2, j - 2));
                    numOfPossMovePlayer1++;
                  }
                }
              }
            } else if (getPiece(i, j).getColor() == colorEnum.WHITE) {
              if (i - 1 >= 0) {
                if (j + 1 <= 7) {
                  if (getPiece(i - 1, j + 1) == null) {
                    possibleMovements.get(positionKey).add(new Position(i - 1, j + 1));
                    numOfPossMovePlayer2++;
                  }

                  if (i - 2 >= 0 && j + 2 <= 7 && getPiece(i - 1, j + 1) != null
                      && getPiece(i - 1, j + 1).getColor() != colorEnum.WHITE
                      && getPiece(i - 2, j + 2) == null) {
                    possibleMovements.get(positionKey).add(new Position(i - 2, j + 2));
                    numOfPossMovePlayer2++;
                  }
                }
                if (j - 1 >= 0) {
                  if (getPiece(i - 1, j - 1) == null) {
                    possibleMovements.get(positionKey).add(new Position(i - 1, j - 1));
                    numOfPossMovePlayer2++;
                  }
                  if (i - 2 >= 0 && j - 2 >= 0 && getPiece(i - 1, j - 1) != null
                      && getPiece(i - 1, j - 1).getColor() != colorEnum.WHITE
                      && getPiece(i - 2, j - 2) == null) {
                    possibleMovements.get(positionKey).add(new Position(i - 2, j - 2));
                    numOfPossMovePlayer2++;
                  }
                }
              }
            }
          }
    }

    public boolean isGameEnded(){
      boolean gameEnded = false;
      if (checkIfNoMovesLeft() || checkIfPiecesLeftIsNone()) {
        gameEnded = true;
      }
      return gameEnded;
    }

    private boolean checkIfPiecesLeftIsNone() {
        return numOfPiecesPlayer2 == 0 || numOfPiecesPlayer1 == 0;
    }

    private boolean checkIfNoMovesLeft() {
        return numOfPossMovePlayer1 == 0 || numOfPossMovePlayer2 == 0;
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
      return Objects.equals(player1, username) ? player1 : player2;
    }

    /**
     * Returns the opponent of the current player
     * @param username current player
     * @return opponent name
     */
    public String getOpponent(String username){
      return Objects.equals(this.player1, username) ? player2 : player1;
    }

    /**
     * gets the color of the player.
     * @param username current player
     * @return @colorEnum of the player's piece
     */
    public colorEnum getPlayerColor(String username){
      return Objects.equals(this.player1, username) ? player1Color : player2Color;
    }

    /**
     * gets the color of the opponent.
     * @param username the name of the current user.
     * @return @colorEnum of the opponent.
     */
    public colorEnum getOpponentColor(String username) {
      return Objects.equals(this.player1, username) ? player2Color : player1Color;
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
     * @return the appropriate message.
     */
    public Message isValidTurn(int startRow, int startCell, int endRow, int endCell) {
        Message message = new Message();
        String pieceKey = String.valueOf(startRow) + String.valueOf(startCell);
        if(moveState == moveStatCode.MOVEMENT_MADE || moveState != moveStatCode.CAPTURE_MODE && !possibleMovements.containsKey(pieceKey)){
            message.text = INVALID_ALREADY_MADE;
            message.type = MESSAGE_ERROR;
            possibleMovements.clear();
            this.checkAllPieceForMovements();
            return message;
        }
        ArrayList<Position> possibleMoves = possibleMovements.get(pieceKey);
        Position endPosition = new Position(endRow, endCell);
      // VALID
      if(possibleMoves.contains(endPosition))
        if (endRow - startRow == 2 || endRow - startRow == -2) {
          moveState = moveStatCode.CAPTURE_MODE;
          message.text = VALID_MOVE;
          message.type = MESSAGE_INFO;
        } else {
          moveState = moveStatCode.MOVEMENT_MADE;
          message.text = VALID_MOVE;
          message.type = MESSAGE_INFO;
        }
        else{
            moveState = moveStatCode.NO_MOVEMENT;
            message.text = INVALID_MOVE;
            message.type = MESSAGE_ERROR;
            //INVALID
        }
        if(moveState == moveStatCode.MOVEMENT_MADE || moveState == moveStatCode.CAPTURE_MODE){
            movements.add(new Movement(startRow, startCell, endRow, endCell));
            Piece piece = getPiece(startRow, startCell);
            setPiece(startRow, startCell, null);
            setPiece(endRow, endCell, piece);
            possibleMoves.clear();
            this.checkAllPieceForMovements();
        }
        if((moveState == moveStatCode.MOVEMENT_MADE || moveState == moveStatCode.CAPTURE_MODE) && (endRow == 7 && getPiece(endRow, endCell).getColor() == colorEnum.RED || endRow == 0 && getPiece(endRow, endCell).getColor() == colorEnum.WHITE))
          conversion = conversionState.IN_CONVERSION;
        return message;
    }

    /**
     * Check if the undo is possible
     * @return if successful, returns true else false.
     */
    public boolean popMove(){
        boolean undoSuccessful = false;
        if(moveState != moveStatCode.CAPTURE_MODE){
            Movement latestMovement = movements.get(movements.size() - 1);
            Piece piece = getPiece(latestMovement.getEndRow(), latestMovement.getEndCell());
            setPiece(latestMovement.getEndRow(), latestMovement.getEndCell(), null);
            setPiece(latestMovement.getStartRow(), latestMovement.getStartCell(), piece);
            moveState = moveStatCode.NO_MOVEMENT;
            undoSuccessful = true;
            movements.remove(movements.size() - 1);
            this.checkAllPieceForMovements();

        }
        return  undoSuccessful;
    }

    /**
     * This function moves the piece and commits and switch of the current players' turn.
     */
    public void makeMove() {
        for (int i = movements.size() - 1; i >= 0 ; i--) {

          System.out.println("Movement" + i);
            if (moveState == moveStatCode.CAPTURE_MODE) {
              if(isPlayer1Turn){
                numOfPiecesPlayer2 --;
              }
              else if(isPlayer2Turn){
                numOfPiecesPlayer1 --;
              }
              if (isPlayer1Turn) {
                if (typeEnum.KING == getPiece(movements.get(movements.size() - 1).getEndRow(),
                    movements.get(movements.size() - 1).getEndCell()).getType()) {
                  if (movements.get(i).getEndRow() > movements.get(i).getStartRow()) {
                    setPiece(movements.get(i).getStartRow() + 1,
                        movements.get(i).getEndCell() > movements.get(i).getStartCell() ?
                            movements.get(i).getStartCell() + 1
                            : movements.get(i).getStartCell() - 1, null);
                  } else {
                    if (movements.get(i).getStartCell() > movements.get(i).getEndCell()) {
                      setPiece(movements.get(i).getStartRow() - 1,
                          movements.get(i).getStartCell() - 1, null);
                    } else {
                      setPiece(movements.get(i).getStartRow() - 1,
                          movements.get(i).getStartCell() + 1, null);
                    }
                  }
                } else {
                  if (movements.get(i).getEndCell() > movements.get(i).getStartCell()) {
                    setPiece(movements.get(i).getStartRow() + 1,
                        movements.get(i).getStartCell() + 1, null);
                  } else {
                    setPiece(movements.get(i).getStartRow() + 1,
                        movements.get(i).getStartCell() - 1, null);
                  }
                }
              } else {
                if (getPiece(movements.get(movements.size() - 1).getEndRow(),
                    movements.get(movements.size() - 1).getEndCell()).getType() == typeEnum.KING) {
                  if (movements.get(i).getEndRow() > movements.get(i).getStartRow()) {
                    setPiece(movements.get(i).getStartRow() + 1,
                        movements.get(i).getEndCell() > movements.get(i).getStartCell() ?
                            movements.get(i).getStartCell() + 1
                            : movements.get(i).getStartCell() - 1,
                        null);
                  } else {
                    setPiece(movements.get(i).getStartRow() - 1,
                        movements.get(i).getStartCell() > movements.get(i).getEndCell() ?
                            movements.get(i).getStartCell() - 1
                            : movements.get(i).getStartCell() + 1,
                        null);
                  }
                } else {
                  if (movements.get(i).getStartCell() > movements.get(i).getEndCell()) {
                    setPiece(movements.get(i).getStartRow() - 1,
                        movements.get(i).getStartCell() - 1, null);
                  } else {
                    setPiece(movements.get(i).getStartRow() - 1,
                        movements.get(i).getStartCell() + 1, null);
                  }
                }
              }
            }
            if(conversion == conversionState.IN_CONVERSION){
                getPiece(movements.get(i).getEndRow(), movements.get(i).getEndCell()).setType(typeEnum.KING);
                conversion = conversionState.NO_CONVERSION;
            }
        }
        if(isPlayer1Turn){
            isPlayer1Turn = false;
            isPlayer2Turn = true;
        }
        else {
            isPlayer2Turn = false;
            isPlayer1Turn = true;
        }
        movements.clear();
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
