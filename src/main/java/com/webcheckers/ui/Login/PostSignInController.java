package com.webcheckers.ui.Login;

import static com.webcheckers.model.Strings.*;
import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * Controller for POST/signin
 */
public class PostSignInController implements TemplateViewRoute {
private final GameCenter gameCenter;

  /**
   * Initializes the gameCenter attribute.
   * @param gameCenter the one and only gameCenter
   */

public PostSignInController(final GameCenter gameCenter)
{
  this.gameCenter=gameCenter;
}

  /**
   * Verify that the name entered is not empty and if it is empty or existing name it redirects to sign in page otherwise to home page.
   * @param request generic request
   * @param response generic response
   * @return home_view
   */
  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    String username=request.queryParams(USERNAME_ATTR).toLowerCase();

    // if the name entered is empty
    if (Objects.equals(username, "")) {
      // show error and redirect to sign in page.
      vm.put(TITLE_ATTR, WELCOME_TITLE);
      vm.put(MESSAGE_ATTR, MESSAGE_EMPTY_NAME);
      vm.put(MESSAGE_TYPE_ATTR, MESSAGE_TYPE_ERROR);
      return new ModelAndView(vm, SIGNIN_VIEW);
    } else if (gameCenter.userAlreadyExists(username)) { // name already exists
      // show error and redirect to sign in page.
      vm.put(TITLE_ATTR, WELCOME_TITLE);
      vm.put(MESSAGE_ATTR, MESSAGE_USER_EXISTS);
      vm.put(MESSAGE_TYPE_ATTR, MESSAGE_TYPE_ERROR);
      return new ModelAndView(vm, SIGNIN_VIEW);
    } else {
      // add the name to the session
      gameCenter.login(request.session(),username);
      response.redirect(HOME_URL);
      halt();
      return null;

    }
  }
}
