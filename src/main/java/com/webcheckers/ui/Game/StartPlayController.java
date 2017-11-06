package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.*;
import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Board.Board;
import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.model.Board.Piece;
import com.webcheckers.model.Board.Piece.colorEnum;
import com.webcheckers.model.Board.Piece.typeEnum;
import com.webcheckers.model.Board.Row;
import com.webcheckers.model.Board.Space;
import com.webcheckers.model.WebCheckerGame;
import com.webcheckers.ui.JsonUtils;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * StartPlayController gets the game view which shows the game view with the initial board layout.
 */
public class StartPlayController implements TemplateViewRoute {

  private final GameCenter gameCenter;

  public StartPlayController(final GameCenter gameCenter){
    this.gameCenter = gameCenter;
  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    // get the name of the opponent and the player.
    String opponent = request.queryParams(OPPONENT_ATTR);
    String player = ((OnlinePlayers)request.session().attribute(USER_SESSION_ATTRIBUTE)).getName();
    Map<String, Object> vm = new HashMap<>();

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
