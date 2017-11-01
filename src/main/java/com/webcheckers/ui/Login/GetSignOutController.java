package com.webcheckers.ui.Login;

import static com.webcheckers.model.Strings.CURRENT_PLAYER_ATTR;
import static com.webcheckers.model.Strings.HOME_VIEW;
import static com.webcheckers.model.Strings.TITLE_ATTR;
import static com.webcheckers.model.Strings.USERNAME_ATTR;
import static com.webcheckers.model.Strings.WELCOME_TITLE;
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
 * GET controller for Signing out.
 */
public class GetSignOutController implements TemplateViewRoute {
  private final GameCenter gameCenter;

  public GetSignOutController(final GameCenter gameCenter) {
    this.gameCenter = gameCenter;

  }

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    // Remove the player from the online list.
    // Remove the player from the session variable

    request.session().removeAttribute(USERNAME_ATTR);

    gameCenter.logout(request.session());
    // Show the home view.
    response.redirect("/");
    halt();
    return null;
//    vm.put(TITLE_ATTR, WELCOME_TITLE);
//    vm.put(CURRENT_PLAYER_ATTR, false);
//    return new ModelAndView(vm, HOME_VIEW);
  }
}