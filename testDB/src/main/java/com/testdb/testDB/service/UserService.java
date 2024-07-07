package com.testdb.testDB.service;

import com.testdb.testDB.config.JwtTokenProvider;
import com.testdb.testDB.model.Users;
import com.testdb.testDB.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Users> getAllUser() {
        List<Users> list = userRepo.findAll();
        return list;
    }

    public Users save(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public boolean existsByUsername(String username) {
        return userRepo.findByUsername(username).isPresent();
    }

    public boolean existsByEmail(String email) {
        return userRepo.findByEmail(email).isPresent();
    }

    public String validateUser(String userName, String password) {
        Optional<Users> user = userRepo.findByUsername(userName);
        if (user.isEmpty()) {
            return "Username does not exist";
        } else if (!passwordEncoder.matches(password, user.get().getPassword())) {
            return "Invalid password";
        }
        return "Success";
    }

    public String login(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtTokenProvider.generateToken(username);
    }
}





