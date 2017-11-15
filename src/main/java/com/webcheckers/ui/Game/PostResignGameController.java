package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.HOME_URL;
import static com.webcheckers.model.Strings.USER_SESSION_ATTRIBUTE;
import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class PostResignGameController implements TemplateViewRoute {

  private final GameCenter gameCenter;

  public PostResignGameController( final GameCenter gameCenter) {
    this.gameCenter = gameCenter;
  }


  @Override
  public ModelAndView handle(Request request, Response response) {
    String user = ((OnlinePlayers) request.session().attribute(USER_SESSION_ATTRIBUTE)).getName();
    gameCenter.removeGame(user);
    response.redirect(HOME_URL);
    halt();
    return null;
  }
}
