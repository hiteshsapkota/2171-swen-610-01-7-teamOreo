package com.webcheckers.ui.Game;

import com.google.gson.JsonObject;
import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.ui.JsonUtils;
import spark.Request;
import spark.Response;
import spark.Route;

public class PostValidateMoveController implements Route {
  private final GameCenter gameCenter;

  public PostValidateMoveController(final GameCenter gameCenter){
    this.gameCenter = gameCenter;
  }

  @Override
  public Object handle(Request request, Response response) throws Exception {
    // Get the start and end positions
    JsonObject jsonObject = JsonUtils.fromJson(request.body(), JsonObject.class);
    JsonObject start = jsonObject.getAsJsonObject("start");
    JsonObject end = jsonObject.getAsJsonObject("end");
    int startRow = start.get("row").getAsInt();
    int startCell = start.get("cell").getAsInt();
    int endRow = end.get("row").getAsInt();
    int endCell = end.get("cell").getAsInt();

    // Get the current username
    String user = ((OnlinePlayers) request.session().attribute("user")).getName();

    return gameCenter.getGame(user).isValidTurn(startRow, startCell, endRow, endCell, user);
  }
}
