package web_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web_crud.model.User;
import web_crud.service.RoleService;
import web_crud.service.UserService;


@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyRole('ADMIN')")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping()
    public String index(@AuthenticationPrincipal OAuth2User principal, Model model) {
        User user = userService.findByEmail(principal.getAttribute("email"));

        model.addAttribute("user", userService.getUsersList());
        model.addAttribute("AllRoles", roleService.getAllRoles());
        model.addAttribute("userLogin", user);
        return "admin";
    }

}
