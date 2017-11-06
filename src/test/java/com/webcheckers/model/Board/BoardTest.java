package com.webcheckers.model.Board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
  private Board board;

  @Before
  public void start(){
    board = new Board();
  }

  @Test
  public void getRow() throws Exception {
    for (int i = 0; i < 8; i++) {
      assertEquals(i, board.getRow(i).getIndex());
    }

  }

  @Test
  public void iterator() throws Exception {
  }

}