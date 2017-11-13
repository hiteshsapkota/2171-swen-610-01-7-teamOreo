package com.webcheckers.model;

import static com.webcheckers.model.Strings.*;
import static org.junit.Assert.*;

import com.webcheckers.model.Board.Board;
import com.webcheckers.model.Board.Piece;
import com.webcheckers.model.Board.Piece.colorEnum;
import com.webcheckers.model.Board.Piece.typeEnum;
import org.junit.Test;

public class WebCheckerGameTest {
  private String p1 = "test";
  private String p2 = "test2";
  private WebCheckerGame game = new WebCheckerGame(p1, p2);

  @Test
  public void isMyTurn() throws Exception {
    assertTrue(game.isMyTurn(p1));
    assertFalse(game.isMyTurn(p2));
  }

  @Test
  public void getBoard() throws Exception {
    assertEquals(Board.class, game.getBoard().getClass());
  }

  @Test
  public void getPlayer() throws Exception {
    assertEquals(p1, game.getPlayer(p1));
    assertEquals(p2, game.getPlayer(p2));
    assertNotEquals(p1, game.getPlayer(p2));
  }

  @Test
  public void getOpponent() throws Exception {
    assertEquals(p1, game.getOpponent(p2));
    assertEquals(p2, game.getOpponent(p1));
  }

  @Test
  public void getPlayerColor() throws Exception {
    assertEquals(colorEnum.RED ,game.getPlayerColor(p1));
    assertEquals(colorEnum.WHITE, game.getPlayerColor(p2));
  }

  @Test
  public void getOpponentColor() throws Exception {
    assertEquals(colorEnum.WHITE, game.getOpponentColor(p1));
    assertEquals(colorEnum.RED, game.getOpponentColor(p2));
  }

  @Test
  public void hasPlayer() throws Exception {
    assertTrue(game.hasPlayer(p1));
    assertTrue(game.hasPlayer(p2));
    assertFalse(game.hasPlayer("notingame"));
  }

  @Test
  public void isValidTurn() throws Exception {

  }



  @Test
  public void makeMove(){
    assertTrue(game.isMyTurn(p1));

    // 2,1 to 3, 2
    game.checkAllPieceForMovements();
    assertEquals(MESSAGE_INFO, (game.isValidTurn(2, 1, 3, 2)).type);

    game.makeMove();
    assertTrue(game.isMyTurn(p2));

    // 5,0 to 4,1
    game.checkAllPieceForMovements();
    assertEquals(MESSAGE_INFO, (game.isValidTurn(5, 0, 4, 1).type));

    game.makeMove();

    assertTrue(game.isMyTurn(p1));

    game.checkAllPieceForMovements();
    // capture mode, 3,2 to 5,0
    assertEquals(MESSAGE_INFO, (game.isValidTurn(3, 2, 5, 0).type));

    assertFalse(game.popMove());

    game.makeMove();

    assertTrue(game.isMyTurn(p2));

    //Create a scenario for double capture.
    Piece piece = game.getBoard().getRow(5).getSpace(0).getPiece();
    game.getBoard().getRow(5).getSpace(0).setPiece(null);
    game.getBoard().getRow(4).getSpace(1).setPiece(piece);

    piece = game.getBoard().getRow(1).getSpace(2).getPiece();
    game.getBoard().getRow(1).getSpace(2).setPiece(null);



  }

  @Test
  public void checkAllPieceForMovements(){
    //Condition1
    resetBoard();
    game.getBoard().getRow(1).getSpace(2).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(2).getSpace(1).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(2).getSpace(3).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    resetBoard();
    game.getBoard().getRow(1).getSpace(2).setPiece(new Piece(typeEnum.SINGLE,colorEnum.RED));
    game.getBoard().getRow(2).getSpace(1).setPiece(new Piece(typeEnum.SINGLE,colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(3).getSpace(0).setPiece(new Piece(typeEnum.SINGLE,colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(3).getSpace(0).setPiece(new Piece(typeEnum.SINGLE,colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(2).getSpace(3).setPiece(new Piece(typeEnum.SINGLE,colorEnum.WHITE));
    game.getBoard().getRow(3).getSpace(4).setPiece(new Piece(typeEnum.SINGLE,colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(3).getSpace(4).setPiece(new Piece(typeEnum.SINGLE,colorEnum.WHITE));
    game.checkAllPieceForMovements();
    resetBoard();
    game.getBoard().getRow(2).getSpace(1).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.getBoard().getRow(3).getSpace(0).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    //check for second condition
    resetBoard();
    game.getBoard().getRow(5).getSpace(2).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(4).getSpace(1).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(4).getSpace(3).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();

    game.getBoard().getRow(4).getSpace(1).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(3).getSpace(0).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(3).getSpace(0).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();


    game.getBoard().getRow(3).getSpace(4).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(4).getSpace(3).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    resetBoard();
    game.getBoard().getRow(6).getSpace(1).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.getBoard().getRow(5).getSpace(0).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    resetBoard();
    //Check condition for king piece
    //First condition

    game.getBoard().getRow(1).getSpace(4).setPiece(new Piece(typeEnum.KING, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(0).getSpace(3).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(0).getSpace(5).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(2).getSpace(3).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(2).getSpace(5).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(0).getSpace(3).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(0).getSpace(5).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(2).getSpace(3).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(3).getSpace(2).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(3).getSpace(2).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(3).getSpace(6).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(3).getSpace(6).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    resetBoard();

    //Second Condition
    game.getBoard().getRow(5).getSpace(4).setPiece(new Piece(typeEnum.KING, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(6).getSpace(3).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(6).getSpace(5).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(4).getSpace(3).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(4).getSpace(5).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(6).getSpace(3).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(7).getSpace(2).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(7).getSpace(2).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();



    game.getBoard().getRow(6).getSpace(5).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(7).getSpace(6).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(7).getSpace(6).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();



    game.getBoard().getRow(4).getSpace(3).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(3).getSpace(2).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(3).getSpace(2).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();


    game.getBoard().getRow(4).getSpace(5).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(3).getSpace(6).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(3).getSpace(6).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();

resetBoard();
    game.getBoard().getRow(7).getSpace(2).setPiece(new Piece(typeEnum.KING, colorEnum.WHITE));
    game.checkAllPieceForMovements();

    game.getBoard().getRow(6).getSpace(1).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();

    game.getBoard().getRow(5).getSpace(0).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(5).getSpace(0).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();


    game.getBoard().getRow(6).getSpace(3).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();

    game.getBoard().getRow(5).getSpace(4).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    game.checkAllPieceForMovements();
    game.getBoard().getRow(5).getSpace(4).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    game.checkAllPieceForMovements();
  }

  private void resetBoard(){
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        game.getBoard().getRow(i).getSpace(j).setPiece(null);
      }
    }
  }


}