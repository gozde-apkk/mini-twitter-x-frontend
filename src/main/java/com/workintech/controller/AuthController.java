package com.workintech.controller;


import com.workintech.dto.LoginRequest;
import com.workintech.dto.LoginResponse;
import com.workintech.dto.RegistrationMember;
import com.workintech.entity.User;
import com.workintech.exception.EmailAlreadyTakenException;
import com.workintech.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationService authenticationService;
    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/")
    public String hello() {
        return  "Port is running";
    }
    @ExceptionHandler({EmailAlreadyTakenException.class})
    public ResponseEntity<String> handleEmailTaken(){
        return new ResponseEntity<String>("The email you  provided is already in use", HttpStatus.CONFLICT);
    }


    @PostMapping("/register")
    public User register(@RequestBody RegistrationMember registrationMember){
     return  authenticationService.register(registrationMember.getEmail(),registrationMember.getPassword(),
             registrationMember.getUsername(),registrationMember.getBirthOfDate());
    }

    @PostMapping("/login")
    public LoginResponse register(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest.getEmail(),loginRequest.getPassword());
    }
    @GetMapping("/logout")
    public String logout (HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login?logout";
    }


}
