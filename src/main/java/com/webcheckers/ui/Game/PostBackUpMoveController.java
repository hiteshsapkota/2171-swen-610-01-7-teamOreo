package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.*;
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
        String user = ((OnlinePlayers)request.session().attribute(USER_SESSION_ATTRIBUTE)).getName();
        Message message;
        if(gameCenter.getGame(user).popMove()){
            message = new Message(BACKUP_SUCCESSFUL, MESSAGE_INFO);
        }
        else {
            message = new Message(BACKUP_UNSUCCESSFUL, MESSAGE_ERROR);
        }
        return message;
    }
}