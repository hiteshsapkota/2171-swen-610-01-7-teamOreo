package com.webcheckers.ui.Game;

import com.google.gson.JsonObject;
import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.ui.JsonUtils;
import spark.Request;
import spark.Response;
import spark.Route;

import static com.webcheckers.model.Strings.*;

/**
 * Checks move is legal or illegal
 */
public class PostValidateMoveController implements Route {
  private final GameCenter gameCenter;

  /**
   * Initializes the gameCenter attribute.
   * @param gameCenter the one and only gamecenter.
   */
  public PostValidateMoveController(final GameCenter gameCenter){
    this.gameCenter = gameCenter;
  }

  /**
   * This handle method captures the start position and end position and based on that
   * determines if the move is legal or illegal
   * @param request generic request.
   * @param response generic response.
   * @return returns the message containing info and content.
   * @throws Exception if any.
   */
  @Override
  public Object handle(Request request, Response response) throws Exception {
    // Get the start and end positions
    System.out.println(request.body());
    JsonObject jsonObject = JsonUtils.fromJson(request.body(), JsonObject.class);
    JsonObject start = jsonObject.getAsJsonObject(START);
    JsonObject end = jsonObject.getAsJsonObject(END);
    int startRow = start.get(ROW).getAsInt();
    int startCell = start.get(CELL).getAsInt();
    int endRow = end.get(ROW).getAsInt();
    int endCell = end.get(CELL).getAsInt();

    // Get the current username
    String user = ((OnlinePlayers) request.session().attribute(USER_SESSION_ATTRIBUTE)).getName();
    return gameCenter.getGame(user).isValidTurn(startRow, startCell, endRow, endCell);
  }
}
