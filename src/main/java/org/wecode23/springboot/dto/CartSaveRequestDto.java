package org.wecode23.springboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.wecode23.springboot.domain.carts.entities.Cart;
import org.wecode23.springboot.domain.products.entities.Product;
import org.wecode23.springboot.domain.products.entities.Size;
import org.wecode23.springboot.domain.users.entities.User;

@NoArgsConstructor
@Getter
public class CartSaveRequestDto {

    private Long userId;
    private Long productId;
    private Long sizeId;
    private Integer count;

    @Setter
    private User user;
    @Setter
    private Product product;
    @Setter
    private Size size;

    @Builder
    public CartSaveRequestDto(Long userId, Long productId, Long sizeId,
                              Integer count) {
        this.userId = userId;
        this.productId = productId;
        this.sizeId = sizeId;
        this.count = count;
    }

    public Cart toEntity() {
        return Cart.builder()
                .user(user)
                .product(product)
                .size(size)
                .count(count)
                .build();
    }

}
