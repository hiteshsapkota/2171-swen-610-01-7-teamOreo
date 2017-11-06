package com.webcheckers.model.Board;

import static org.junit.Assert.*;

import com.webcheckers.model.Board.Piece.colorEnum;
import com.webcheckers.model.Board.Piece.typeEnum;
import org.junit.Before;
import org.junit.Test;

public class PieceTest {
  private Piece piece;

  @Before
  public void start(){
    piece = new Piece(typeEnum.SINGLE, colorEnum.WHITE);
  }

  @Test
  public void getType() throws Exception {
    assertEquals(typeEnum.SINGLE ,piece.getType());
  }

  @Test
  public void setType() throws Exception {
    piece.setType(typeEnum.KING);
    assertEquals(typeEnum.KING, piece.getType());
  }

  @Test
  public void getColor() throws Exception {
    assertEquals(colorEnum.WHITE, piece.getColor());
  }

  @Test
  public void setColor() throws Exception {
    piece.setColor(colorEnum.RED);
    assertEquals(colorEnum.RED, piece.getColor());
  }

}