package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.*;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Message;
import com.webcheckers.model.OnlinePlayers;
import spark.Request;
import spark.Response;
import spark.Route;
/*
 This class backs up/undo a move
 */
public class PostBackUpMoveController implements Route {

    private final GameCenter gameCenter;

    /**
     * Initializes the gameCenter attribute.
     * @param gameCenter the one and only gamecenter.
     */
    public PostBackUpMoveController(final GameCenter gameCenter) {
        this.gameCenter = gameCenter;
    }

    /**
     * This handle method checks if the backup move requested by a player can be implemented and
     * displays message accordingly
     * @param request generic request.
     * @param response generic response.
     * @return Message object which contains the content and type.
     * @throws Exception if any.
     */
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