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
  public static final String USER_SESSION_ATTRIBUTE = "user";


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
  public static final String MESSAGE_EMPTY_NAME = "The name you entered is empty!";
  public static final String MESSAGE_USER_EXISTS = "The name already exists!";

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
  public static final String GAME_URL = "/game";
  public static final String CHECK_TURN = "/checkTurn";
  public static final String VALIDATE_MOVE = "/validateMove";
  public static final String BACKUP_MOVE = "/backupMove";
  public static final String SUBMIT_TURN = "/submitTurn";

    /**
     * MOVEMENTS
     */
    public static final String START = "start";
    public static final String END = "end";
    public static final String ROW = "row";
    public static final String CELL = "cell";

  /**
   * Messages 2
   */
  static final String VALID_MOVE = "Valid move!";
  static final String INVALID_MOVE = "Invalid move!";
  static final String INVALID_ALREADY_MADE = "Invalid move, you have already made a move!";
  static final String INVALID_ONLY_DIAGONALS = "Invalid move, only diagonals forwards are allowed";
  static final String VALID_GET_PIECE = "Valid move! Get that piece!";
  public static final String MESSAGE_ERROR = "error";
  public static final String MESSAGE_INFO = "info";
  public static final String BACKUP_SUCCESSFUL = "Backed up the move";
  public static final String BACKUP_UNSUCCESSFUL = "This is a forced move because of the disk capture";
}
