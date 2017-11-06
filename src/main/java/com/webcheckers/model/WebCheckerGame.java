package com.webcheckers.model;

import com.webcheckers.model.Board.Board;
import com.webcheckers.model.Board.Piece;
import com.webcheckers.model.Board.Piece.colorEnum;
import java.util.Objects;

import static com.webcheckers.model.Strings.*;

public class WebCheckerGame
{
    private Board board;
    private String player1;
    private colorEnum player1Color;
    private boolean     isPlayer1Turn;
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
        Message message = new Message();
        if(moveState == moveStatCode.MOVEMENT_MADE || moveState == moveStatCode.CAPTURE_MODE){
            message.text = INVALID_ALREADY_MADE;
            message.type = MESSAGE_ERROR;
            return message;
        }

        if(Objects.equals(user, this.player1)){
            message = isValidTurnRed(startRow, startCell, endRow, endCell);
        }
        else{
            message = isValidTurnWhite(startRow, startCell, endRow, endCell);
        }
        if(moveState == moveStatCode.MOVEMENT_MADE || moveState == moveStatCode.CAPTURE_MODE){
            movements = new Movement(startRow, startCell, endRow, endCell);
            Piece piece = getPiece(startRow, startCell);
            setPiece(startRow, startCell, null);
            setPiece(endRow, endCell, piece);
        }
        return message;
    }

    private Message isValidTurnRed(int startRow, int startCell, int endRow, int endCell) {
        Message message = new Message();
        if(endRow == startRow + 1){
            if(endCell == startCell + 1 || endCell == startCell - 1){
                message.text = VALID_MOVE;
                message.type = MESSAGE_INFO;
                moveState = moveStatCode.MOVEMENT_MADE;
            }
            else {
                message.text = INVALID_ONLY_DIAGONALS;
                message.type = MESSAGE_ERROR;
                moveState = moveStatCode.NO_MOVEMENT;
            }
        }
        else if(endRow == startRow + 2){
            if(endCell == startCell + 2 || endCell == startCell - 2){
                if((endCell == startCell + 2
                    && getPiece(endRow - 1, endCell - 1) != null
                    && getPiece(endRow - 1, endCell - 1).getColor() == this.player2Color)
                    || (endCell == startCell - 2
                    && getPiece(endRow - 1, endCell + 1) != null
                    && getPiece(endRow - 1, endCell + 1).getColor() == this.player2Color)){
                    message.text = VALID_GET_PIECE;
                    message.type = MESSAGE_INFO;
                    moveState = moveStatCode.CAPTURE_MODE;
                }
                else {
                    message.text = INVALID_MOVE;
                    message.type = MESSAGE_ERROR;
                    moveState = moveStatCode.NO_MOVEMENT;
                }
            }
            else {
                message.text = INVALID_ONLY_DIAGONALS;
                message.type = MESSAGE_ERROR;
                moveState = moveStatCode.NO_MOVEMENT;
            }
        }
        else{
            message.type = MESSAGE_ERROR;
            message.text = INVALID_MOVE;
            moveState = moveStatCode.NO_MOVEMENT;
        }
        return message;
    }

    private Message isValidTurnWhite(int startRow, int startCell, int endRow, int endCell){
        Message message = new Message();
        if(endRow == startRow - 1){
            if(endCell == startCell + 1 || endCell == startCell - 1){
                message.text = VALID_MOVE;
                message.type = MESSAGE_INFO;
                moveState = moveStatCode.MOVEMENT_MADE;
            }
            else {
                message.text = INVALID_ONLY_DIAGONALS;
                message.type = MESSAGE_ERROR;
                moveState = moveStatCode.NO_MOVEMENT;
            }
        }
        else if(endRow == startRow - 2){
            if(endCell == startCell + 2 || endCell == startCell - 2){
                if((endCell == startCell + 2
                    && getPiece(startRow - 1, startCell + 1) != null
                    && getPiece(startRow - 1, startCell + 1).getColor() == player1Color)
                    || (endCell == startCell - 2
                    && getPiece(startRow - 1, startCell - 1) != null
                    && getPiece(startRow - 1, startCell - 1).getColor() == player1Color)){
                    message.text = VALID_GET_PIECE;
                    message.type = MESSAGE_INFO;
                    moveState = moveStatCode.CAPTURE_MODE;
                }
                else {
                    message.text = INVALID_MOVE;
                    message.type = MESSAGE_ERROR;
                    moveState = moveStatCode.NO_MOVEMENT;
                }
            }
            else {
                message.text = INVALID_ONLY_DIAGONALS;
                message.type = MESSAGE_ERROR;
                moveState = moveStatCode.NO_MOVEMENT;
            }
        }
        else{
            message.type = MESSAGE_ERROR;
            message.text = INVALID_MOVE;
            moveState = moveStatCode.NO_MOVEMENT;
        }
        return message;
    }

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
        movements = null;
        moveState = moveStatCode.NO_MOVEMENT;
    }

    private Piece getPiece(int x, int y){
        return this.getBoard().getRow(x).getSpace(y).getPiece();
    }

    private void setPiece(int x, int y, Piece piece){
        this.getBoard().getRow(x).getSpace(y).setPiece(piece);
    }
}

