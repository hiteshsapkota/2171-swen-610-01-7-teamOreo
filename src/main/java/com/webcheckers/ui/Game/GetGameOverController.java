package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.GAME_LOST_MESSAGE;
import static com.webcheckers.model.Strings.GAME_OVER_VIEW;
import static com.webcheckers.model.Strings.GAME_WON_MESSAGE;
import static com.webcheckers.model.Strings.MESSAGE_ATTR;
import static com.webcheckers.model.Strings.YOU_WON_ATTR;

import com.webcheckers.appl.GameCenter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class GetGameOverController implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    String didIWin = (request.queryParams(YOU_WON_ATTR));
    if(Objects.equals(didIWin, "true")){
      vm.put(MESSAGE_ATTR, GAME_WON_MESSAGE);
    }
    else{
      vm.put(MESSAGE_ATTR, GAME_LOST_MESSAGE);
    }
    return new ModelAndView(vm, GAME_OVER_VIEW);
  }
}
