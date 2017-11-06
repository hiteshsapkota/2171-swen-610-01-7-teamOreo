package com.webcheckers.appl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.webcheckers.model.OnlinePlayers;
import org.junit.Before;
import org.junit.Test;
import spark.Session;

public class GameCenterTest {
  private GameCenter test;

  @Before
  public void setup(){
    test = new GameCenter();
  }

  @Test
  public void login() throws Exception {
    String username = "test";
    Session session = mock(Session.class);
    test.login(session, username);
    assertEquals(username, test.getPlayer(username).getName());
  }

  @Test
  public void logout() throws Exception {
    String username = "test";
    Session session = mock(Session.class);
    test.login(session, username);
    OnlinePlayers onlinePlayers = mock(OnlinePlayers.class);
    when(onlinePlayers.getName()).thenReturn(username);
    when(session.attribute("user")).thenReturn(onlinePlayers);
    test.logout(session);
    assertFalse(test.userAlreadyExists(username));
  }

  @Test
  public void userAlreadyExists() throws Exception {
    String username = "test";
    String different = "test1";
    Session session = mock(Session.class);
    test.login(session, username);
    assertTrue(test.userAlreadyExists(username));
    assertFalse(test.userAlreadyExists(different));
  }

  @Test
  public void userIsFree() throws Exception {
    String username = "test";
    Session session = mock(Session.class);
    test.login(session, username);
    test.getPlayer(username).setFree(true);
    assertTrue(test.userIsFree(username));
    test.getPlayer(username).setFree(false);
    assertFalse(test.userIsFree(username));
  }

  @Test
  public void getPlayer() throws Exception {
    String username = "test";
    Session session = mock(Session.class);
    test.login(session, username);
    assertEquals(username, test.getPlayer(username).getName());
  }

  @Test
  public void getAllAvailablePlayers() throws Exception {
    String usernames[] = {"test", "test1", "test2"};
    Session session = mock(Session.class);
    for(String name: usernames){
      test.login(session, name);
    }
    assertEquals(usernames.length, test.getAllAvailablePlayers().size());
    test.getPlayer(usernames[0]).setFree(false);
    assertEquals(usernames.length - 1, test.getAllAvailablePlayers().size());
  }

  @Test
  public void addGame() throws Exception {
    String p1 = "test1";
    String p2 = "test2";
    Session session = mock(Session.class);
    test.login(session, p1);
    test.login(session, p2);
    assertEquals(test.addGame(p1, p2), test.getGame(p1));
    assertFalse(test.userIsFree(p1));
    assertFalse(test.userIsFree(p2));
  }
}