package com.webcheckers.ui.Login;

import static com.webcheckers.model.Strings.*;
import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * GET controller for Signing out.
 */
public class GetSignOutController implements TemplateViewRoute {
  private final GameCenter gameCenter;

  /**
   * This constructor initializes the gameCenter attribute.
   *
   * @param gameCenter the one and only gameCenter
   */
  public GetSignOutController(final GameCenter gameCenter) {
    this.gameCenter = gameCenter;

  }

  /**
   * This handle method remove the session and username of the player.
   * @param request generic request
   * @param response generic response
   * @return home_view
   */
  @Override
  public ModelAndView handle(Request request, Response response) {
    // Remove the player from the online list.
    // Remove the player from the session variable

    request.session().removeAttribute(USERNAME_ATTR);

    gameCenter.logout(request.session());
    // Show the home view.
    response.redirect(HOME_URL);
    halt();
    return null;
  }
}