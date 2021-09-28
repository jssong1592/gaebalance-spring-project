package org.wecode23.springboot.service;

import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.wecode23.springboot.domain.products.entities.DetailImage;
import org.wecode23.springboot.domain.products.entities.Product;
import org.wecode23.springboot.domain.products.repositories.DetailImageRepository;
import org.wecode23.springboot.domain.products.repositories.ProductQueryDSLRepository;
import org.wecode23.springboot.domain.products.repositories.ProductRepository;
import org.wecode23.springboot.dto.ProductListResponseDto;
import org.wecode23.springboot.dto.ProductResponseDto;

import java.util.*;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final DetailImageRepository detailImageRepository;
    private final ProductQueryDSLRepository productQueryDSLRepository;

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

    public List<ProductListResponseDto> findByFilter(Map<String, String[]> param) {
        List<Product> productList = productQueryDSLRepository.findByFilter(param);
        List<ProductListResponseDto> productListResponseDtoList = new ArrayList<>();
        if(!productList.isEmpty()) {
            for (Product product : productList) {
                ProductListResponseDto productListResponseDto = new ProductListResponseDto(product);
//                productListResponseDto.setStock();
                productListResponseDtoList.add(productListResponseDto);
            }
        }
        return productListResponseDtoList;
    }
}


