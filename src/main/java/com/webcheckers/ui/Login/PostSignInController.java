package com.webcheckers.ui.Login;

import static com.webcheckers.model.Strings.CURRENT_PLAYER_ATTR;
import static com.webcheckers.model.Strings.HOME_VIEW;
import static com.webcheckers.model.Strings.MESSAGE_ATTR;
import static com.webcheckers.model.Strings.MESSAGE_EMPTY_NAME;
import static com.webcheckers.model.Strings.MESSAGE_SIGNED_IN;
import static com.webcheckers.model.Strings.MESSAGE_TYPE_ATTR;
import static com.webcheckers.model.Strings.MESSAGE_TYPE_ERROR;
import static com.webcheckers.model.Strings.MESSAGE_TYPE_INFO;
import static com.webcheckers.model.Strings.MESSAGE_USER_EXISTS;
import static com.webcheckers.model.Strings.ONLINE_PLAYERS_ATTR;
import static com.webcheckers.model.Strings.PLAYER_NAME_ATTR;
import static com.webcheckers.model.Strings.SIGNIN_VIEW;
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
 * Controller for POST/signin
 */
public class PostSignInController implements TemplateViewRoute {
private final GameCenter gameCenter;
public PostSignInController(final GameCenter gameCenter)
{
  this.gameCenter=gameCenter;
}
  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    String username=request.queryParams(USERNAME_ATTR).toLowerCase();

    // if the name entered is empty
    if (username == "") {
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
      response.redirect("/");
      halt();
      return null;

    }
  }
}
