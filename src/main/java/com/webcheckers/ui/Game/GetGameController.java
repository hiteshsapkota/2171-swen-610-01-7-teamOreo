package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.*;
import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.model.WebCheckerGame;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;
import spark.TemplateViewRoute;

/**
 * The controller for the game
 */
public class GetGameController implements TemplateViewRoute {

  private final GameCenter gameCenter;

  /**
   * Initializes the gameCenter attribute.
   * @param gameCenter
   */
  public GetGameController(final GameCenter gameCenter){
    this.gameCenter = gameCenter;
  }

  /**
   * This handle method determines if the name can be created to return the game page otherwise redirects to home_page
   * @param request
   * @param response
   * @return game_view
   */
  @Override
  public ModelAndView handle(Request request, Response response) {
    final Session session = request.session();

    try{
      String user = ((OnlinePlayers) session.attribute("user")).getName();
      WebCheckerGame game = gameCenter.getGame(user);
      if(game == null){
        response.redirect(HOME_URL);
        halt();
        return null;
      }
      else{
        Map<String, Object> vm = new HashMap<>();
        vm.put(TITLE_ATTR, GAME_TITLE);
        vm.put(PLAYER_NAME_ATTR, game.getPlayer(user));
        vm.put(OPPONENT_NAME_ATTR, game.getOpponent(user));
        vm.put(PLAYER_COLOR_ATTR, game.getPlayerColor(user));
        vm.put(OPPONENT_COLOR_ATTR, game.getOpponentColor(user));
        vm.put(IS_MY_TURN_ATTR, game.isMyTurn(user));
        vm.put(CURRENT_PLAYER_ATTR, true);
        vm.put(BOARD_ATTR, game.getBoard());

        return new ModelAndView(vm, GAME_VIEW);
      }
    }
    catch (Exception e){
      response.redirect(HOME_URL);
      halt();
      return null;
    }

  }
}
