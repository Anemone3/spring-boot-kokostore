package com.example.api_kokostore.application.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.api_kokostore.application.dto.users.CustomerRequest;
import com.example.api_kokostore.application.dto.users.UserResponse;
import com.example.api_kokostore.application.service.JwtService;
import com.example.api_kokostore.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PatchMapping("/customer")
    public ResponseEntity<UserResponse> toCustomer(@RequestBody CustomerRequest request, @CookieValue(name = "accessToken") String token){

        DecodedJWT payload = jwtService.decodeToken(token);

        var id = payload.getSubject();

        UserResponse user = userService.createOrUpdateCustomer(request, UUID.fromString(id));
        return ResponseEntity.ok(user);
    }
}
