package com.devsayan.springsecurity.services;

import com.devsayan.springsecurity.dtos.SignupDto;
import com.devsayan.springsecurity.dtos.UserDto;
import com.devsayan.springsecurity.entities.User;
import com.devsayan.springsecurity.exceptions.ResourceNotFoundException;
import com.devsayan.springsecurity.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByEmail(username)
                .orElseThrow(()->new ResourceNotFoundException("user with "+ username +" not found!!"));
    }
    public UserDto signUp(SignupDto signupDto){
        Optional<User> user = userRepository.getUserByEmail(signupDto.getEmail());
        if(user.isPresent()){
            throw new BadCredentialsException("User with email already present"+ signupDto.getEmail());

        }
        User toCreate = userRepository.save(modelMapper.map(user,User.class));
        toCreate.setPassord(passwordEncoder.encode(toCreate.getPassword()));
        return modelMapper.map(toCreate,UserDto.class);
    }
}
