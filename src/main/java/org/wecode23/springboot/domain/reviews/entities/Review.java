package org.wecode23.springboot.domain.reviews.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import org.wecode23.springboot.domain.products.entities.Product;
import org.wecode23.springboot.domain.users.entities.User;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @Column(name = "size_rating")
    private Integer sizeRating;

    @Column(name = "color_rating")
    private Integer colorRating;

    @Column(name = "delivery_rating")
    private Integer deliveryRating;

    @Column(name = "comment", length = 2000)
    private String comment;

    @Column(name = "title", length = 45)
    private String title;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;

    @Builder
    public Review(User user, Product product, Integer sizeRating,
                  Integer colorRating, Integer deliveryRating, String comment,
                  String title) {

        this.user           = user;
        this.product        = product;
        this.sizeRating     = sizeRating;
        this.colorRating    = colorRating;
        this.deliveryRating = deliveryRating;
        this.comment        = comment;
        this.title          = title;

    }
}
