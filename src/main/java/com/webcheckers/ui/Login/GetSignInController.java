package com.webcheckers.ui.Login;


import static com.webcheckers.model.Strings.CURRENT_PLAYER_ATTR;
import static com.webcheckers.model.Strings.HOME_VIEW;
import static com.webcheckers.model.Strings.ONLINE_PLAYERS_ATTR;
import static com.webcheckers.model.Strings.PLAYER_NAME_ATTR;
import static com.webcheckers.model.Strings.SIGNIN_VIEW;
import static com.webcheckers.model.Strings.SIGN_IN_TITLE;
import static com.webcheckers.model.Strings.TITLE_ATTR;
import static com.webcheckers.model.Strings.USERNAME_ATTR;
import static com.webcheckers.model.Strings.WELCOME_TITLE;

import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.ui.JsonUtils;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * Get controller for the sign in page.
 */
public class GetSignInController implements TemplateViewRoute {


  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    String username = request.session().attribute(USERNAME_ATTR);
    // if there is no session
    if (username == null) {
      //Show login information
      vm.put(TITLE_ATTR, SIGN_IN_TITLE);
      return new ModelAndView(vm, SIGNIN_VIEW);

    } else {
      //Redirect to home
      vm.put(TITLE_ATTR, WELCOME_TITLE);
      vm.put(CURRENT_PLAYER_ATTR, true);
      vm.put(PLAYER_NAME_ATTR, username);
      vm.put(ONLINE_PLAYERS_ATTR, JsonUtils.toJson(OnlinePlayers.onlineList));
      return new ModelAndView(vm, HOME_VIEW);

    }

  }
}
