package com.webcheckers.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringsTest {
    Strings strings=new Strings();
    @Test
    public void stringNameTest() throws Exception{



        assertEquals("title", strings.TITLE_ATTR);
        assertEquals("currentPlayer",strings.CURRENT_PLAYER_ATTR);
        assertEquals("playerName",strings.PLAYER_NAME_ATTR);
        assertEquals("onlinePlayers",strings.ONLINE_PLAYERS_ATTR);
        assertEquals("username",strings.USERNAME_ATTR);
        assertEquals("message",strings.MESSAGE_ATTR);
        assertEquals("messageType",strings.MESSAGE_TYPE_ATTR);
        assertEquals("opponent",strings.OPPONENT_ATTR);
        assertEquals("playerColor",strings.PLAYER_COLOR_ATTR);
        assertEquals("isMyTurn",strings.IS_MY_TURN_ATTR);
        assertEquals("opponentName",strings.OPPONENT_NAME_ATTR);
        assertEquals("opponentColor",strings.OPPONENT_COLOR_ATTR);
        assertEquals("board",strings.BOARD_ATTR);
        assertEquals("user",strings.USER_SESSION_ATTRIBUTE);
        assertEquals("Welcome!",strings.WELCOME_TITLE);
        assertEquals("Game",strings.GAME_TITLE);
        assertEquals("Sign In!",strings.SIGN_IN_TITLE);
        assertEquals("error",strings.MESSAGE_TYPE_ERROR);
        assertEquals("The name you entered is empty!",strings.MESSAGE_EMPTY_NAME);
        assertEquals("The name already exists!",strings.MESSAGE_USER_EXISTS);
        assertEquals("home.ftl",strings.HOME_VIEW);
        assertEquals("signin.ftl",strings.SIGNIN_VIEW);
        assertEquals("game.ftl",strings.GAME_VIEW);
        assertEquals("/",strings.HOME_URL);
        assertEquals("/signin",strings.SIGN_IN_URL);
        assertEquals("/signout",strings.SIGN_OUT_URL);
        assertEquals("/play",strings.PLAY_URL);
        assertEquals("/game",strings.GAME_URL);
        assertEquals("/checkTurn",strings.CHECK_TURN);
        assertEquals("/validateMove",strings.VALIDATE_MOVE);
        assertEquals("/backupMove",strings.BACKUP_MOVE);
        assertEquals("/submitTurn",strings.SUBMIT_TURN);
        assertEquals("start",strings.START);
        assertEquals("end",strings.END);
        assertEquals("row",strings.ROW);
        assertEquals("cell",strings.CELL);
        assertEquals("Valid move!",strings.VALID_MOVE);
        assertEquals("Invalid move!",strings.INVALID_MOVE);
        assertEquals("Invalid move, you have already made a move!",strings.INVALID_ALREADY_MADE);
        assertEquals("Valid move! Get that piece!",strings.VALID_GET_PIECE);
        assertEquals("error",strings.MESSAGE_ERROR);
        assertEquals("info",strings.MESSAGE_INFO);
        assertEquals("Backed up the move",strings.BACKUP_SUCCESSFUL);
        assertEquals("This is a forced move because of the disk capture",strings.BACKUP_UNSUCCESSFUL);



    }


}
