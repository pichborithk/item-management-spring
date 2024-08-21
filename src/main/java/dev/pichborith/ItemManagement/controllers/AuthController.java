package dev.pichborith.ItemManagement.controllers;

import dev.pichborith.ItemManagement.models.AuthResponse;
import dev.pichborith.ItemManagement.models.User;
import dev.pichborith.ItemManagement.models.UserRequest;
import dev.pichborith.ItemManagement.services.JwtService;
import dev.pichborith.ItemManagement.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
        @RequestBody UserRequest request) {

        User user = userService.createUser(request);
        String token = jwtService.generateToken(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        AuthResponse response = new AuthResponse("Register new user successful",
                                                 map);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring API";
    }
}
