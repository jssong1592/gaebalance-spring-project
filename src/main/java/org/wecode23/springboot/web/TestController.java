package org.wecode23.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecode23.springboot.dto.UsersResponseDto;
import org.wecode23.springboot.service.UsersService;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final UsersService usersService;

    @GetMapping("/users/{id}")
    public UsersResponseDto findById (@PathVariable Long id) {

        return usersService.findById(id);
    }

}
