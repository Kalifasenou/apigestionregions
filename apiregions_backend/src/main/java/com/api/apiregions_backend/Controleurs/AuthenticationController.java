package com.api.apiregions_backend.Controleurs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.apiregions_backend.Modeles.User;
import com.api.apiregions_backend.Repositories.UserRepository;

import io.jsonwebtoken.*;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User userInDb = userRepository.findByUsername(user.getUsername());
        if (userInDb == null || !userInDb.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", userInDb.getRole())
                .setExpiration(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, "secret")
                .compact();
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        User userInDb = userRepository.findByUsername(user.getUsername());
        if (userInDb != null) {
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
