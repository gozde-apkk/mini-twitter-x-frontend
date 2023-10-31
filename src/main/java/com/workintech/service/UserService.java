package com.workintech.service;



import com.workintech.dao.UserRepository;
import com.workintech.dao.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService  {
    private UserRepository memberRepository;
    private RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findMemberByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User is not valid"));
    }


}
