package com.workintech.service;



import com.workintech.dao.UserRepository;
import com.workintech.dao.RoleRepository;
import com.workintech.dto.LoginResponse;
import com.workintech.entity.Role;
import com.workintech.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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

    public User register(String email, String password, String username, Date birthOfDate) {
        //password  encode et
        String encodedPassword = passwordEncoder.encode(password);
        //user'a role tanımla
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUserName(username);
        user.setBirthOfDate(user.getBirthOfDate());
        return memberRepository.save(user);
    }

    public LoginResponse login(String email, String password) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));
            String token = tokenService.generateJwtToken(auth);
            return new LoginResponse(memberRepository.findMemberByEmail(email).get(), token);
        } catch (AuthenticationException ex) {
            return new LoginResponse(null, "");
        }

    }
}



