package com.webcheckers.ui.Login;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import org.junit.Test;

import static org.junit.Assert.*;


import spark.Request;
import spark.Response;
import spark.Session;


import static com.webcheckers.model.Strings.SIGNIN_VIEW;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class GetSignInControllerTest {

  @Test
  public void handle1(){
    Request request = mock(Request.class);
    Response response = mock(Response.class);
    Session session = mock(Session.class);
    OnlinePlayers players = mock(OnlinePlayers.class);
    GameCenter gameCenter = mock(GameCenter.class);

    when(request.session()).thenReturn(session);
    when(session.attribute("user")).thenReturn(players);

    GetSignInController getSignInController = new GetSignInController(gameCenter);

    assertNull(getSignInController.handle(request, response));
  }

  @Test
  public void handle2(){
    Request request = mock(Request.class);
    Response response = mock(Response.class);
    Session session = mock(Session.class);
    GameCenter gameCenter = mock(GameCenter.class);

    when(request.session()).thenReturn(session);
    when(session.attribute("user")).thenReturn(null);

    GetSignInController getSignInController = new GetSignInController(gameCenter);

    assertEquals(SIGNIN_VIEW, getSignInController.handle(request, response).getViewName());
  }
}