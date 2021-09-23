package org.wecode23.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecode23.springboot.dto.ProductResponseDto;
import org.wecode23.springboot.service.ProductService;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/products/{id}")
    public ProductResponseDto findById (@PathVariable Long id) {

        return productService.findById(id);
    }

}
