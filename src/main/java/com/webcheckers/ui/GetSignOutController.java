package com.webcheckers.ui;

import com.webcheckers.model.OnlinePlayers;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class GetSignOutController implements TemplateViewRoute {

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        OnlinePlayers.onlineList.remove(new OnlinePlayers(request.session().attribute("username"), true));
        request.session().removeAttribute("username");
        vm.put("title", "Welcome!");
        vm.put("currentPlayer", false);
        return new ModelAndView(vm, "home.ftl");
    }
}
