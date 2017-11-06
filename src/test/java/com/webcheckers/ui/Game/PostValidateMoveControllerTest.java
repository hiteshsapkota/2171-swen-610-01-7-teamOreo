package com.webcheckers.ui.Game;

import static com.webcheckers.model.Strings.OPPONENT_ATTR;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Message;
import com.webcheckers.model.OnlinePlayers;
import com.webcheckers.model.WebCheckerGame;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Session;

public class PostValidateMoveControllerTest {

  private PostValidateMoveController postValidateMoveController;
  private GameCenter gameCenter = mock(GameCenter.class);
  @Before
  public void start(){

    postValidateMoveController = new PostValidateMoveController(gameCenter);
  }

  @Test
  public void handle1() throws Exception {
    Session session = mock(Session.class);
    Request request = mock(Request.class);
    Response response = mock(Response.class);
    OnlinePlayers player = mock(OnlinePlayers.class);
    String user = "test";
    WebCheckerGame game = mock(WebCheckerGame.class);
    Message mock = new Message("message1", "info");
    when(request.session()).thenReturn(session);
    when(session.attribute("user")).thenReturn(player);
    when(player.getName()).thenReturn(user);
    when(gameCenter.getGame(user)).thenReturn(game);
    when(game.isValidTurn(1, 1, 2, 2, user)).thenReturn(mock);
    when(request.body()).thenReturn("{'start':{'row':1,'cell':1},'end':{'row':2,'cell':2}}");
    Message object = (Message) postValidateMoveController.handle(request, response);
    assertNotNull(object);

    assertEquals("message1", object.text);
    assertEquals("info", object.type);


  }

}