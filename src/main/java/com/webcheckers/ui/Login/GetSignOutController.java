package com.webcheckers.ui.Login;

import static com.webcheckers.model.Strings.CURRENT_PLAYER_ATTR;
import static com.webcheckers.model.Strings.HOME_VIEW;
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
 * GET controller for Signing out.
 */
public class GetSignOutController implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    // Remove the player from the online list.
    OnlinePlayers.onlineList
        .remove(new OnlinePlayers(request.session().attribute("username"), true));
    // Remove the player from the session variable
    request.session().removeAttribute(USERNAME_ATTR);
    // Show the home view.
    vm.put(TITLE_ATTR, WELCOME_TITLE);
    vm.put(CURRENT_PLAYER_ATTR, false);
    return new ModelAndView(vm, HOME_VIEW);
  }
}
