package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.BOARD_ATTR;
import static com.webcheckers.model.Strings.CURRENT_PLAYER_ATTR;
import static com.webcheckers.model.Strings.GAME_TITLE;
import static com.webcheckers.model.Strings.GAME_VIEW;
import static com.webcheckers.model.Strings.HOME_VIEW;
import static com.webcheckers.model.Strings.IS_MY_TURN_ATTR;
import static com.webcheckers.model.Strings.MESSAGE_ATTR;
import static com.webcheckers.model.Strings.MESSAGE_PLAYER_PLAYING;
import static com.webcheckers.model.Strings.MESSAGE_TYPE_ATTR;
import static com.webcheckers.model.Strings.MESSAGE_TYPE_ERROR;
import static com.webcheckers.model.Strings.ONLINE_PLAYERS_ATTR;
import static com.webcheckers.model.Strings.OPPONENT_ATTR;
import static com.webcheckers.model.Strings.OPPONENT_COLOR_ATTR;
import static com.webcheckers.model.Strings.OPPONENT_NAME_ATTR;
import static com.webcheckers.model.Strings.PLAYER_COLOR_ATTR;
import static com.webcheckers.model.Strings.PLAYER_NAME_ATTR;
import static com.webcheckers.model.Strings.TITLE_ATTR;
import static com.webcheckers.model.Strings.USERNAME_ATTR;
import static com.webcheckers.model.Strings.WELCOME_TITLE;
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
    String player = ((OnlinePlayers)request.session().attribute("user")).getName();
    Map<String, Object> vm = new HashMap<>();

    // get indexes of player and opponent from the list.

    // if the opponent is free
    if (gameCenter.userIsFree(opponent)) {
      gameCenter.addGame(player, opponent);
      // Redirect to getGameController
      response.redirect("/game");
      halt();
      return null;
    } else { // if the opponent got busy
      response.redirect("/");
      halt();
      return null;
    }
  }
}
