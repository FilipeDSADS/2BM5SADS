package com.example.jwt.pessoa.controller;

import com.example.jwt.pessoa.model.User;
import com.example.jwt.pessoa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/usuarios")
    public List<User> listarTodos() {
        return userRepository.findAll();
    }

    @DeleteMapping("/usuarios/{id}")
    public void deletar(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
