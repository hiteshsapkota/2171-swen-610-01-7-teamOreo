package com.webcheckers.ui.Login;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.webcheckers.appl.GameCenter;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Session;

public class GetSignOutControllerTest {

  @Test
  public void handle1(){
    Request request = mock(Request.class);
    Response response = mock(Response.class);
    Session session = mock(Session.class);
    GameCenter gameCenter = mock(GameCenter.class);

    when(request.session()).thenReturn(session);

    GetSignOutController getSignOutController = new GetSignOutController(gameCenter);

    assertNull(getSignOutController.handle(request, response));
  }

}