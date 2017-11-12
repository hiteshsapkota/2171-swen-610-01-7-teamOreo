package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.OPPONENT_ATTR;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Session;

public class StartPlayControllerTest {
  private StartPlayController startPlayController;
  private GameCenter gameCenter = mock(GameCenter.class);
  @Before
  public void start(){

    startPlayController = new StartPlayController(gameCenter);
  }

  @Test
  public void handle1() throws Exception {
    Session session = mock(Session.class);
    Request request = mock(Request.class);
    Response response = mock(Response.class);
    OnlinePlayers player = mock(OnlinePlayers.class);
    String user = "test";
    String opponent = "test2";
    when(request.session()).thenReturn(session);
    when(session.attribute("user")).thenReturn(player);
    when(player.getName()).thenReturn(user);
    when(request.queryParams(OPPONENT_ATTR)).thenReturn(opponent);
    when(gameCenter.userIsFree(opponent)).thenReturn(true);

    assertNull(startPlayController.handle(request, response));

    when(gameCenter.userIsFree(opponent)).thenReturn(false);
    assertNull(startPlayController.handle(request, response));

  }



}