package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.GAME_URL;
import static com.webcheckers.model.Strings.USER_SESSION_ATTRIBUTE;
import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * It captures the move made by the player when clicked on 'Submit Turn'
 */
public class PostSubmitTurnController implements Route {
    private final GameCenter gameCenter;

    /**
     * Initializes the gameCenter attribute.
     * @param gameCenter the one and only gamecenter.
     */
    public PostSubmitTurnController(final GameCenter gameCenter) {
        this.gameCenter = gameCenter;
    }

    /**
     * This method handles the control to the other player in case of a valid move
     * @param request generic request.
     * @param response generic response.
     * @return null always.
     * @throws Exception if any.
     */
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String user = ((OnlinePlayers)request.session().attribute(USER_SESSION_ATTRIBUTE)).getName();
        gameCenter.getGame(user).makeMove();
        response.redirect(GAME_URL);
        halt();
        return null;
    }
}
