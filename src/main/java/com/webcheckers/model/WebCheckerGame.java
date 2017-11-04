package com.webcheckers.model;

import com.webcheckers.model.Board.Board;
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
}
