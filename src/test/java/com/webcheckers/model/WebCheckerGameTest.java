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
}