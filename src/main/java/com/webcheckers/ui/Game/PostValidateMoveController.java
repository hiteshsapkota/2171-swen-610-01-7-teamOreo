package com.webcheckers.ui.Game;

import com.google.gson.JsonObject;
import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.ui.JsonUtils;
import spark.Request;
import spark.Response;
import spark.Route;

import static com.webcheckers.model.Strings.*;

public class PostValidateMoveController implements Route {
  private final GameCenter gameCenter;

  public PostValidateMoveController(final GameCenter gameCenter){
    this.gameCenter = gameCenter;
  }

  @Override
  public Object handle(Request request, Response response) throws Exception {
    // Get the start and end positions
    JsonObject jsonObject = JsonUtils.fromJson(request.body(), JsonObject.class);
    JsonObject start = jsonObject.getAsJsonObject(START);
    JsonObject end = jsonObject.getAsJsonObject(END);
    int startRow = start.get(ROW).getAsInt();
    int startCell = start.get(CELL).getAsInt();
    int endRow = end.get(ROW).getAsInt();
    int endCell = end.get(CELL).getAsInt();

    // Get the current username
    String user = ((OnlinePlayers) request.session().attribute(USER_SESSION_ATTRIBUTE)).getName();

    return gameCenter.getGame(user).isValidTurn(startRow, startCell, endRow, endCell, user);
  }
}
