package com.webcheckers.ui.Game;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.ui.Login.PostSignInController;
import org.junit.Test;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;

import static com.webcheckers.model.Strings.*;
import static com.webcheckers.model.Strings.MESSAGE_ATTR;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetGameOverControllerTest {
    @Test
    public void handle1() throws Exception {
        String gamestatus="Congratulations! You won.";
        GameCenter gameCenter = mock(GameCenter.class);
        GetGameOverController getGameOverController = new GetGameOverController(gameCenter);
        Request request = mock(Request.class);
        Response response = mock(Response.class);

        when(request.queryParams("youWon")).thenReturn("true");

        ModelAndView modelAndView = getGameOverController.handle(request, response);

        assertEquals("game_over.ftl", modelAndView.getViewName());

        HashMap<String, Object> vm = (HashMap) modelAndView.getModel();

        assertEquals(gamestatus, vm.get("message"));
    }

    @Test
    public void handle2() throws Exception{
        GameCenter gameCenter = mock(GameCenter.class);
        GetGameOverController getGameOverController = new GetGameOverController(gameCenter);
        Request request = mock(Request.class);
        Response response = mock(Response.class);
        String gamestatus = "You lost, Better luck next time.";

        when(request.queryParams("youwon")).thenReturn("false");


        ModelAndView modelAndView = getGameOverController.handle(request, response);

        assertEquals("game_over.ftl", modelAndView.getViewName());

        HashMap<String, Object> vm = (HashMap) modelAndView.getModel();

        assertEquals(gamestatus, vm.get(MESSAGE_ATTR));
    }
}
