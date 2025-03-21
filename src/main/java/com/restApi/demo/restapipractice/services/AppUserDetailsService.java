package com.restApi.demo.restapipractice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.restApi.demo.restapipractice.entities.AppUser;
import com.restApi.demo.restapipractice.entities.AppUserDetails;
import com.restApi.demo.restapipractice.repositories.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUserName(username);
        if (user == null) {
            System.out.println("User Not found");
            throw new UsernameNotFoundException("User Not Found");
        }
        return new AppUserDetails(user);
    }

}
