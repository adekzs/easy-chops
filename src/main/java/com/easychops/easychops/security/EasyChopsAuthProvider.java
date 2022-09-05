package com.easychops.easychops.security;

import com.easychops.easychops.model.User;
import com.easychops.easychops.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EasyChopsAuthProvider implements AuthenticationProvider {


    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        List<User> userList = userRepository.findUserByEmail(email);
        if (userList.size() > 0) {
            if (passwordEncoder.matches(pwd, userList.get(0).getPassword())) {
                List<GrantedAuthority> authorities = userList.get(0).getAuthorities()
                        .stream()
                        .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                        .collect(Collectors.toList());
                return new UsernamePasswordAuthenticationToken(email, pwd, authorities);
            } else {
                throw new BadCredentialsException("Invalid Password");
            }
        } else {
            throw new BadCredentialsException("No user registered with this details!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return false;
    }
}
