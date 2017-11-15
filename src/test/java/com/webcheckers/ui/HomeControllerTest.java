package com.webcheckers.ui;

import static com.webcheckers.model.Strings.CURRENT_PLAYER_ATTR;
import static com.webcheckers.model.Strings.HOME_VIEW;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import java.util.HashMap;
import org.junit.Test;
import spark.HaltException;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

public class HomeControllerTest {

  @Test
  public void handle() throws Exception {
    GameCenter gameCenter = mock(GameCenter.class);
    HomeController homeController = new HomeController(gameCenter);
    Request request = mock(Request.class);
    Response response = mock(Response.class);
    Session session = mock(Session.class);
//    OnlinePlayers players = mock(OnlinePlayers.class);

    when(request.session()).thenReturn(session);
    when(session.attribute("user")).thenReturn(null);

    ModelAndView modelAndView = homeController.handle(request, response);
    HashMap vm = (HashMap) modelAndView.getModel();

    assertFalse((boolean)vm.get(CURRENT_PLAYER_ATTR));
    assertEquals(HOME_VIEW, modelAndView.getViewName());

  }


  @Test
  public void handle2() throws Exception {
    GameCenter gameCenter = mock(GameCenter.class);
    HomeController homeController = new HomeController(gameCenter);
    Request request = mock(Request.class);
    Response response = mock(Response.class);
    Session session = mock(Session.class);
    OnlinePlayers players = mock(OnlinePlayers.class);
    String user = "test";

    when(players.getName()).thenReturn(user);
    when(request.session()).thenReturn(session);
    when(session.attribute("user")).thenReturn(players);
    when(gameCenter.userIsFree(players.getName())).thenReturn(true);

    ModelAndView modelAndView = homeController.handle(request, response);
    HashMap vm = (HashMap) modelAndView.getModel();

    assertTrue((boolean)vm.get(CURRENT_PLAYER_ATTR));
    assertEquals(HOME_VIEW, modelAndView.getViewName());

  }


  @Test
  public void handle3() throws Exception {
    try{
      GameCenter gameCenter = mock(GameCenter.class);
      HomeController homeController = new HomeController(gameCenter);
      Request request = mock(Request.class);
      Response response = mock(Response.class);
      Session session = mock(Session.class);
      OnlinePlayers players = mock(OnlinePlayers.class);
      String user = "test";

      when(players.getName()).thenReturn(user);
      when(request.session()).thenReturn(session);
      when(session.attribute("user")).thenReturn(players);
      when(gameCenter.userIsFree(players.getName())).thenReturn(false);

      assertNull(homeController.handle(request, response));
    }
    catch (HaltException e){
      System.out.println("Halt Exception");
    }
  }

}