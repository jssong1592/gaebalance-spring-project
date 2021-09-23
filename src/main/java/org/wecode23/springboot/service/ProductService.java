package org.wecode23.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.wecode23.springboot.domain.products.entities.DetailImage;
import org.wecode23.springboot.domain.products.entities.Product;
import org.wecode23.springboot.domain.products.repositories.DetailImageRepository;
import org.wecode23.springboot.domain.products.repositories.ProductRepository;
import org.wecode23.springboot.dto.ProductResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final DetailImageRepository detailImageRepository;

    public ProductResponseDto findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = null;
        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();

        }

        List<DetailImage> detailImageList = detailImageRepository.findByProduct(product);
        ArrayList<String> urlList = new ArrayList<String>();
        for (DetailImage image : detailImageList) {
            urlList.add(image.getImageUrl());
        }
        ProductResponseDto productResponseDto = new ProductResponseDto(product);
        productResponseDto.setImageList(urlList);

        return productResponseDto;
    }
}


