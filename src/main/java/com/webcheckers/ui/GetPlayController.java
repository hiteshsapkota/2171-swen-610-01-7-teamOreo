package com.webcheckers.ui;

import com.webcheckers.model.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class GetPlayController implements TemplateViewRoute {
    @Override
    public ModelAndView handle(Request request, Response response) {
        String opponent = request.queryParams("opponent");
        String player = request.session().attribute("username");
        Map<String, Object> vm = new HashMap<>();

        int playerIndex = OnlinePlayers.onlineList.indexOf(new OnlinePlayers(player));
        int opponentIndex = OnlinePlayers.onlineList.indexOf(new OnlinePlayers(opponent));
        if (OnlinePlayers.onlineList.get(opponentIndex).isFree()){
            vm.put("title","Game");
            vm.put("playerName", request.session().attribute("username"));
            vm.put("playerColor", Piece.colorEnum.RED);
            vm.put("isMyTurn", true);
            vm.put("opponentName", request.queryParams("opponent"));
            vm.put("opponentColor", Piece.colorEnum.WHITE);

            OnlinePlayers.onlineList.get(opponentIndex).setFree(false);
            OnlinePlayers.onlineList.get(playerIndex).setFree(false);
            Board board = new Board();

            for (int i = 0; i < 8; i++) {
                board.rows.add(new Row(i));
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board.rows.get(i).spaces.add(new Space(j, true, null));
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (i == 0 || i == 2){
                        if (j % 2 != 0){
                            board.rows.get(i).spaces.get(j).piece = new Piece();
                            board.rows.get(i).spaces.get(j).piece.type = Piece.typeEnum.SINGLE;
                            board.rows.get(i).spaces.get(j).piece.color = Piece.colorEnum.RED;
                        }
                    }
                    if (i == 1){
                        if (j % 2 == 0){
                            board.rows.get(i).spaces.get(j).piece = new Piece();
                            board.rows.get(i).spaces.get(j).piece.type = Piece.typeEnum.SINGLE;
                            board.rows.get(i).spaces.get(j).piece.color = Piece.colorEnum.RED;
                        }
                    }

                    if (i == 5 || i == 7){
                        if (j % 2 == 0){
                            board.rows.get(i).spaces.get(j).piece = new Piece();
                            board.rows.get(i).spaces.get(j).piece.type = Piece.typeEnum.SINGLE;
                            board.rows.get(i).spaces.get(j).piece.color = Piece.colorEnum.WHITE;
                        }
                    }
                    if (i == 6){
                        if (j % 2 != 0){
                            board.rows.get(i).spaces.get(j).piece = new Piece();
                            board.rows.get(i).spaces.get(j).piece.type = Piece.typeEnum.SINGLE;
                            board.rows.get(i).spaces.get(j).piece.color = Piece.colorEnum.WHITE;
                        }
                    }
                }
            }

            vm.put("board", board);
            return new ModelAndView(vm, "game.ftl");
        }
        else {
            vm.put("title","Game");
            vm.put("currentPlayer", true);
            vm.put("playerName", request.session().attribute("username"));
            vm.put("onlinePlayers", JsonUtils.toJson(OnlinePlayers.onlineList));
            vm.put("messageType", "error");
            vm.put("message", "The player already is in another game!");
            return new ModelAndView(vm, "home.ftl");
        }
    }
}
