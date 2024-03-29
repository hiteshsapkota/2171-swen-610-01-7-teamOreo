package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.GAME_VIEW;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Board.Board;
import com.webcheckers.model.Board.Piece.colorEnum;
import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.model.WebCheckerGame;
import org.junit.Before;
import org.junit.Test;
import spark.HaltException;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

public class GetGameControllerTest {
  private GetGameController getGameController;
  private final GameCenter gameCenter = mock(GameCenter.class);
  @Before
  public void start(){

    getGameController = new GetGameController(gameCenter);
  }

  @Test
  public void handle1() {
    try{
      Session session = mock(Session.class);
      Request request = mock(Request.class);
      Response response = mock(Response.class);
      OnlinePlayers player = mock(OnlinePlayers.class);

      when(request.session()).thenReturn(session);
      when(session.attribute("user")).thenReturn(player);
      when(player.getName()).thenReturn("test");
      when(gameCenter.getGame("test")).thenReturn(null);
      ModelAndView view = getGameController.handle(request, response);
      assertNull(view);
    }
    catch (HaltException e){
      System.out.println("Halt Exception");
    }
  }

  @Test
  public void handle2(){
    try{
      Session session = mock(Session.class);
      Request request = mock(Request.class);
      Response response = mock(Response.class);
      OnlinePlayers player = mock(OnlinePlayers.class);
      WebCheckerGame game = mock(WebCheckerGame.class);
      String user = "test";
      String opponent = "test2";
      when(request.session()).thenReturn(session);
      when(session.attribute("user")).thenReturn(player);
      when(player.getName()).thenReturn(user);
      when(gameCenter.getGame(user)).thenReturn(game);
      when(game.getPlayer(user)).thenReturn(user);
      when(game.getOpponent(user)).thenReturn(opponent);
      when(game.getPlayerColor(user)).thenReturn(colorEnum.RED);
      when(game.getOpponentColor(user)).thenReturn(colorEnum.WHITE);
      when(game.isMyTurn(user)).thenReturn(true);
      when(game.getBoard()).thenReturn(mock(Board.class));

      ModelAndView view = getGameController.handle(request, response);
      assertNotNull(view);
      assertEquals(GAME_VIEW, view.getViewName());
    }
    catch (HaltException e){
      System.out.println("Halt Exception");
    }
  }
}