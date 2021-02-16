package com.portfolio.demoofme.controllers;

import com.portfolio.demoofme.conf.LoginRequest;
import com.portfolio.demoofme.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUserSafe(@RequestBody LoginRequest request, Model model) {

        ModelAndView mav = new ModelAndView("register");

        if (!request.password.equals(request.passwordConf)) {
            model.addAttribute("passwordError", "passwords are not equals");
            mav.addObject("passwordError", "Passwords are not equal");
            return "register";
        }

        if (request.password.equals(request.passwordConf)) {
            userService.registerUser(request.username, request.password);
            return "redirect:/login";
        }

        return "redirect:/login";
    }

}
