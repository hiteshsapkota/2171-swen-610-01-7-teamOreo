package com.webcheckers.ui.Login;

import com.webcheckers.model.OnlinePlayers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GetSignOutControllerTest {

    private ModelAndView modelAndView;
    private Request request;
    private Response response;
    private Map<String, Object> vm;
    private Session session;

/**
 * setup sets up the mock classes required by the GetSignOutController.
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
 * checkIfNameRemoved tests if name is removed when signed out
 */
@Test
public void checkIfNameRemoved(){
    GetSignOutController getSignOutController = new GetSignOutController();
    String mockName = "sayantika";
    OnlinePlayers.onlineList.add(new OnlinePlayers(mockName));
    Mockito.when(request.session()).thenReturn(session);
    Mockito.when(session.attribute("username")).thenReturn(mockName);

    getSignOutController.handle(request, response);


    assertFalse(OnlinePlayers.onlineList.contains(new OnlinePlayers(mockName)));
}

}