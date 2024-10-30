package com.application.login.controller;

import com.application.login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.application.login.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        try {
            userService.save(user);
            return "Kayıt başarılı!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "Bir hata oluştu: " + e.getMessage();
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            if (existingUser.getPassword().equals(user.getPassword())) {
                return "Giriş başarılı!";
            } else {
                return "Şifre yanlış!";
            }
        } else {
            return "Kullanıcı bulunamadı!";
        }
    }
}
