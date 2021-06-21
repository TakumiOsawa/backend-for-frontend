package com.example.backendforfrontend.app.web;

import com.example.backendforfrontend.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestOperations;

@Controller
public class BackendForFrontendController {
    private final RestOperations restOperations;

    public BackendForFrontendController(@Autowired RestOperations restOperations){
        this.restOperations = restOperations;
    }

    @RequestMapping(method = RequestMethod.GET, value = "users")
    public String getUsers(Model model){
        String service = "/backend/api/v1/users";
        model.addAttribute("users",
                restOperations.getForObject(service, User[].class));
        return "users";
    }
}