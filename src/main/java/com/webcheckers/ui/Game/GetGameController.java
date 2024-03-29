package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.*;
import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import java.util.HashMap;
import java.util.Map;
import spark.HaltException;
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
   * @param gameCenter the one and only gamecenter.
   */
  public GetGameController(final GameCenter gameCenter){
    this.gameCenter = gameCenter;
  }

  /**
   * This handle method determines if the name can be created to return the game page otherwise redirects to home_page
   * @param request generic request.
   * @param response generic response.
   * @return game_view
   */
  @Override
  public ModelAndView handle(Request request, Response response) {
    final Session session = request.session();

    try{
      String user = ((OnlinePlayers) session.attribute("user")).getName();
      if(gameCenter.getGame(user) == null){
        response.redirect(HOME_URL);
        halt();
        return null;
      }
      else{
        Map<String, Object> vm = new HashMap<>();
        vm.put(TITLE_ATTR, GAME_TITLE);
        vm.put(PLAYER_NAME_ATTR, gameCenter.getGame(user).getPlayer(user));
        vm.put(OPPONENT_NAME_ATTR, gameCenter.getGame(user).getOpponent(user));
        vm.put(PLAYER_COLOR_ATTR, gameCenter.getGame(user).getPlayerColor(user));
        vm.put(OPPONENT_COLOR_ATTR, gameCenter.getGame(user).getOpponentColor(user));
        vm.put(IS_MY_TURN_ATTR, gameCenter.getGame(user).isMyTurn(user));
        vm.put(CURRENT_PLAYER_ATTR, true);
        vm.put(BOARD_ATTR, gameCenter.getGame(user).getBoard());
        gameCenter.getGame(user).checkAllPieceForMovements();
        if(gameCenter.getGame(user).isGameEnded()){
          if(gameCenter.getGame(user).didIWin(user)){
            response.redirect(GAME_WON);
            halt();
            return null;
          }
          else{
            response.redirect(GAME_LOST);
            halt();
            return null;
          }
        }
        return new ModelAndView(vm, GAME_VIEW);
      }
    }
    catch (Exception e){
      if (e.getClass() != HaltException.class){
        e.printStackTrace();
      }
      response.redirect(HOME_URL);
      halt();
      return null;
    }
  }
}
