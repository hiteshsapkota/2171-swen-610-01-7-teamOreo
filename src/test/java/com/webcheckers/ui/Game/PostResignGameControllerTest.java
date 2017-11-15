package com.webcheckers.ui.Game;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import org.junit.Test;
import spark.HaltException;
import spark.Request;
import spark.Response;
import spark.Session;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostResignGameControllerTest {
    @Test
    public void handle1(){
        try{
            Request request = mock(Request.class);
            Response response = mock(Response.class);
            Session session = mock(Session.class);
            GameCenter gameCenter = mock(GameCenter.class);
            OnlinePlayers user = mock(OnlinePlayers.class);
            when(request.session()).thenReturn(session);
            when(session.attribute("user")).thenReturn(user);
            when(user.getName()).thenReturn("user");
            PostResignGameController postResignGameController = new PostResignGameController(gameCenter);

            assertNull(postResignGameController.handle(request, response));
        }
        catch (HaltException e){
            System.out.println("Halt Exception");
        }

    }

}
