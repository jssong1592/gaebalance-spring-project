package org.wecode23.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wecode23.springboot.domain.carts.entities.Cart;
import org.wecode23.springboot.domain.carts.repositories.CartRepository;
import org.wecode23.springboot.domain.products.repositories.ProductRepository;
import org.wecode23.springboot.domain.products.repositories.SizeRepository;
import org.wecode23.springboot.domain.users.repositories.UserRepository;
import org.wecode23.springboot.dto.CartSaveRequestDto;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final SizeRepository sizeRepository;

    @Transactional
    public Long addCartItem(CartSaveRequestDto requestDto) {

        Optional<Cart> cart = cartRepository.findByUserIdAndProductIdAndSizeId(
                requestDto.getUserId(), requestDto.getProductId(), requestDto.getSizeId());

        if (cart.isPresent()) {

            cart.get().increaseCount(requestDto.getCount());
            return cart.get().getId();

        } else {

            requestDto.setUser(userRepository.findById(requestDto.getUserId()).get());
            requestDto.setProduct(productRepository.findById(requestDto.getProductId()).get());
            requestDto.setSize(sizeRepository.findById(requestDto.getSizeId()).get());

            return cartRepository.save(requestDto.toEntity()).getId();

        }
    }
}
