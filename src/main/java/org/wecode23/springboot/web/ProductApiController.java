package org.wecode23.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wecode23.springboot.domain.products.entities.Product;
import org.wecode23.springboot.dto.ProductListResponseDto;
import org.wecode23.springboot.dto.ProductResponseDto;
import org.wecode23.springboot.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/products/{id}")
    public ProductResponseDto findById (@PathVariable Long id) {

        return productService.findById(id);
    }

    @GetMapping("/products")
    public List<ProductListResponseDto> findByFilter (HttpServletRequest httpServletRequest) {

        return productService.findByFilter(httpServletRequest.getParameterMap());
    }
}
