package org.wecode23.springboot.web;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wecode23.springboot.dto.CartResponseDto;
import org.wecode23.springboot.dto.CartSaveRequestDto;
import org.wecode23.springboot.service.CartService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

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

    @PatchMapping("/carts/{id}")
    public ResponseEntity<HashMap> updateCartItem(@PathVariable Long id, @RequestBody CartSaveRequestDto requestDto) {

        cartService.updateCartItem(id, requestDto);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("MESSAGE",MessageResponse.OK);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/carts")
    public List<CartResponseDto> getCartList(@RequestBody HashMap<String, Long> map) {

        return cartService.getCartList(map.get("userId"));
    }

    @DeleteMapping("/carts/{id}")
    public ResponseEntity<HashMap> deleteCartItem(@PathVariable Long id) {

        cartService.deleteCartItem(id);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("MESSAGE",MessageResponse.OK);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

}
