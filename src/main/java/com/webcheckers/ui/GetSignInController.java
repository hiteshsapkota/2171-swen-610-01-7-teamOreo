package com.webcheckers.ui;


import com.webcheckers.model.OnlinePlayers;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class GetSignInController implements TemplateViewRoute{


    @Override
    public ModelAndView handle(Request request, Response response) {
      Map<String, Object> vm = new HashMap<>();
      String username = request.session().attribute("username");
      if(username==null){
          //Show login information
          vm.put("title", "Sign In!");
          return new ModelAndView(vm, "signIn.ftl");

      }
      else{
          //Redirect to home
          vm.put("title", "Welcome!");
          vm.put("currentPlayer",true);
          vm.put("playerName", username);
          vm.put("onlinePlayers", JsonUtils.toJson(OnlinePlayers.onlineList));
          return new ModelAndView(vm,"home.ftl");

      }

    }
}
