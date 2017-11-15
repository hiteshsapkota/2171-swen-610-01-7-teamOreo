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
    space = new Space(1, SPACECOLOR.BLACK);
  }

  @Test
  public void getSpaceColor() throws Exception {
    assertEquals(SPACECOLOR.BLACK, space.getSpaceColor());
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