package org.wecode23.springboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.wecode23.springboot.domain.products.entities.Product;
import org.wecode23.springboot.domain.reviews.entities.Review;
import org.wecode23.springboot.domain.users.entities.User;

@NoArgsConstructor
@Getter
public class ReviewSaveRequestDto {

    private Long userId;
    @Setter
    private User user;
    private Long productId;
    @Setter
    private Product product;
    private Integer sizeRating;
    private Integer colorRating;
    private Integer deliveryRating;
    @Setter
    private String title;
    @Setter
    private String comment;

    @Builder
    public ReviewSaveRequestDto(Long userId, Long productId,
                                Integer sizeRating, Integer colorRating, Integer deliveryRating,
                                String title, String comment) {
        this.userId = userId;
        this.productId = productId;
        this.sizeRating = sizeRating;
        this.colorRating = colorRating;
        this.deliveryRating = deliveryRating;
        this.title = title;
        this.comment = comment;
    }

    public Review toEntity() {
        return Review.builder()
                .user(user)
                .product(product)
                .sizeRating(sizeRating)
                .colorRating(colorRating)
                .deliveryRating(deliveryRating)
                .comment(comment)
                .title(title)
                .build();
    }


}


