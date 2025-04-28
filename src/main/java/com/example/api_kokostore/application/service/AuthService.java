package com.example.api_kokostore.application.service;


import com.example.api_kokostore.application.dto.auth.AuthResponse;
import com.example.api_kokostore.application.dto.auth.RegisterRequest;

import com.example.api_kokostore.config.models.JwtPayload;
import com.example.api_kokostore.domain.entities.UserEntity;
import com.example.api_kokostore.domain.enums.Roles;
import com.example.api_kokostore.domain.repository.UserRepository;
import com.example.api_kokostore.shared.CookiesUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CookiesUtil cookiesUtil;

    public AuthService(JwtService jwtService, AuthenticationManager authenticationManager, UserRepository userRepository, CookiesUtil cookiesUtil) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.cookiesUtil = cookiesUtil;
    }

    public AuthResponse login(HttpServletResponse res, String username, String password) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        System.out.println(userDetails.getUsername());



        UserEntity user = userRepository.findByEmailOrUsername(username,userDetails.getUsername()).orElseThrow(()-> new UsernameNotFoundException("User not found"));

        JwtPayload jwtPayload = new JwtPayload(user.getId().toString(),user.getEmail(),user.getRole());

        long accessTokenExpiration = 15 * 60; //15min
        long refreshTokenExpiration = 7 * 24 * 60 * 60; //7 dias

        String accessToken = jwtService.generateToken(jwtPayload,accessTokenExpiration);

        String refreshToken = jwtService.generateToken(jwtPayload, refreshTokenExpiration);


        cookiesUtil.setCookie(res, "accessToken", accessToken,  (int) accessTokenExpiration * 60, null);

        cookiesUtil.setCookie(res, "refreshToken", refreshToken, (int) refreshTokenExpiration * 60, null);

        return AuthResponse.fromUser(user,accessToken);

    }


    public AuthResponse register(HttpServletResponse res, RegisterRequest request) {

        UserEntity user = new UserEntity();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setEmail(request.email());
        user.setUsername(request.username());
        user.setRole(Roles.USER);
        user.setPassword(encoder.encode(request.password()));

        var user2 = userRepository.save(user);
        System.out.println(user2);
        return login(res, request.email(), request.password());
    }

}
