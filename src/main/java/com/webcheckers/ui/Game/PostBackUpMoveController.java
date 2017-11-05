package com.webcheckers.ui.Game;

import static spark.Spark.halt;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Message;
import com.webcheckers.model.OnlinePlayers;
import spark.Request;
import spark.Response;
import spark.Route;

public class PostBackUpMoveController implements Route {

    private final GameCenter gameCenter;

    public PostBackUpMoveController(final GameCenter gameCenter) {
        this.gameCenter = gameCenter;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        System.out.println(request.body());
        String user = ((OnlinePlayers)request.session().attribute("user")).getName();
        Message message;
        if(gameCenter.getGame(user).popMove()){
            message = new Message("Backed Up the Move", "info");
        }
        else {
            message = new Message("This is a forced move because of the disk capture", "error");
        }
        return message;
    }
}