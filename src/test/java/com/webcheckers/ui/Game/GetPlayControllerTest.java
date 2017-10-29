//package com.webcheckers.ui.Game;
//
//import com.webcheckers.model.OnlinePlayers;
//import com.webcheckers.ui.Login.PostSignInController;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//import spark.ModelAndView;
//import spark.Request;
//import spark.Session;
//import spark.Response;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static com.webcheckers.model.Strings.*;
//import static org.junit.Assert.*;
//
//public class GetPlayControllerTest {
//    private Request request;
//    private Response response;
//    private ModelAndView modelAndView;
//    private Map<String,Object> vm;
//    private Session session;
//    @Before
//    public void setup()
//    {
//
//        request= Mockito.mock(Request.class);
//        response=Mockito.mock(Response.class);
//        modelAndView=Mockito.mock(ModelAndView.class);
//        vm=Mockito.mock(HashMap.class);
//        session=Mockito.mock(Session.class);
//
//    }
//    @Test
//    public void checkIfOpponentIsFree()
//    {
//        GetPlayController getPlayController=new GetPlayController();
//        String opponent = "player1";
//        String current = "player2";
//        OnlinePlayers.onlineList.add(new OnlinePlayers(opponent));
//        OnlinePlayers.onlineList.add(new OnlinePlayers(current));
//        OnlinePlayers.onlineList.get(OnlinePlayers.onlineList.indexOf(new OnlinePlayers(opponent))).setFree(false);
//
//
//        Mockito.when(request.queryParams(OPPONENT_ATTR)).thenReturn(opponent);
//        Mockito.when(request.session()).thenReturn(session);
//        Mockito.when(session.attribute(USERNAME_ATTR)).thenReturn(current);
//
//        ModelAndView testModelAndView=getPlayController.handle(request,response);
//        Map<String,Object> vmTest=(Map<String,Object>)testModelAndView.getModel();
//        assertEquals(MESSAGE_PLAYER_PLAYING,vmTest.get(MESSAGE_ATTR));
//    }
//
//
//}