package com.webcheckers.ui;

import com.webcheckers.model.OnlinePlayers;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class PostSignInController implements TemplateViewRoute {

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        OnlinePlayers name = new OnlinePlayers(request.queryParams("username").toLowerCase(), true);
        if (name.getName().equals("")){
            vm.put("title", "Welcome!");
            vm.put("message", "The name you entered is empty!");
            vm.put("messageType", "error");
            return new ModelAndView(vm, "signin.ftl");
        }
        else {
            request.session().attribute("username", name.getName());
            OnlinePlayers.onlineList.add(name);
            vm.put("title", "Welcome!");
            vm.put("currentPlayer", true);
            vm.put("onlinePlayers", JsonUtils.toJson(OnlinePlayers.onlineList));
            vm.put("playerName", request.session().attribute("username"));
            return new ModelAndView(vm, "home.ftl");
        }
    }
}
