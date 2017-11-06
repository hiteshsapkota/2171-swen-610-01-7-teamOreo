package com.webcheckers.model.Board;

import static org.junit.Assert.*;

import com.webcheckers.model.Board.Space.SPACECOLOR;
import org.junit.Before;
import org.junit.Test;

public class RowTest {
  private Row row;

  @Before
  public void start(){
    row = new Row(1);
  }

  @Test
  public void getSpace() throws Exception {
    assertEquals(SPACECOLOR.WHITE, row.getSpace(1).getSpaceColor());
    assertEquals(SPACECOLOR.BLACK, row.getSpace(2).getSpaceColor());

  }

  @Test
  public void getIndex() throws Exception {
    assertEquals(1, row.getIndex());
  }

  @Test
  public void setIndex() throws Exception {
    row.setIndex(2);
    assertEquals(2, row.getIndex());
  }

}