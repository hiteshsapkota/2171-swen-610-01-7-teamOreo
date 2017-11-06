package com.webcheckers.ui.Game;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Message;
import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.model.WebCheckerGame;
import org.junit.Before;
import org.junit.Test;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

public class PostBackUpMoveControllerTest {
  private PostBackUpMoveController postBackUpMoveController;
  private GameCenter gameCenter = mock(GameCenter.class);
  @Before
  public void start(){

    postBackUpMoveController = new PostBackUpMoveController(gameCenter);
  }

  @Test
  public void handle1() throws Exception {
    Session session = mock(Session.class);
    Request request = mock(Request.class);
    Response response = mock(Response.class);
    OnlinePlayers player = mock(OnlinePlayers.class);
    String user = "test";
    WebCheckerGame game = mock(WebCheckerGame.class);

    when(request.session()).thenReturn(session);
    when(session.attribute("user")).thenReturn(player);
    when(player.getName()).thenReturn(user);
    when(gameCenter.getGame(user)).thenReturn(game);

    when(game.popMove()).thenReturn(true);

    Message trueMessage = (Message) postBackUpMoveController.handle(request, response);
    assertEquals("Backed Up the Move", trueMessage.text);
    assertEquals("info", trueMessage.type);
  }

  @Test
  public void handle2() throws Exception{
    Session session = mock(Session.class);
    Request request = mock(Request.class);
    Response response = mock(Response.class);
    OnlinePlayers player = mock(OnlinePlayers.class);
    String user = "test";
    WebCheckerGame game = mock(WebCheckerGame.class);

    when(request.session()).thenReturn(session);
    when(session.attribute("user")).thenReturn(player);
    when(player.getName()).thenReturn(user);
    when(gameCenter.getGame(user)).thenReturn(game);

    when(game.popMove()).thenReturn(false);

    Message trueMessage = (Message) postBackUpMoveController.handle(request, response);
    assertEquals("This is a forced move because of the disk capture", trueMessage.text);
    assertEquals("error", trueMessage.type);
  }

}