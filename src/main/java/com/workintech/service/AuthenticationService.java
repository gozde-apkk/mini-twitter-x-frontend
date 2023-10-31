package com.workintech.service;



import com.workintech.dao.UserRepository;
import com.workintech.dao.RoleRepository;
import com.workintech.entity.Role;
import com.workintech.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.Date;
import java.util.HashSet;

import java.util.Set;

@Service
public class AuthenticationService {
    private UserRepository memberRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    @Autowired
    public AuthenticationService(UserRepository memberRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager) {
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;

    }

    public User register(String email, String password, String username, String firstName, String lastName, Date birthOfDate) {
        String encodedPassword = passwordEncoder.encode(password);
       Role memberrole = roleRepository.findByAuthority("USER").get();
        Set<Role> roles = new HashSet<>();
        roles.add(memberrole);
        return null;
    }
}



