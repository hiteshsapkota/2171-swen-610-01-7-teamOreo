package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;

import com.webcheckers.model.OnlinePlayers;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * The Web Controller for the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
public class HomeController implements TemplateViewRoute {
  public static String PLAYERSTATUS="currentPlayer";
  public static String PLAYERSLIST="onlinePlayers";
  public static String PLAYERNAME="playerName";
  public static String GAMETITLE="title";
  @Override
  public ModelAndView handle(Request request, Response response) {
    Map<String, Object> vm = new HashMap<>();
    vm.put("title", "Welcome!");
    String currentUsername=request.session().attribute("username");
    if(currentUsername==null)
      vm.put(PLAYERSTATUS,false);
    else
    {
      vm.put(PLAYERSTATUS,true);
      vm.put(PLAYERNAME,currentUsername);
      vm.put(PLAYERSLIST,JsonUtils.toJson(OnlinePlayers.onlineList));
    }
    return new ModelAndView(vm , "home.ftl");
  }

}