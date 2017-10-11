package com.webcheckers.model;

/**
 * This is a class where all the string literals exists, all the class reference it to get the attributes, messages and file names.
 */
public class Strings {

  /**
   * Attributes
   */
  public static final String TITLE_ATTR = "title";
  public static final String CURRENT_PLAYER_ATTR = "currentPlayer";
  public static final String PLAYER_NAME_ATTR = "playerName";
  public static final String ONLINE_PLAYERS_ATTR = "onlinePlayers";
  public static final String USERNAME_ATTR = "username";
  public static final String MESSAGE_ATTR = "message";
  public static final String MESSAGE_TYPE_ATTR = "messageType";
  public static final String OPPONENT_ATTR = "opponent";
  public static final String PLAYER_COLOR_ATTR = "playerColor";
  public static final String IS_MY_TURN_ATTR = "isMyTurn";
  public static final String OPPONENT_NAME_ATTR = "opponentName";
  public static final String OPPONENT_COLOR_ATTR = "opponentColor";
  public static final String BOARD_ATTR = "board";


  /**
   * Title names
   */
  public static final String WELCOME_TITLE = "Welcome!";
  public static final String GAME_TITLE = "Game";
  public static final String SIGN_IN_TITLE = "Sign In!";

  /**
   * Messages
   */
  public static final String MESSAGE_TYPE_ERROR = "error";
  public static final String MESSAGE_TYPE_INFO = "info";
  public static final String MESSAGE_EMPTY_NAME = "The name you entered is empty!";
  public static final String MESSAGE_USER_EXISTS = "The name already exists!";
  public static final String MESSAGE_PLAYER_PLAYING = "The player already is in another game!";
  public static final String MESSAGE_SIGNED_IN = "Successfully Signed In :D";

  /**
   * Views
   */
  public static final String HOME_VIEW = "home.ftl";
  public static final String SIGNIN_VIEW = "signin.ftl";
  public static final String GAME_VIEW = "game.ftl";

  /**
   * Web paths
   */
  public static final String HOME_URL = "/";
  public static final String SIGN_IN_URL = "/signin";
  public static final String SIGN_OUT_URL = "/signout";
  public static final String PLAY_URL = "/play";


}
