package com.webcheckers.model;

import com.webcheckers.model.Board.Board;
import com.webcheckers.model.Board.Piece;
import com.webcheckers.model.Board.Piece.colorEnum;
import java.util.Objects;

public class WebCheckerGame
{
    private Board board;
    private String player1;
    private colorEnum player1Color;
    private boolean isPlayer1Turn;
    private String player2;
    private colorEnum player2Color;
    private boolean isPlayer2Turn;
    private moveStatCode moveState;
    private enum moveStatCode{
        NO_MOVEMENT,
        MOVEMENT_MADE,
        CAPTURE_MODE
    }
    private Movement movements = null;

    private boolean gameEnded;
    private int turn;

    public WebCheckerGame(String player1,String player2)
    {
        /**
         * It will create new board with rows,spaces and pieces
         * @param player1
         * @param player2
         */
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
    }

    public boolean isMyTurn(String username){
        if(Objects.equals(player1, username)){
            return isPlayer1Turn;
        }
        else{
            return isPlayer2Turn;
        }
    }

    public Board getBoard() {
        return board;
    }

    public String getPlayer(String username) {
        if(Objects.equals(player1, username)){
            return player1;
        }
        else{
            return player2;
        }
    }

    public String getOpponent(String username){
        if(Objects.equals(this.player1, username)){
            return player2;
        }
        else {
            return player1;
        }
    }

    public colorEnum getPlayerColor(String username){
        if(Objects.equals(this.player1, username)){
            return player1Color;
        }
        else{
            return player2Color;
        }
    }


    public colorEnum getOpponentColor(String username) {
        if(Objects.equals(this.player1, username)){
            return player2Color;
        }
        else{
            return player1Color;
        }
    }

    public boolean hasPlayer(String username) {
        return (Objects.equals(player1, username) || Objects.equals(player2, username));
    }

  public Message isValidTurn(int startRow, int startCell, int endRow, int endCell, String user) {
        if(Objects.equals(user, this.player1)){
            return isValidTurnRed(startRow, startCell, startRow, endRow);
        }
        else{
            return isValidTurnWhite(startRow, startCell, endRow, endCell);
        }
  }

    private Message isValidTurnRed(int startRow, int startCell, int startRow1, int endRow) {
        Message message = new Message();
        if(moveState == moveStatCode.MOVEMENT_MADE){
            message.text = "You have already made a move!";
            message.type = "error";
        }
        else if(endRow == startRow + 1){
            if(endCell == startCell + 1 || endCell == startCell - 1){
                message.text = "Valid move";
                message.type = "info";
                moveState = moveStatCode.MOVEMENT_MADE;
            }
            else {
                message.text = "Invalid move, only diagonals forwards are allowed";
                message.type = "error";
                moveState = moveStatCode.NO_MOVEMENT;
            }
        }
        else if(endRow == startRow + 2){
            if(endCell == startCell + 2 || endCell == startCell - 2){
                if((endCell == startCell + 2 && this.getBoard().getRow(endRow - 1).getSpace(endCell - 1).getPiece() != null) || (endCell == startCell - 2 && this.getBoard().getRow(endRow - 1).getSpace(endCell + 1).getPiece() != null)){
                    message.text = "Valid move! Get that piece!";
                    message.type = "info";
                    moveState = moveStatCode.CAPTURE_MODE;
                }
                else {
                    message.text = "Invalid move";
                    message.type = "error";
                    moveState = moveStatCode.NO_MOVEMENT;
                }
            }
            else {
                message.text = "Invalid move, only diagonal forwards are allowed";
                message.type = "error";
                moveState = moveStatCode.NO_MOVEMENT;
            }
        }
        else{
            message.type = "error";
            message.text = "Invalid move!";
            moveState = moveStatCode.NO_MOVEMENT;
        }
        if(moveState == moveStatCode.MOVEMENT_MADE){
            movements = new Movement(startRow, startCell, endRow, endCell);
            Piece piece = this.getBoard().getRow(startRow).getSpace(startCell).getPiece();
            this.getBoard().getRow(startRow).getSpace(startCell).setPiece(null);
            this.getBoard().getRow(endRow).getSpace(endCell).setPiece(piece);
        }
        return message;
    }

