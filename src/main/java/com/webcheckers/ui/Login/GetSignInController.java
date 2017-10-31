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
import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
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
  private final GameCenter gameCenter;

  public GetSignInController(final GameCenter gameCenter){
    this.gameCenter = gameCenter;
  }


  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    OnlinePlayers username = request.session().attribute("user");
    // if there is no session
    if (username == null) {
      //Show login information
      vm.put(TITLE_ATTR, SIGN_IN_TITLE);
      return new ModelAndView(vm, SIGNIN_VIEW);

    } else {
      //Redirect to home
      response.redirect("/");
      halt();
      return null;
    }

  }
}
