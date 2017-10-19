package com.webcheckers.ui.Login;

import static com.webcheckers.model.Strings.HOME_VIEW;
import static com.webcheckers.model.Strings.MESSAGE_ATTR;
import static com.webcheckers.model.Strings.MESSAGE_EMPTY_NAME;
import static com.webcheckers.model.Strings.MESSAGE_SIGNED_IN;
import static com.webcheckers.model.Strings.MESSAGE_USER_EXISTS;
import static com.webcheckers.model.Strings.SIGNIN_VIEW;
import static com.webcheckers.model.Strings.USERNAME_ATTR;
import static org.junit.Assert.*;

import com.webcheckers.model.OnlinePlayers;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

public class PostSignInControllerTest {
  private Request request;
  private Response response;
  private ModelAndView modelAndView;
  private Map<String, Object> vm ;
  private Session session;

  /**
   * setup sets up the mock classes required by the PostSignInController.
   */
  @Before
  public void setup(){
    request = Mockito.mock(Request.class);
    response = Mockito.mock(Response.class);
    modelAndView = Mockito.mock(ModelAndView.class);
    vm = Mockito.mock(HashMap.class);
    session = Mockito.mock(Session.class);
  }


  /**
   * checkIfEmptyNamePasses tests when a null is sent as a username,
   * it should show appropriate message and take you to login screen.
   */
  @Test
  public void checkIfEmptyNamePasses(){
    PostSignInController postSignInController = new PostSignInController();

    // Adding empty name to the request parameters.
    Mockito.when(request.queryParams(USERNAME_ATTR)).thenReturn("");

    ModelAndView testModelAndView = postSignInController.handle(request, response);

    Mockito.when(modelAndView.getViewName()).thenReturn(SIGNIN_VIEW);
    Mockito.when(vm.get(MESSAGE_ATTR)).thenReturn(MESSAGE_EMPTY_NAME);

    Map<String, Object> vmTest = (Map<String, Object>) testModelAndView.getModel();

    assertEquals(modelAndView.getViewName(), testModelAndView.getViewName());
    assertEquals(vm.get(MESSAGE_ATTR), vmTest.get(MESSAGE_ATTR));
  }

  /**
   * checkIfUserExists tests when you put in the username that already exists
   * in the list of online players, it displays the appropriate name.
   */
  @Test
  public void checkIfUserExists(){
    // existing username
    String testUserName = "niharika";
    // Adding the username to the pool of online players.
    OnlinePlayers.onlineList.add(new OnlinePlayers(testUserName));

    PostSignInController testPostSignInController = new PostSignInController();

    // Adding fake username entry in the request
    Mockito.when(request.queryParams(USERNAME_ATTR)).thenReturn(testUserName);

    ModelAndView testModelAndView = testPostSignInController.handle(request, response);
    Map<String, Object> testVm = (Map<String, Object>) testModelAndView.getModel();
    // Adding fake message to test message received.
    Mockito.when(vm.get(MESSAGE_ATTR)).thenReturn(MESSAGE_USER_EXISTS);

    assertEquals(vm.get(MESSAGE_ATTR), testVm.get(MESSAGE_ATTR));
  }


  /**
   * checkIfUniqueNameGetsAdded test checks that if the added username exists,
   * it takes you the homepage while signing you in.
   */
  @Test
  public void checkIfUniqueNameGetsAdded(){
    // A taken username
    String alreadyExists = "niharika";
    // A new username
    String newName = "dishant";
    // Add the taken username in the online players list
    OnlinePlayers.onlineList.add(new OnlinePlayers(alreadyExists));

    // request.session() is called in the PostSignInController handle function
    Mockito.when(request.session()).thenReturn(session);

    PostSignInController testPostSignInController = new PostSignInController();

    // Adding fake queryParam
    Mockito.when(request.queryParams(USERNAME_ATTR)).thenReturn(newName);
    // Adding fake message signed in to test actual message
    Mockito.when(vm.get(MESSAGE_ATTR)).thenReturn(MESSAGE_SIGNED_IN);
    // Adding fake view name to test the view name returned
    Mockito.when(modelAndView.getViewName()).thenReturn(HOME_VIEW);

    ModelAndView testModelAndView = testPostSignInController.handle(request, response);
    Map<String, Object> testVm = (Map<String, Object>) testModelAndView.getModel();

    assertEquals(vm.get(MESSAGE_ATTR), testVm.get(MESSAGE_ATTR));

    assertEquals(modelAndView.getViewName(), testModelAndView.getViewName());
  }
}