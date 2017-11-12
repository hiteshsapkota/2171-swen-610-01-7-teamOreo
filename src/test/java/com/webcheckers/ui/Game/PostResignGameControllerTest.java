package com.webcheckers.ui.Game;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.ui.Login.GetSignOutController;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Session;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostResignGameControllerTest {
    @Test
    public void handle1(){
        Request request = mock(Request.class);
        Response response = mock(Response.class);
        Session session = mock(Session.class);
        GameCenter gameCenter = mock(GameCenter.class);

        when(request.session()).thenReturn(session);

        PostResignGameController postResignGameController = new PostResignGameController(gameCenter);

        assertNull(postResignGameController.handle(request, response));
    }

}
