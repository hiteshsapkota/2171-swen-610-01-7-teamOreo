package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.BOARD_ATTR;
import static com.webcheckers.model.Strings.CURRENT_PLAYER_ATTR;
import static com.webcheckers.model.Strings.GAME_TITLE;
import static com.webcheckers.model.Strings.GAME_VIEW;
import static com.webcheckers.model.Strings.HOME_VIEW;
import static com.webcheckers.model.Strings.IS_MY_TURN_ATTR;
import static com.webcheckers.model.Strings.MESSAGE_ATTR;
import static com.webcheckers.model.Strings.MESSAGE_PLAYER_PLAYING;
import static com.webcheckers.model.Strings.MESSAGE_TYPE_ATTR;
import static com.webcheckers.model.Strings.MESSAGE_TYPE_ERROR;
import static com.webcheckers.model.Strings.ONLINE_PLAYERS_ATTR;
import static com.webcheckers.model.Strings.OPPONENT_ATTR;
import static com.webcheckers.model.Strings.OPPONENT_COLOR_ATTR;
import static com.webcheckers.model.Strings.OPPONENT_NAME_ATTR;
import static com.webcheckers.model.Strings.PLAYER_COLOR_ATTR;
import static com.webcheckers.model.Strings.PLAYER_NAME_ATTR;
import static com.webcheckers.model.Strings.TITLE_ATTR;
import static com.webcheckers.model.Strings.USERNAME_ATTR;
import static com.webcheckers.model.Strings.WELCOME_TITLE;

import com.webcheckers.model.Board.Board;
import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.model.Board.Piece;
import com.webcheckers.model.Board.Piece.colorEnum;
import com.webcheckers.model.Board.Piece.typeEnum;
import com.webcheckers.model.Board.Row;
import com.webcheckers.model.Board.Space;
import com.webcheckers.ui.JsonUtils;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * GetPlayController gets the game view which shows the game view with the initial board layout.
 */
public class GetPlayController implements TemplateViewRoute {

  @Override
  public ModelAndView handle(Request request, Response response) {
    // get the name of the opponent and the player.
    String opponent = request.queryParams(OPPONENT_ATTR);
    String player = request.session().attribute(USERNAME_ATTR);
    Map<String, Object> vm = new HashMap<>();

    // get indexes of player and opponent from the list.
    int playerIndex = OnlinePlayers.onlineList.indexOf(new OnlinePlayers(player));
    int opponentIndex = OnlinePlayers.onlineList.indexOf(new OnlinePlayers(opponent));

    // if the opponent is free
    if (OnlinePlayers.onlineList.get(opponentIndex).isFree()) {
      // put the initial values.
      vm.put(TITLE_ATTR, GAME_TITLE);
      vm.put(PLAYER_NAME_ATTR, request.session().attribute(USERNAME_ATTR));
      vm.put(PLAYER_COLOR_ATTR, Piece.colorEnum.RED);
      vm.put(IS_MY_TURN_ATTR, true);
      vm.put(OPPONENT_NAME_ATTR, request.queryParams(OPPONENT_ATTR));
      vm.put(OPPONENT_COLOR_ATTR, Piece.colorEnum.WHITE);

      // make the players not free so that others cannot play with them.
      OnlinePlayers.onlineList.get(opponentIndex).setFree(false);
      OnlinePlayers.onlineList.get(playerIndex).setFree(false);

      Board board = new Board();
      // initialize all the rows in the board.
      for (int i = 0; i < 8; i++) {
        board.rows.add(new Row(i));
      }

      // initialize all the spaces for each rows
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
          board.rows.get(i).spaces.add(new Space(j, true, null));
        }
      }

      // initialize all the pieces.
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
          if (i == 0 || i == 2) { // for the row 1 and 3
            if (j % 2 != 0) { // for all odd places, add a red piece
              board.rows.get(i).spaces.get(j).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
            }
          }
          if (i == 1) { // for row 2
            if (j % 2 == 0) { // for all the even places, add a red piece
              board.rows.get(i).spaces.get(j).setPiece(new Piece(typeEnum.SINGLE, colorEnum.RED));
            }
          }

          if (i == 5 || i == 7) { // for row 6 and 8
            if (j % 2 == 0) { // for all even places, add a white piece
              board.rows.get(i).spaces.get(j).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
            }
          }
          if (i == 6) { // for row 7
            if (j % 2 != 0) { // for all odd places, add a white piece
              board.rows.get(i).spaces.get(j).setPiece(new Piece(typeEnum.SINGLE, colorEnum.WHITE));
            }
          }
        }
      }

      // add the board class to the view
      vm.put(BOARD_ATTR, board);
      return new ModelAndView(vm, GAME_VIEW);
    } else { // if the opponent got busy
      vm.put(TITLE_ATTR, WELCOME_TITLE);
      vm.put(CURRENT_PLAYER_ATTR, true);
      vm.put(PLAYER_NAME_ATTR, request.session().attribute(USERNAME_ATTR));
      vm.put(ONLINE_PLAYERS_ATTR, JsonUtils.toJson(OnlinePlayers.onlineList));
      vm.put(MESSAGE_TYPE_ATTR, MESSAGE_TYPE_ERROR);
      vm.put(MESSAGE_ATTR, MESSAGE_PLAYER_PLAYING);
      return new ModelAndView(vm, HOME_VIEW);
    }
  }
}
