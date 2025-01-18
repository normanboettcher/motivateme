package de.nbs.motivateme.login.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoginControllerImpl implements LoginController{

    @Override
    @PostMapping("/perform_login")
    public boolean login(@RequestParam String username,@RequestParam String password) {
        return Objects.equals(username, password);
    }
}
