package org.example.keycloakintegration.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.example.keycloakintegration.dto.UserRequestDTO;
import org.example.keycloakintegration.service.KeyCloakService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final KeyCloakService keyCloakService;

    @GetMapping("/admin")
    @RolesAllowed("admin")
    public String admin(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "admin";
    }

    @GetMapping("/user")
    public String user(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "user";
    }

    @GetMapping("/create")
    public String createUser() {
        return "create-user";
    }

    @PostMapping("/create")
    public String createUser(@RequestBody UserRequestDTO userRequestDTO) {
        keyCloakService.addUser(userRequestDTO);
        return "index";
    }

}