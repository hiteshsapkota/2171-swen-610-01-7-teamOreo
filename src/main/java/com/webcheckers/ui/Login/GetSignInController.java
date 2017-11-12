package com.webcheckers.ui.Login;


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
 * Get controller for the sign in page.
 */
public class GetSignInController implements TemplateViewRoute {

  /**
   * This is a constructor initializes the gameCenter attribute.
   * @param gameCenter the one and only gameCenter.
   */
  public GetSignInController(final GameCenter gameCenter){
    GameCenter gameCenter1 = gameCenter;
  }

  /**
   * This handle method is overridden  to create a new sign in and show login info.
   * @param request generic request
   * @param response generic response
   * @return home_view
   */
  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    OnlinePlayers username = request.session().attribute(USER_SESSION_ATTRIBUTE);
    // if there is no session
    if (username == null) {
      //Show login information
      vm.put(TITLE_ATTR, SIGN_IN_TITLE);
      return new ModelAndView(vm, SIGNIN_VIEW);

    } else {
      //Redirects to home
      response.redirect(HOME_URL);
      halt();
      return null;
    }

  }
}
