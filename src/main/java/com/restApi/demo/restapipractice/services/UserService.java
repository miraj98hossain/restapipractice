package com.restApi.demo.restapipractice.services;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.restApi.demo.restapipractice.entities.AppUser;
import com.restApi.demo.restapipractice.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTService jwtService;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public AppUser register(AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        return userRepository.save(appUser);
    }

    public String veryfy(AppUser appUser) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(appUser.getUserName(), appUser.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(appUser.getUserName());
        } else {
            return "Fail";
        }
    }

}
