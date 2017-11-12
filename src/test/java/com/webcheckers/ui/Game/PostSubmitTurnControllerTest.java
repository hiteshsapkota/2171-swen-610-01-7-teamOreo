package com.webcheckers.ui.Game;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.model.WebCheckerGame;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Session;

public class PostSubmitTurnControllerTest {
  private PostSubmitTurnController postSubmitTurnController;
  private GameCenter gameCenter = mock(GameCenter.class);
  @Before
  public void start(){

    postSubmitTurnController = new PostSubmitTurnController(gameCenter);
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

    Object object = postSubmitTurnController.handle(request, response);
    assertNull(object);
  }

}