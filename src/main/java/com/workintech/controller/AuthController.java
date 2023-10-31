package com.workintech.controller;


import com.workintech.exception.EmailAlreadyTakenException;
import com.workintech.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationService authenticationService;
    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @ExceptionHandler({EmailAlreadyTakenException.class})
    public ResponseEntity<String> handleEmailTaken(){
        return new ResponseEntity<String>("The email you  provided is already in use", HttpStatus.CONFLICT);
    }

/*
    @PostMapping("/register")
    public Member register(@RequestBody RegistrationMember registrationMember){
       try {
           return authenticationService.register(
                   registrationMember.getEmail(),
                   registrationMember.getPassword(),
                   registrationMember.getUsername(),
                   registrationMember.getFirstName(),
                   registrationMember.getLastName(),
                   registrationMember.getBirthOfDate());
       }catch (Exception e){
           throw new EmailAlreadyTakenException();
       }
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
    */

}
