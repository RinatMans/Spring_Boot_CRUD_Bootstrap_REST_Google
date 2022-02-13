package web_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web_crud.model.User;
import web_crud.service.UserService;

@Controller
//@PreAuthorize("hasAnyRole('USER')")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public String getUserInfo(@AuthenticationPrincipal OAuth2User principal, Model model) {
        User user = userService.findByEmail(principal.getAttribute("email"));
        model.addAttribute("user", user);
        return "user";
    }

}


