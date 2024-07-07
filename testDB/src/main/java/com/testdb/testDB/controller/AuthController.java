package com.testdb.testDB.controller;

import com.testdb.testDB.dto.LoginDTO;
import com.testdb.testDB.dto.SignupDTO;
import com.testdb.testDB.model.Users;
import com.testdb.testDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp( @RequestBody SignupDTO signupDTO) {
        if (userService.existsByUsername(signupDTO.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already taken!");
        }

        if (userService.existsByEmail(signupDTO.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already in use!");
        }

        Users user = new Users();
        user.setUsername(signupDTO.getUsername());
        user.setPassword(signupDTO.getPassword());
        user.setEmail(signupDTO.getEmail());

        userService.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user) {
        String token = userService.login(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(token);
    }
}
