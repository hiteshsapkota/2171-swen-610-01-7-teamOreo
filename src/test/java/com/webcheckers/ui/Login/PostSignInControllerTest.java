package com.webcheckers.ui.Login;

import static com.webcheckers.model.Strings.MESSAGE_ATTR;
import static com.webcheckers.model.Strings.MESSAGE_EMPTY_NAME;
import static com.webcheckers.model.Strings.MESSAGE_USER_EXISTS;
import static com.webcheckers.model.Strings.SIGNIN_VIEW;
import static com.webcheckers.model.Strings.USERNAME_ATTR;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.webcheckers.appl.GameCenter;
import java.util.HashMap;
import org.junit.Test;
import spark.HaltException;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

public class PostSignInControllerTest {

  @Test
  public void handle1() throws Exception {
    GameCenter gameCenter = mock(GameCenter.class);
    PostSignInController postSignInController = new PostSignInController(gameCenter);
    Request request = mock(Request.class);
    Response response = mock(Response.class);

    when(request.queryParams(USERNAME_ATTR)).thenReturn("");

    ModelAndView modelAndView = postSignInController.handle(request, response);

    assertEquals(SIGNIN_VIEW, modelAndView.getViewName());

    HashMap<String, Object> vm = (HashMap) modelAndView.getModel();

    assertEquals(MESSAGE_EMPTY_NAME, vm.get(MESSAGE_ATTR));
  }

  @Test
  public void handle2(){
    GameCenter gameCenter = mock(GameCenter.class);
    PostSignInController postSignInController = new PostSignInController(gameCenter);
    Request request = mock(Request.class);
    Response response = mock(Response.class);
    String user = "test";

    when(request.queryParams(USERNAME_ATTR)).thenReturn(user);
    when(gameCenter.userAlreadyExists(user)).thenReturn(true);

    ModelAndView modelAndView = postSignInController.handle(request, response);

    assertEquals(SIGNIN_VIEW, modelAndView.getViewName());

    HashMap<String, Object> vm = (HashMap) modelAndView.getModel();

    assertEquals(MESSAGE_USER_EXISTS, vm.get(MESSAGE_ATTR));
  }

  @Test
  public void handle3(){
    try{
      GameCenter gameCenter = mock(GameCenter.class);
      PostSignInController postSignInController = new PostSignInController(gameCenter);
      Request request = mock(Request.class);
      Response response = mock(Response.class);
      String user = "test";
      Session session = mock(Session.class);
      when(request.session()).thenReturn(session);
      when(request.queryParams(USERNAME_ATTR)).thenReturn(user);
      when(gameCenter.userAlreadyExists(user)).thenReturn(false);

      assertNull(postSignInController.handle(request, response));
    }
    catch (HaltException e){
      System.out.println("Halt Exception");
    }
  }
}