package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.GAME_URL;
import static com.webcheckers.model.Strings.USER_SESSION_ATTRIBUTE;
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
        String user = ((OnlinePlayers)request.session().attribute(USER_SESSION_ATTRIBUTE)).getName();
        gameCenter.getGame(user).makeMove();
        response.redirect(GAME_URL);
        halt();
        return null;
    }
}
