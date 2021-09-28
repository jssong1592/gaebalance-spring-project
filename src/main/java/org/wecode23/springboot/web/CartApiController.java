package org.wecode23.springboot.web;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecode23.springboot.dto.CartSaveRequestDto;
import org.wecode23.springboot.service.CartService;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
public class CartApiController {

    private final CartService cartService;

    @PostMapping("/carts")
    public ResponseEntity<HashMap> addCartItem(@RequestBody CartSaveRequestDto requestDto) {

        cartService.addCartItem(requestDto);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("MESSAGE",MessageResponse.CREATED);

        return ResponseEntity.status(HttpStatus.CREATED).body(map);

    }
}
