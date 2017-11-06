        package com.webcheckers.ui.Game;

        import com.webcheckers.appl.GameCenter;
        import com.webcheckers.model.OnlinePlayers;
        import com.webcheckers.model.WebCheckerGame;
        import spark.Request;
        import spark.Response;
        import spark.Route;
        import spark.TemplateViewRoute;

        import static com.webcheckers.model.Strings.USER_SESSION_ATTRIBUTE;

        public class PostCheckTurnController implements Route {
    private final GameCenter gameCenter;

    public PostCheckTurnController(final GameCenter gameCenter) {
        this.gameCenter = gameCenter;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        String user = ((OnlinePlayers)request.session().attribute(USER_SESSION_ATTRIBUTE)).getName();
        return gameCenter.getGame(user).isMyTurn(user);
    }
}
