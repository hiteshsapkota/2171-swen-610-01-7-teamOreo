package com.webcheckers.model;

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
    Message message = game.isValidTurn(1,1,1,1, p1);
    assertEquals("error", message.type);
    assertEquals("Invalid move!", message.text);
    message = game.isValidTurn(1,1,2,2, p1);
    assertEquals("info", message.type);
    assertEquals("Valid move", message.text);
    assertTrue(game.popMove());
    game.getBoard().getRow(3).getSpace(2).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
    message = game.isValidTurn(2, 1, 4, 3, p1);
    assertEquals("info", message.type);
    assertEquals("Valid move! Get that piece!", message.text);
    assertFalse(game.popMove());
    game.makeMove();

    message = game.isValidTurn(5, 0, 5, 5, p2);
    assertEquals("error", message.type);
    assertEquals("Invalid move!", message.text);
    message = game.isValidTurn(5, 0, 4, 1, p2);
    assertEquals("info", message.type);
    assertEquals("Valid move", message.text);
    assertTrue(game.popMove());
    game.getBoard().getRow(4).getSpace(1).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
    message = game.isValidTurn(5, 0, 3, 2, p2);
    System.out.println(message.type + message.text);
    assertEquals("info", message.type);
    assertEquals("Valid move! Get that piece!", message.text);
    assertFalse(game.popMove());
    game.makeMove();

  }
}