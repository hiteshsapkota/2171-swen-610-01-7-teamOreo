package com.webcheckers.ui.Game;

import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class PostEndGameController implements TemplateViewRoute {
  private final GameCenter gameCenter;

  public PostEndGameController(final GameCenter gameCenter) {
    this.gameCenter = gameCenter;
  }


  @Override
  public ModelAndView handle(Request request, Response response) {
    String user = ((OnlinePlayers)request.session().attribute("user")).getName();
    if(gameCenter.getGame(user) != null){
      gameCenter.removeGame(user);
    }
    response.redirect("/");
    halt();
    return null;
  }
}
