package application.web.controllers;

import application.data.users.User;
import application.data.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/all")
public class AnyAuthorityController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        User user = userService.getUserByMail(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user" , user);
        return "/main";
    }

    @GetMapping("/about")
    public String about(Model model) {
        User user = userService.getUserByMail(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user" , user);
        return "/about";
    }
}