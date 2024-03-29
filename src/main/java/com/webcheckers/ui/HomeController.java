package com.webcheckers.ui;

import static com.webcheckers.model.Strings.*;
import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * The Web Controller for the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
class HomeController implements TemplateViewRoute {

  private final GameCenter gameCenter;

  /**
   * This is a constructor initializes the gameCenter attribute.
   * @param gameCenter new game
   */

  public HomeController(GameCenter gameCenter){
    this.gameCenter = gameCenter;
  }

  /**
   *
   *This handle method is overridden to create a new session and get the home page.
   * @param request generic request
   * @param response generic response
   * @return home_view
   */
  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put(TITLE_ATTR, WELCOME_TITLE);
    OnlinePlayers currentPlayer = request.session().attribute(USER_SESSION_ATTRIBUTE);

    // If there is no username in session
    if (currentPlayer == null) {
      // Show page with login link
      vm.put(CURRENT_PLAYER_ATTR, false);
    } else { // If a user is logged in
      if(!gameCenter.userIsFree(currentPlayer.getName())){
        //TODO send the user back to the game page.
        response.redirect(GAME_URL);
        halt();
        return null;
      }
      else{
        // Show homepage with list of online players.
        vm.put(CURRENT_PLAYER_ATTR, true);
        vm.put(PLAYER_NAME_ATTR, currentPlayer.getName());
        vm.put(ONLINE_PLAYERS_ATTR, JsonUtils.toJson(gameCenter.getAllAvailablePlayers()));
      }
    }
    return new ModelAndView(vm, HOME_VIEW);
  }
}