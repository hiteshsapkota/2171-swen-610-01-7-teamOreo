//package com.webcheckers.ui.Login;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import static com.webcheckers.model.Strings.HOME_VIEW;
//import static org.junit.Assert.*;
//
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import spark.ModelAndView;
//import spark.Request;
//import spark.Response;
//import spark.Session;
//
//import java.util.Map;
//
//import static com.webcheckers.model.Strings.SIGNIN_VIEW;
//import static com.webcheckers.model.Strings.USERNAME_ATTR;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//
//public class GetSignInControllerTest {
//    private Request request;
//    private Response response;
//    private ModelAndView modelAndView;
//    private Map vm ;
//    private Session session;
//
///**
// * sets up the mock classes required by the GetSignInController.
// */
//
//    @Before
//    public void setUp() throws Exception {
//    request = Mockito.mock(Request.class);
//    response = Mockito.mock(Response.class);
//    modelAndView = Mockito.mock(ModelAndView.class);
//    vm = Mockito.mock(Map.class);
//    session = Mockito.mock(Session.class);
//    }
//
//    /**
//     * checkIfEmptyNamePasses tests when a null is sent as a username,
//     * it should show appropriate message and take you to login screen.
//     */
//
//    @Test
//
//    public void checkIfUserIsNotSignedIn (){
//
//        GetSignInController getSignInController = new GetSignInController();
//
//        // Adding empty name to the request parameters.
//        Mockito.when(request.session()).thenReturn(session);
//        Mockito.when(session.attribute(USERNAME_ATTR)).thenReturn(null);
//
//        ModelAndView testModelAndView = getSignInController.handle(request, response);
//        assertEquals(SIGNIN_VIEW, testModelAndView.getViewName());
//    }
//
//    @Test
//
//    public void checkIfUserIsSignedIn(){
//
//        GetSignInController getSignInController = new GetSignInController();
//
//        // Adding empty name to the request parameters.
//        Mockito.when(request.session()).thenReturn(session);
//        Mockito.when(session.attribute(USERNAME_ATTR)).thenReturn("Licelot");
//
//        ModelAndView testModelAndView = getSignInController.handle(request, response);
//        assertEquals(HOME_VIEW, testModelAndView.getViewName());
//
//    }
//}
//
//
