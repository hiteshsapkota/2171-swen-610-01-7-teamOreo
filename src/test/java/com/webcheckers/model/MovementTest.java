package com.webcheckers.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MovementTest {
  private Movement movement;

  @Before
  public void start(){
    movement = new Movement(1, 2, 3, 4);
  }

  @Test
  public void getStartRow() throws Exception {
    assertEquals(1, movement.getStartRow());
  }



  @Test
  public void getStartCell() throws Exception {
    assertEquals(2, movement.getStartCell());
  }

  @Test
  public void getEndRow() throws Exception {
    assertEquals(3, movement.getEndRow());
  }

  @Test
  public void getEndCell() throws Exception {
    assertEquals(4, movement.getEndCell());
  }

}