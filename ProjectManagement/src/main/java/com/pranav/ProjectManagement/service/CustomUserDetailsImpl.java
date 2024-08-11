package com.pranav.ProjectManagement.service;

import com.pranav.ProjectManagement.Model.User;
import com.pranav.ProjectManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsImpl implements UserDetailsService {

    private UserRepository userRepository;

    // Default Constructor
    public CustomUserDetailsImpl(){}

    // Constructor Injection
    @Autowired
    public CustomUserDetailsImpl (UserRepository theUserRepository) {
        this.userRepository = theUserRepository;
    }

    // find the particular username from the database with the help of userRepository
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        // List of all the authorities associated with the returned user that means roles assigned to the user
        List <GrantedAuthority> authorities = new ArrayList<>();

        // return the new instance of the userDetails that contains user email, password and List of authorities
        return new org.springframework.security.core.userdetails.User(user.getEmail()
        , user.getPassword(), authorities);
    }
}
