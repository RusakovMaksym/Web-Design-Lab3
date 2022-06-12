package application.web.controllers;

import application.data.users.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/authentication")
public class AuthenticationController {
    @GetMapping("/login")
    public String login() {
        return "/login";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user" , new User());
        return "/reg";
    }
}