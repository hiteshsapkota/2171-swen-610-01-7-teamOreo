package com.webcheckers.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringsTest {

    @Test
    public void stringNameTest() throws Exception{



        assertEquals("title", Strings.TITLE_ATTR);
        assertEquals("currentPlayer", Strings.CURRENT_PLAYER_ATTR);
        assertEquals("playerName", Strings.PLAYER_NAME_ATTR);
        assertEquals("onlinePlayers", Strings.ONLINE_PLAYERS_ATTR);
        assertEquals("username", Strings.USERNAME_ATTR);
        assertEquals("message", Strings.MESSAGE_ATTR);
        assertEquals("messageType", Strings.MESSAGE_TYPE_ATTR);
        assertEquals("opponent", Strings.OPPONENT_ATTR);
        assertEquals("playerColor", Strings.PLAYER_COLOR_ATTR);
        assertEquals("isMyTurn", Strings.IS_MY_TURN_ATTR);
        assertEquals("opponentName", Strings.OPPONENT_NAME_ATTR);
        assertEquals("opponentColor", Strings.OPPONENT_COLOR_ATTR);
        assertEquals("board", Strings.BOARD_ATTR);
        assertEquals("user", Strings.USER_SESSION_ATTRIBUTE);
        assertEquals("Welcome!", Strings.WELCOME_TITLE);
        assertEquals("Game", Strings.GAME_TITLE);
        assertEquals("Sign In!", Strings.SIGN_IN_TITLE);
        assertEquals("The name you entered is empty!", Strings.MESSAGE_EMPTY_NAME);
        assertEquals("The name already exists!", Strings.MESSAGE_USER_EXISTS);
        assertEquals("home.ftl", Strings.HOME_VIEW);
        assertEquals("signin.ftl", Strings.SIGNIN_VIEW);
        assertEquals("game.ftl", Strings.GAME_VIEW);
        assertEquals("/", Strings.HOME_URL);
        assertEquals("/signin", Strings.SIGN_IN_URL);
        assertEquals("/signout", Strings.SIGN_OUT_URL);
        assertEquals("/play", Strings.PLAY_URL);
        assertEquals("/game", Strings.GAME_URL);
        assertEquals("/checkTurn", Strings.CHECK_TURN);
        assertEquals("/validateMove", Strings.VALIDATE_MOVE);
        assertEquals("/backupMove", Strings.BACKUP_MOVE);
        assertEquals("/submitTurn", Strings.SUBMIT_TURN);
        assertEquals("start", Strings.START);
        assertEquals("end", Strings.END);
        assertEquals("row", Strings.ROW);
        assertEquals("cell", Strings.CELL);
        assertEquals("Valid move!", Strings.VALID_MOVE);
        assertEquals("Invalid move!", Strings.INVALID_MOVE);
        assertEquals("Invalid move, you have already made a move!", Strings.INVALID_ALREADY_MADE);
        assertEquals("Valid move! Get that piece!", Strings.VALID_GET_PIECE);
        assertEquals("error", Strings.MESSAGE_ERROR);
        assertEquals("info", Strings.MESSAGE_INFO);
        assertEquals("Backed up the move", Strings.BACKUP_SUCCESSFUL);
        assertEquals("This is a forced move because of the disk capture",
            Strings.BACKUP_UNSUCCESSFUL);



    }


}
