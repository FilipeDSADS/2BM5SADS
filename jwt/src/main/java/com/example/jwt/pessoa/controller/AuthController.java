package com.example.jwt.pessoa.controller;

import com.example.jwt.pessoa.model.LoginRequest;
import com.example.jwt.pessoa.repository.UserRepository;
import com.example.jwt.pessoa.model.User;
import com.example.jwt.pessoa.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public User registrar(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // ✅
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword())
            );
            String token = jwtUtil.generateToken((UserDetails) auth.getPrincipal());
            return ResponseEntity.ok(token);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos");
        }
    }

}