    private Message isValidTurnWhite(int startRow, int startCell, int endRow, int endCell){
        Message message = new Message();
        if(moveState == moveStatCode.MOVEMENT_MADE){
            message.text = "You have already made a move!";
            message.type = "error";
        }
        else if(endRow == startRow - 1){
            if(endCell == startCell + 1 || endCell == startCell - 1){
                message.text = "Valid move";
                message.type = "info";
                moveState = moveStatCode.MOVEMENT_MADE;
            }
            else {
                message.text = "Invalid move, only diagonals forwards are allowed";
                message.type = "error";
                moveState = moveStatCode.NO_MOVEMENT;
            }
        }
        else if(endRow == startRow - 2){
            if(endCell == startCell + 2 || endCell == startCell - 2){
                if((endCell == startCell + 2 && this.getBoard().getRow(endRow + 1).getSpace(endCell - 1).getPiece() != null) || (endCell == startCell + 2 && this.getBoard().getRow(endRow + 1).getSpace(endCell + 1).getPiece() != null)){
                    message.text = "Valid move! Get that piece!";
                    message.type = "info";
                    moveState = moveStatCode.CAPTURE_MODE;
                }
                else {
                    message.text = "Invalid move";
                    message.type = "error";
                    moveState = moveStatCode.NO_MOVEMENT;
                }
            }
            else {
                message.text = "Invalid move, only diagonal forwards are allowed";
                message.type = "error";
                moveState = moveStatCode.NO_MOVEMENT;
            }
        }
        else{
            message.type = "error";
            message.text = "Invalid move!";
            moveState = moveStatCode.NO_MOVEMENT;
        }
        if(moveState == moveStatCode.MOVEMENT_MADE){
            movements = (new Movement(startRow, startCell, endRow, endCell));
            Piece piece = this.getBoard().getRow(startRow).getSpace(startCell).getPiece();
            this.getBoard().getRow(startRow).getSpace(startCell).setPiece(null);
            this.getBoard().getRow(endRow).getSpace(endCell).setPiece(piece);
        }
        return message;
    }

    public void popMove(){
        Movement latestMovement = movements;
        Piece piece = this.getBoard().getRow(latestMovement.getEndRow()).getSpace(latestMovement.getEndCell()).getPiece();
        this.getBoard().getRow(latestMovement.getEndRow()).getSpace(latestMovement.getEndCell()).setPiece(null);
        this.getBoard().getRow(latestMovement.getStartRow()).getSpace(latestMovement.getStartCell()).setPiece(piece);
        movements = null;
        moveState = moveStatCode.NO_MOVEMENT;
    }

    public void makeMove() {
        if (moveState == moveStatCode.CAPTURE_MODE){
            //FIXME remove the piece.
            if(isPlayer1Turn){
                if(this.getBoard()
                    .getRow(movements.getEndRow() - 1)
                    .getSpace( movements.getEndCell() - 1)
                    .getPiece() != null){
                    this.getBoard()
                        .getRow(movements.getEndRow() - 1)
                        .getSpace( movements.getEndCell() - 1)
                        .setPiece(null);
                    System.out.println("Piece is on the back left");
                }
                else if(this.getBoard()
                    .getRow(movements.getEndRow() - 1)
                    .getSpace(movements.getEndCell() +  1)
                    .getPiece() != null) {
                    this.getBoard()
                        .getRow(movements.getEndRow() - 1)
                        .getSpace(movements.getEndCell() + 1)
                        .setPiece(null);
                    System.out.println("Piece is on the back right");
                }
                isPlayer2Turn = true;
                isPlayer1Turn = false;
            }
            else if(isPlayer2Turn){
                if(this.getBoard()
                    .getRow(movements.getEndRow() + 1)
                    .getSpace( movements.getEndCell() - 1)
                    .getPiece() != null){
                    this.getBoard()
                        .getRow(movements.getEndRow() + 1)
                        .getSpace( movements.getEndCell() - 1)
                        .setPiece(null);
                    System.out.println("Piece is on the back left");
                }
                else if(this.getBoard()
                    .getRow(movements.getEndRow() + 1)
                    .getSpace(movements.getEndCell() +  1)
                    .getPiece() != null) {
                    this.getBoard()
                        .getRow(movements.getEndRow() + 1)
                        .getSpace(movements.getEndCell() + 1).setPiece(null);
                    System.out.println("Piece is on the back right");
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
        moveState = moveStatCode.NO_MOVEMENT;
    }

}
