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

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    OnlinePlayers name = new OnlinePlayers(request.queryParams(USERNAME_ATTR).toLowerCase());
    // if the name entered is empty
    if (name.getName().equals("")) {
      // show error and redirect to sign in page.
      vm.put(TITLE_ATTR, WELCOME_TITLE);
      vm.put(MESSAGE_ATTR, MESSAGE_EMPTY_NAME);
      vm.put(MESSAGE_TYPE_ATTR, MESSAGE_TYPE_ERROR);
      return new ModelAndView(vm, SIGNIN_VIEW);
    } else if (OnlinePlayers.onlineList.contains(name)) { // name already exists
      // show error and redirect to sign in page.
      vm.put(TITLE_ATTR, WELCOME_TITLE);
      vm.put(MESSAGE_ATTR, MESSAGE_USER_EXISTS);
      vm.put(MESSAGE_TYPE_ATTR, MESSAGE_TYPE_ERROR);
      return new ModelAndView(vm, SIGNIN_VIEW);
    } else {
      // add the name to the session
      request.session().attribute(USERNAME_ATTR, name.getName());
      // add the Online player to the list
      OnlinePlayers.onlineList.add(name);
      // show the homepage with the list of online players.
      vm.put(TITLE_ATTR, WELCOME_TITLE);
      vm.put(CURRENT_PLAYER_ATTR, true);
      vm.put(ONLINE_PLAYERS_ATTR, JsonUtils.toJson(OnlinePlayers.onlineList));
      vm.put(PLAYER_NAME_ATTR, request.session().attribute(USERNAME_ATTR));
      vm.put(MESSAGE_TYPE_ATTR, MESSAGE_TYPE_INFO);
      vm.put(MESSAGE_ATTR, MESSAGE_SIGNED_IN);
      return new ModelAndView(vm, HOME_VIEW);
    }
  }
}
