package com.webcheckers.ui;

import static com.webcheckers.model.Strings.CURRENT_PLAYER_ATTR;
import static com.webcheckers.model.Strings.HOME_VIEW;
import static com.webcheckers.model.Strings.ONLINE_PLAYERS_ATTR;
import static com.webcheckers.model.Strings.PLAYER_NAME_ATTR;
import static com.webcheckers.model.Strings.TITLE_ATTR;
import static com.webcheckers.model.Strings.USERNAME_ATTR;
import static com.webcheckers.model.Strings.WELCOME_TITLE;

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
public class HomeController implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put(TITLE_ATTR, WELCOME_TITLE);
    String currentUsername = request.session().attribute(USERNAME_ATTR);
    // If there is no username in session
    if (currentUsername == null) {
      // Show page with login link
      vm.put(CURRENT_PLAYER_ATTR, false);
    } else { // If a user is logged in
      // Show homepage with list of online players.
      vm.put(CURRENT_PLAYER_ATTR, true);
      vm.put(PLAYER_NAME_ATTR, currentUsername);
      vm.put(ONLINE_PLAYERS_ATTR, JsonUtils.toJson(OnlinePlayers.onlineList));
    }
    return new ModelAndView(vm, HOME_VIEW);
  }

}