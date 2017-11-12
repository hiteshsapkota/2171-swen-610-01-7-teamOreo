package com.webcheckers.ui.Game;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class GetGameOverController implements TemplateViewRoute {
  private final GameCenter gameCenter;

  public GetGameOverController(final GameCenter gameCenter){
    this.gameCenter = gameCenter;
  }


  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    String didIWin = (request.queryParams("youWon"));
    if(Objects.equals(didIWin, "true")){
      vm.put("message", "Congratulations! You won.");
    }
    else{
      vm.put("message", "You lost, Better luck next time.");
    }
    return new ModelAndView(vm, "game_over.ftl");
  }
}