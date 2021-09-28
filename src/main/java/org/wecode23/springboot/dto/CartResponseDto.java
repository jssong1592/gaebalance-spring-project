package org.wecode23.springboot.dto;

import lombok.Getter;
import org.wecode23.springboot.domain.carts.entities.Cart;

@Getter
public class CartResponseDto {

    private Long id;
    private String productName;
    private String productImageUrl;
    private String productColorName;
    private String sizeName;
    private Integer count;
    private Double price;

    public CartResponseDto(Cart entity) {
        this.id = entity.getId();;
        this.productName = entity.getProduct().getName();
        this.productImageUrl = entity.getProduct().getImageUrl();
        this.productColorName = entity.getProduct().getColor().getName();
        this.sizeName = entity.getSize().getName();
        this.count = entity.getCount();
        this.price = this.count * entity.getProduct().getPrice();

    }

}
