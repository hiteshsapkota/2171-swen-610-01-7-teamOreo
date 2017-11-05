package com.webcheckers.ui.Game;

import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.model.WebCheckerGame;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;

public class PostSubmitTurnController implements Route {
    private final GameCenter gameCenter;

    public PostSubmitTurnController(final GameCenter gameCenter) {
        this.gameCenter = gameCenter;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        String user = ((OnlinePlayers)request.session().attribute("user")).getName();
        gameCenter.getGame(user).makeMove();
        response.redirect("/game");
        halt();
        return null;
    }
}
