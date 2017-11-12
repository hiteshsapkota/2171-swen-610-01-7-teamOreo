        package com.webcheckers.ui.Game;

        import com.webcheckers.appl.GameCenter;
        import com.webcheckers.model.OnlinePlayers;
        import spark.Request;
        import spark.Response;
        import spark.Route;

        import static com.webcheckers.model.Strings.USER_SESSION_ATTRIBUTE;
/*
Checks which player has the next turn
 */
        public class PostCheckTurnController implements Route {
    private final GameCenter gameCenter;

    /**
     * Initializes the gameCenter attribute.
     * @param gameCenter the one and only gameCenter.
     */
    public PostCheckTurnController(final GameCenter gameCenter) {
        this.gameCenter = gameCenter;
    }

    /**
     * This handle method returns the name of the user whose turn it is to play
     * @param request generic request.
     * @param response generic response.
     * @return returns a boolean if it is the turn or not.
     * @throws Exception if there are any.
     */
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String user = ((OnlinePlayers)request.session().attribute(USER_SESSION_ATTRIBUTE)).getName();
        return gameCenter.getGame(user).isMyTurn(user);
    }
}
