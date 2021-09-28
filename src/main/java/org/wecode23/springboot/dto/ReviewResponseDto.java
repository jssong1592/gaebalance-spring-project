package org.wecode23.springboot.dto;

import lombok.Getter;
import org.wecode23.springboot.domain.reviews.entities.Review;

@Getter
public class ReviewResponseDto {

    private Long userId;
    private Long productId;
    private Integer sizeRating;
    private Integer colorRating;
    private Integer deliveryRating;
    private Integer allRating;
    private String title;
    private String comment;

    public ReviewResponseDto(Review entity) {

        this.userId = entity.getUser().getId();
        this.productId = entity.getProduct().getId();
        this.sizeRating = entity.getSizeRating();
        this.colorRating = entity.getColorRating();
        this.deliveryRating = entity.getDeliveryRating();;
        this.allRating = (sizeRating + colorRating + deliveryRating) / 3;
        this.title = entity.getTitle();
        this.comment = entity.getComment();

    }
}
