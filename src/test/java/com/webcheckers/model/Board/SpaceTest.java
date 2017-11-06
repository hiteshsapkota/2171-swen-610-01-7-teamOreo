package com.webcheckers.model.Board;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.webcheckers.model.Board.Space.SPACECOLOR;
import org.junit.Before;
import org.junit.Test;

public class SpaceTest {
  private Space space;

  @Before
  public void start(){
    space = new Space(1, SPACECOLOR.BLACK, null);
  }

  @Test
  public void getSpaceColor() throws Exception {
    assertEquals(SPACECOLOR.BLACK, space.getSpaceColor());
  }

  @Test
  public void getCellIdx() throws Exception {
    assertEquals(1, space.getCellIdx());
  }

  @Test
  public void setCellIdx() throws Exception {
    space.setCellIdx(2);
    assertEquals(2, space.getCellIdx());
  }

  @Test
  public void isValid() throws Exception {
    assertTrue(space.isValid());
    space.setPiece(mock(Piece.class));
    assertFalse(space.isValid());
  }

  @Test
  public void getPiece() throws Exception {
    Piece piece = mock(Piece.class);
    assertNull(space.getPiece());
    space.setPiece(piece);
    assertNotNull(space.getPiece());
    assertEquals(piece, space.getPiece());
  }

}