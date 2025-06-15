package com.example.jwt.pessoa.controller;

import com.example.jwt.pessoa.model.User;
import com.example.jwt.pessoa.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/perfil")
    public User perfil(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return user;
    }

    @PutMapping("/perfil")
    public User editar(@RequestBody User atualizacao, Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        user.setLogin(atualizacao.getLogin());
        user.setPassword(atualizacao.getPassword());
        return userRepository.save(user);
    }
}
