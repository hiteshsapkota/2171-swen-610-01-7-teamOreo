package com.webcheckers.ui.Game;

import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;

public class PostResignGameController implements TemplateViewRoute {

  private final GameCenter gameCenter;

  public PostResignGameController( final GameCenter gameCenter) {
    this.gameCenter = gameCenter;
  }


  @Override
  public ModelAndView handle(Request request, Response response) {
    String user = ((OnlinePlayers) request.session().attribute("user")).getName();
    gameCenter.removeGame(user);
    response.redirect("/");
    halt();
    return null;
  }
}
