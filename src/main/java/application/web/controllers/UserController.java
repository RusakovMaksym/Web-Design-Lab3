package application.web.controllers;

import application.data.links.Link;
import application.data.links.service.LinkService;
import application.data.users.User;
import application.data.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    private LinkService linkService;

    @Autowired
    public void setLinkService(LinkService linkService) {
        this.linkService = linkService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("userModel") User user) {
        userService.saveUser(user);
        return "/login";
    }

    @GetMapping("/personal")
    @PreAuthorize("hasAnyAuthority('access:user:read')")
    public String personalPage(Model model) {
        User user = userService.getUserByMail(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user" , user);
        return "/profile";
    }

    @ResponseBody
    @PostMapping("/link")
    @PreAuthorize("hasAnyAuthority('access:user:read')")
    public ResponseEntity<Boolean> createLink(@RequestParam("link") String link,
                                              @RequestParam("short") String shortLink) {
        User user = userService.getUserByMail(SecurityContextHolder.getContext().getAuthentication().getName());
        Link linkData = new Link();
        linkData.setFullLink(link);
        linkData.setShortLink(shortLink);
        linkData.setUser(user);
        linkService.addLink(linkData);
        return ResponseEntity.ok(true);
    }
}