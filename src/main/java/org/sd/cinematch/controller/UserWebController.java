package org.sd.cinematch.controller;

import org.sd.cinematch.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserWebController {    

    private final UserService userService;

    public UserWebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/watchlist/{id}")
    public String watchlist(Model model, @PathVariable long id) {
        model.addAttribute("watchlist", userService.findById(id).getAddedFilms());
        return "watchlist";        
    }

    // Redireccionar a signup.html para crear un nuevo usuario
    @GetMapping("/signup")
    public String showSignUpForm() {
        return "signup";
    }

    // Redireccionar a login.html para obtener un usuario
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/createuser")
    public String showCreateUserForm() {
        return "createuser";
    }

    @GetMapping("/forgotpwd")
    public String showForgotPwdForm() {
        return "forgotpwd";
    }

    // Redireccionar a welcome.html para eliminar un usuario
    @GetMapping("/deleteuser")
    public String showRemovePage() {
        return "deleteuser";
    }

    // Redireccionar a profile.html para reemplazar un usuario
    @GetMapping("/replaceuser")
    public String showReplacePage() {
        return "replaceuser";
    }

    // Redireccionar a update.html para actualizar parcialmente un usuario
    @GetMapping("/updateuser")
    public String showUpdateForm() {
        return "updateuser";
    }
}
