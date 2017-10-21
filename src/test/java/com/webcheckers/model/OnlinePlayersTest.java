package com.webcheckers.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Testing The OnlinePlayersClass
 */
public class OnlinePlayersTest {
  OnlinePlayers mockOnlinePlayers;
  String testName;

  @Before
  public void initialize(){
    testName = "Dishant";
  }

  @Test
  public void testConstructor(){
    mockOnlinePlayers = new OnlinePlayers(testName);
    assertEquals(testName, mockOnlinePlayers.getName());
    assertTrue(mockOnlinePlayers.isFree());
  }

  @Test
  public void testConstructorWithParameters(){
    mockOnlinePlayers = new OnlinePlayers(testName, true);
    assertEquals(testName, mockOnlinePlayers.getName());
    assertTrue(mockOnlinePlayers.isFree());
  }

  @Test
  public void testClassNameToString(){
    mockOnlinePlayers = new OnlinePlayers(testName);
    assertEquals(testName, mockOnlinePlayers.toString());
  }

  @Test
  public void testEqualsAndHashCode(){
    mockOnlinePlayers = new OnlinePlayers(testName);
    OnlinePlayers mock2 = new OnlinePlayers(testName);
    assertEquals(mockOnlinePlayers, mock2);
    assertTrue("Worked?", (mockOnlinePlayers.hashCode() == mock2.hashCode()));
  }


}