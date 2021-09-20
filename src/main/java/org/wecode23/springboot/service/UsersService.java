package org.wecode23.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.wecode23.springboot.domain.users.entities.User;
import org.wecode23.springboot.domain.users.repositories.UserRepository;
import org.wecode23.springboot.dto.UsersResponseDto;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UserRepository userRepository;

    public UsersResponseDto findById (Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        return new UsersResponseDto(user);
    }

}
