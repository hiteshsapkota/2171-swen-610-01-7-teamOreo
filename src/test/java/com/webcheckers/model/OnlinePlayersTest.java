package com.webcheckers.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OnlinePlayersTest {
  private OnlinePlayers onlinePlayers;
  private final String test = "test";

  @Before
  public void start(){
    onlinePlayers = new OnlinePlayers(test);
  }

  @Test
  public void getName() throws Exception {
    assertEquals(test, onlinePlayers.getName());
  }

  @Test
  public void isFree() throws Exception {
    assertTrue(onlinePlayers.isFree());
  }

  @Test
  public void setFree() throws Exception {
    onlinePlayers.setFree(false);
    assertFalse(onlinePlayers.isFree());
  }

  @Test
  public void equals() throws Exception {
    OnlinePlayers p2 = new OnlinePlayers(test);
    assertTrue(onlinePlayers.equals(p2));
    assertFalse(onlinePlayers.getName().equals(null));
//    assertFalse(onlinePlayers.getName().equals(test));

  }

}