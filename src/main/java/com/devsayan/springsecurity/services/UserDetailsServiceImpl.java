package com.devsayan.springsecurity.services;

import com.devsayan.springsecurity.exceptions.ResourceNotFoundException;
import com.devsayan.springsecurity.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByEmail(username)
                .orElseThrow(()->new ResourceNotFoundException("user with "+ username +" not found!!"));
    }
}
