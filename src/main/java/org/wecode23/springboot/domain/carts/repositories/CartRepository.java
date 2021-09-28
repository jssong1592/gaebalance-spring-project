package org.wecode23.springboot.domain.carts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wecode23.springboot.domain.carts.entities.Cart;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserIdAndProductIdAndSizeId(Long userId, Long productId, Long sizeId);
}
