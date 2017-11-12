package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.*;
import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * StartPlayController gets the game view which shows the game view with the initial board layout.
 */
public class StartPlayController implements TemplateViewRoute {

  private final GameCenter gameCenter;

  /**
   * Initializes the gameCenter attribute.
   * @param gameCenter the one and only gamecenter.
   */
  public StartPlayController(final GameCenter gameCenter){
    this.gameCenter = gameCenter;
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    // get the name of the opponent and the player.
    String opponent = request.queryParams(OPPONENT_ATTR);
    String player = ((OnlinePlayers)request.session().attribute(USER_SESSION_ATTRIBUTE)).getName();

    // get indexes of player and opponent from the list.

    // if the opponent is free
    if (gameCenter.userIsFree(opponent)) {
      gameCenter.addGame(player, opponent);
      // Redirect to getGameController
      response.redirect(GAME_URL);
      halt();
      return null;
    } else { // if the opponent got busy
      response.redirect(HOME_URL);
      halt();
      return null;
    }
  }
}
