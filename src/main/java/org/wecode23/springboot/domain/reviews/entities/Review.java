package org.wecode23.springboot.domain.reviews.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import org.wecode23.springboot.domain.products.entities.Product;
import org.wecode23.springboot.domain.users.entities.User;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    private Date createdAt;

}
