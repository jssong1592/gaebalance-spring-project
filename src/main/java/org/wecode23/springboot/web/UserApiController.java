package org.wecode23.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wecode23.springboot.dto.UserResponseDto;
import org.wecode23.springboot.dto.UserSaveRequestDto;
import org.wecode23.springboot.service.UserService;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public UserResponseDto findById (@PathVariable Long id) {

        return userService.findById(id);
    }

    @PostMapping("/signup")
    public ResponseEntity<HashMap> createUser(@RequestBody UserSaveRequestDto requestDto) {

        userService.createUser(requestDto);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("MESSAGE",MessageResponse.CREATED);

        return ResponseEntity.status(HttpStatus.CREATED).body(map);
    }


}
