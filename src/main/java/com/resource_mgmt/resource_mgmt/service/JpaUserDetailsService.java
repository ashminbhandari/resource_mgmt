package com.resource_mgmt.resource_mgmt.service;

import java.util.function.Supplier;

import com.resource_mgmt.resource_mgmt.entity.User;
import com.resource_mgmt.resource_mgmt.model.CustomUserDetails;
import com.resource_mgmt.resource_mgmt.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder; 

    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        
        Supplier<UsernameNotFoundException> s =
                () -> new UsernameNotFoundException("Problem during authentication!");

        User u = userRepository.findUserByUsername(username).orElseThrow(s);
        
        // in memory test
/*         User u = new User();
        u.setUsername("root");
        u.setPassword(passwordEncoder.encode("root"));
        Profile p = new Profile();
        p.setType("Admin");
        u.setProfiles(Arrays.asList(p)); */

        return new CustomUserDetails(u);
    }
}