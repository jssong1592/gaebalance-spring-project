package org.wecode23.springboot.domain.carts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wecode23.springboot.domain.carts.entities.Cart;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUserId(Long id);

    Optional<Cart> findByUserIdAndProductIdAndSizeId(Long userId, Long productId, Long sizeId);
}
