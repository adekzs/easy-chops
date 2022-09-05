package com.easychops.easychops.security;

import com.easychops.easychops.model.EasyChopsUserDetails;
import com.easychops.easychops.model.User;
import com.easychops.easychops.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Configuration
@AllArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = userRepository.findUserByEmail(username);
        if (users.size() == 0) {
            throw  new UsernameNotFoundException("user does not exist");
        }
        return new EasyChopsUserDetails(users.get(0));
    }
}
