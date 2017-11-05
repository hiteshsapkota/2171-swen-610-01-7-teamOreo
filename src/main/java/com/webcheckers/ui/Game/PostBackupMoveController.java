package com.webcheckers.ui.Game;

import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Message;
import com.webcheckers.model.OnlinePlayers;
import spark.Request;
import spark.Response;
import spark.Route;

public class PostBackUpMoveController implements Route {

    private final GameCenter gameCenter;

    public PostBackUpMoveController(final GameCenter gameCenter) {
        this.gameCenter = gameCenter;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        System.out.println(request.body());
        String user = ((OnlinePlayers)request.session().attribute("user")).getName();
        gameCenter.getGame(user).popMove();
        return new Message("Backed Up the Move.", "info");
    }
}