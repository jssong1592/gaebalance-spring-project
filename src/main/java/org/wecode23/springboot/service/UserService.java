package org.wecode23.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.wecode23.springboot.domain.products.repositories.SizeRepository;
import org.wecode23.springboot.domain.users.entities.User;
import org.wecode23.springboot.domain.users.repositories.UserRepository;
import org.wecode23.springboot.dto.UserResponseDto;
import org.wecode23.springboot.dto.UserSaveRequestDto;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final SizeRepository sizeRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public UserResponseDto findById (Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        return new UserResponseDto(user);
    }

    @Transactional
    public Long createUser(UserSaveRequestDto requestDto) {

        requestDto.setSize(sizeRepository.findById(requestDto.getSizeId()).get());

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        requestDto.setPassword(encodedPassword);

        return userRepository.save(requestDto.toEntity()).getId();
    }


}
